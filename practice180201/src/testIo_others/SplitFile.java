package testIo_others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {
	//路径
	private String filePath;
	//文件名
	private String fileName;
	//文件的大小
	private long length;
	//块数
	private int size;
	//每块的大小
	private long blockSize;
	//每块的名称
	private List<String> blockPath;
	//分割后文件的存放目录
	private String destBlockPath;
	/**
	 * 构造器初始化参数
	 */
	public SplitFile() {
		blockPath = new ArrayList<String>();
	}
	public SplitFile(String filePath,String destBlockPath) {
		this(filePath,destBlockPath,1024);
	}
	public SplitFile(String filePath,String destBlockPath,long blockSize) {
		this();
		this.filePath = filePath;
		this.destBlockPath = destBlockPath;
		this.blockSize = blockSize;
		init();
	}
	/**
	 * 初始化操作 计算块数、确定文件名
	 */
	public void init() {
		File src = null;
		//健壮性
		if(null==filePath||!(src=new File(filePath)).exists()) {
			return;
		}
		if(src.isDirectory()) {
			return;
		}
		//文件名
		this.fileName = src.getName();
		//计算块数 实际大小 与每块大小
		this.length = src.length();
		//修正 每块大小
		if(length<this.blockSize) {
			this.blockSize = length;
		}
		//确定块数 为什么要乘以1.0？因为都为int类型会忽略小数
		size = (int) Math.ceil(length*1.0/this.blockSize);
		//确定分割后文件的路径
		initPathName();
	}
	public void initPathName() {
		for(int i=0;i<size;i++) {
			//fileName为带有文件后缀的全称，故使用substring方法截取
			this.blockPath.add(destBlockPath+"/"+this.fileName.substring(0, fileName.lastIndexOf("."))+"part"+i);
		}
	}
	
	/**
	 * 文件的分割
	 * 0）、第几块
	 * 1）、起始位置
	 * 2）、实际大小
	 * @param destPath 分割文件存放目录
	 */
	 public void split(String destPath) {
		 long beginPos = 0;	//起始点
		 long actualBlockSize =blockSize;//实际分割块的大小
		 //计算所有块的位置 大小 索引
		 for(int i=0;i<size;i++) {
			 if(i==size-1) {//如果为最后一块
				 actualBlockSize = this.length-beginPos;
			 }
			 spiltDetail(i, beginPos, actualBlockSize);
			 beginPos+=actualBlockSize;
		 }
		 
	 }
	 /**
	  * 文件的分割 输入 输出
	  * 文件拷贝
	  * @param idx 第几块
	  * @param beginPos 起始点
	  * @param actualBlockSize 实际大小
	  */
	 public void  spiltDetail(int idx,long beginPos,long actualBlockSize) {
		 File src = new File(this.filePath);			//源文件
		 File dest = new File(this.blockPath.get(idx));	//通过索引找List对象里的目标文件
		 //选择流
		 RandomAccessFile raf = null;		//输入流
		 BufferedOutputStream bos = null;	//输出流
		 try {
			raf = new RandomAccessFile(src, "r");//"r"为只读方式 "rw"为读写方式
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			//读取文件
			raf.seek(beginPos);
			//缓存区
			byte[] flush = new byte[1024];
			//接受长度
			int len=0;
			while(-1!=(len=raf.read(flush))) {
				if(actualBlockSize-len>=0) {	//查看是否足够
					//写出
					bos.write(flush, 0, len);
					actualBlockSize-=len;//剩余量
				}else {	//写出剩余量
					bos.write(flush, 0, (int)actualBlockSize);
					break;
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			testIo_util.FileUtil.close(bos);
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
		 BufferedInputStream bis = null;
		 try {
			bos = new BufferedOutputStream(new FileOutputStream(dest,true));	//追加
			for (int i = 0; i < this.blockPath.size(); i++) {
				bis = new BufferedInputStream(new FileInputStream(new File(blockPath.get(i))));
				//缓存区
				byte[] flush = new byte[1024];
				//接受长度
				int len=0;
				while(-1!=(len=bis.read(flush))) {
					bos.write(flush, 0, len);
				}
				bos.flush();
				testIo_util.FileUtil.close(bis);
			} 
		} catch (Exception e) {
		} finally {
			testIo_util.FileUtil.close(bos);
		}

	 }
	 public void merge(String destPath) {
		 //创建源
		 File dest = new File(destPath);
		 //选择流
		 BufferedOutputStream bos = null;	//输出流
		 SequenceInputStream sis = null;	//输入流
		 //创建一个容器
		 Vector<InputStream> vt = new Vector<>();
		 try {
			 for(int i=0;i<blockPath.size();i++) {
				 vt.add(new BufferedInputStream(new FileInputStream(new File(blockPath.get(i)))));
			 }
			 bos = new BufferedOutputStream(new FileOutputStream(dest,true));	//追加
			 sis = new SequenceInputStream(vt.elements());
			 //缓冲区
			 byte[] flush = new byte[1024];
			 //接受长度
			 int len=0;
			 while(-1!=(len=sis.read(flush))) {
				 bos.write(flush, 0, len);
			 }
			 bos.flush();
			 testIo_util.FileUtil.close(sis);
		 } catch (Exception e) {
		 } finally {
			 testIo_util.FileUtil.close(bos);
		 }
		 
	 }
	public static void main(String[] args) {
		SplitFile sf = new SplitFile("F:/图片/用途/JAVA相关/Plane/test01.txt","F:/图片/用途/JAVA相关/Plane/testSplit", 50);
//		System.out.println(sf.size);
		sf.split("F:/图片/用途/JAVA相关/Plane/testSplit");
		sf.mergeFile("F:/图片/用途/JAVA相关/Plane/testSplit/test01.txt");
		sf.merge("F:/图片/用途/JAVA相关/Plane/testSplit/test02.txt");
		
	}
}
