package review_test01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 * 文件分割存储
 * 文件合并贮存
 * @author 银涛
 *
 */
public class TestSplitFile {
	
	//文件源
	private String sourcePath;
	//文件目的地
	private String destPath;
	//文件名
	private String fileName;
	//文件的大小
	private long fileLength;
	//分割块的大小
	private long blockSize;
	//分割块数
	private int size;
	//分割后的零散文件的命名规范
	private List<String> blockPath;
	
	/**
	 * 初始化空构造器,并私有化，不让外界调用
	 */
	private TestSplitFile(){
		blockPath = new ArrayList<>();
	}
	/**
	 * 带参构造器初始化，默认切割尺寸为1024字节
	 * @param sourcePath 将要切割的文件路径
	 * @param destPath 切割后的文件存放路径
	 */
	public TestSplitFile(String sourcePath,String destPath) {
		//调用完整参数的构造器方法，导入默认切割尺寸1024字节
		this(sourcePath,destPath,1024);
	}
	/**
	 * 带有切割尺寸的构造器
	 * @param sourcePath 将要切割的文件路径
	 * @param destPath 切割后的文件存放路径
	 * @param blockSize 切割的尺寸
	 */
	public TestSplitFile(String sourcePath,String destPath,long blockSize) {
		this();
		this.sourcePath = sourcePath;
		this.destPath = destPath;
		this.blockSize = blockSize;
		init();
	}
	/**
	 * 初始化参数,计算块数，确定文件名
	 */
	private void init() {
		File src = null;
		//健壮性 路径为空或者该路径下无文件存在
		if(null==sourcePath||!(src=new File(sourcePath)).exists()) {
			return;
		}
		//如果是文件夹，那么抱歉，也不允许切割
		if(src.isDirectory()) {
			return;
		}
		//初始化参数 在构造器中已经初始化了源路径和目的地以及切割块大小
		this.fileName = src.getName();
		this.fileLength = src.length();
		//校正切割块的大小。如果比文件还大那就是文件大小咯
		if(blockSize>this.fileLength) {
			blockSize = fileLength;
		}
		//计算块数
		this.size = (int) Math.ceil(this.fileLength*1.0/this.blockSize);
		//确定分割后文件的命名
		for(int i=0;i<size;i++) {
			this.blockPath.add(destPath+"/"+fileName.substring(0, fileName.lastIndexOf("."))+"part"+i);
		}
	}
	
	/**
	 * 文件分割
	 */
	public void split() {
		//切割起始点0
		long beginPoint = 0;
		//考虑到实际分割到最后，实际分割尺寸会变,新设一个变量
		long actualBlockSize = this.blockSize;
		for(int i=0;i<size;i++) {
			//如果是最后一块，获得实际切割大小
			if(size-1==i) {
				actualBlockSize=this.fileLength-beginPoint;
			}
			splitDetails(i,beginPoint,actualBlockSize);
			beginPoint+=actualBlockSize;
		}
	}
	
	/**
	 * 分割细节
	 * @param idx 索引次序分割
	 * @param beginPoint 分割起始点
	 * @param actualBlockSize 分割块大小
	 */
	public void splitDetails(int idx,long beginPoint,long actualBlockSize) {
		//注意其和init中不一样，因为是方法内部变量，不共享资源
		File src = new File(this.sourcePath);
		//每个分割后的文件路径名早已经准备好在了容器内，取出来即可(由此衍生出至少两种方式)
		File dest = new File(this.blockPath.get(idx));
		//获得流
		RandomAccessFile raf = null;
		BufferedOutputStream bos = null;
		try {
			raf = new RandomAccessFile(src, "r");
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			//读取文件
			raf.seek(beginPoint);
			byte[] flush = new byte[1024];
			int len=0;
			while(-1!=(len=raf.read(flush))) {//不要漏了flush，否则内容传达不到
				//因为切割后文件会变小，查看是否足够实际切割输出
				if(actualBlockSize-len>=0) {
					bos.write(flush, 0, len);
					actualBlockSize-=len;
				}else {
					bos.write(flush, 0, (int) actualBlockSize);
					break;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			TSF_CloseMethods.closeAll(raf,bos);
		}
		
	}
	/**
	 * 文件的合并
	 */
	public void merge(String destPath) {
		File dest = new File(destPath);
		//获得流
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(dest,true));//true追加
			byte[] flush = new byte[1024];
			for(int i=0;i<blockPath.size();i++) {
				bis = new BufferedInputStream(new FileInputStream(new File(blockPath.get(i))));
				int len=0;
				while(-1!=(len=bis.read(flush))) {
					bos.write(flush, 0, len);
				}
				TSF_CloseMethods.close(bis);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			TSF_CloseMethods.close(bos);
		}
		
	}
	 /**
	  * 文件的合并
	  */
	 public void mergeFile(String destPath) {
		 //创建源
		 File dest = new File(destPath);
		 //选择流
		 BufferedOutputStream bos = null;	//输出流
		 SequenceInputStream sis = null;		//有序输入流
		 //创建一个输出流容器
		 Vector<InputStream> vt = new Vector<>();
		 try {
			 //往容器中注入流
			 for(int i=0;i<blockPath.size();i++) {
				 vt.add(new BufferedInputStream(new FileInputStream(new File(blockPath.get(i)))));
			 }
			 bos = new BufferedOutputStream(new FileOutputStream(dest,true));	//追加
			 sis = new SequenceInputStream(vt.elements());	//将容器储存的流导出到队列流中
			 byte[] flush = new byte[1024];
			 int len = 0;
			 while(-1!=(len=sis.read(flush))) {
				 bos.write(flush, 0, len);
			 }
			 bos.flush();
		 } catch (Exception e) {
		} finally {
			TSF_CloseMethods.close(sis,bos);
		}

	 }
	
	public static void main(String[] args) {
		//注意，别搞事情，分割的是字节数而不是kb也不是m！
		TestSplitFile sf = new TestSplitFile("F:/图片/用途/JAVA相关/Plane/SplitTest.txt","F:/图片/用途/JAVA相关/Plane/testSplit", 50);
//		sf.split();
//		sf.merge("F:/图片/用途/JAVA相关/Plane/testSplit/test03.txt");
		sf.mergeFile("F:/图片/用途/JAVA相关/Plane/testSplit/test04.txt");
		
	}
	
}

class TSF_CloseMethods{
	//关闭流方法一：使用可变参数
	public static void closeAll(Closeable ...io) {
		for(Closeable temp:io) {
			if(null!=temp) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//关闭流方法二：使用泛型
	@SafeVarargs
	public static <T extends Closeable>void close(T ...io) { 
		for(Closeable temp:io) {
			if(null!=temp) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
