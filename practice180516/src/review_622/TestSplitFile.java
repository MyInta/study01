package review_622;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class TestSplitFile {
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
		 * 传入文件来源地址和最终分割的归属地或额外提供切割块的大小，默认1024
		 */
	private TestSplitFile() {
		blockPath = new ArrayList<String>();
	}
	public TestSplitFile(String filePath,String destBlockPath) {
		this(filePath,destBlockPath,1024);
	}
	public TestSplitFile(String filePath,String destBlockPath,long blockSize) {
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
			//健壮性，排除文件不存在和文件为文件夹的情况
			if(null==filePath||!(src=new File(filePath)).exists()) {
				return;
			}
			if(src.isDirectory()) {
				return;
			}
			//文件名
			this.fileName = src.getName();
			//确定分割块数和分割实际大小
			//文件的大小
			this.length = src.length();
			if(length<blockSize) {
				//如果切割的尺寸大于实际大小，则将切割设定为实际大小
				this.blockSize = length;
			}
			this.size = (int)Math.ceil(length*1.0/this.blockSize);
			//分割后的文件归属地址
			initPathName();
		}
		/**
		 * 分割后文件的归属地址的初始化
		 */
		public void initPathName() {
			//按照有多少块数来决定地址
			for(int i=0;i<size;i++) {
				this.blockPath.add(destBlockPath+"/"+this.fileName+".part"+i);
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
			 //起始点
			 long beginPoint = 0;
			 //实际分割大小
			 long actualSplitSize = this.blockSize;
			 //遍历所有块，初始化其分割起始位置和分割大小
			 for(int i=0;i<size;i++) {
				 //考虑到最后一块的分割实际大小小于设定分割大小，要修正
				 if(size-1==i) {
					 actualSplitSize = this.length-beginPoint;
				 }
				 //每块的文件的具体分割 第几块、起始分割点、分割的大小
				 spiltDetail(i,beginPoint,actualSplitSize);
				 beginPoint+=actualSplitSize;
			 }
		 }
		 /**
		  * 文件的分割 输入 输出
		  * 文件拷贝
		  * @param idx 第几块
		  * @param beginPoint 起始点
		  * @param actualSplitSize 实际大小
		  */
		 public void  spiltDetail(int idx,long beginPoint,long actualSplitSize) {
			 //文件源头
			 File src = new File(this.filePath);
			 //文件归属地址
			 File dest = new File(this.blockPath.get(idx));
			 //选择流
			 RandomAccessFile raf = null;
			 BufferedOutputStream bos = null;
			 try {
				raf = new RandomAccessFile(src, "r");
				bos = new BufferedOutputStream(new FileOutputStream(dest));
				//寻找到分割起始点
				raf.seek(beginPoint);
				byte[] flush = new byte[1024];
				int len =0;
				while(-1!=(len=raf.read(flush))) {
					//考虑到最后一段实际切割大小可能小于缓冲的字节数组，故做判断和修正
					if(actualSplitSize>len) {
						bos.write(flush,0,len);
						//每次读取后，要把尺寸缩小,相当于是在截取的一段中用小缓冲数组切割，存在切割最后一块的情况
						actualSplitSize-=len;
					}else{
						bos.write(flush,0,(int)actualSplitSize);
						break;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				//关闭流，安全
				review_622.FileUtil.close(raf,bos);
			}
		 }
		 /**
		  * 文件的合并
		  */
		 public void mergeFile(String destPath) {
			 BufferedOutputStream bos = null;
			 BufferedInputStream bis = null;
			 try {
				 //传出的文件要可累加，否则读取再多，都会被覆盖，用true
				bos = new BufferedOutputStream(new FileOutputStream(new File(destPath),true));
				//因为要读取的文件多，使用for循环
				for(int i=0;i<blockPath.size();i++) {
					bis = new BufferedInputStream(
							new FileInputStream(
									new File(blockPath.get(i))));
					byte[] flush = new byte[1024];
					int len = 0;
					while(-1!=(len=bis.read(flush))) {
						bos.write(flush,0,len);
					}
					bos.flush();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				review_622.FileUtil.close(bis,bos);
			}
		 }
		 public void merge(String destPath) {
			 //创建源
			 //选择流
			 //创建一个容器
		 }
		public static void main(String[] args) {
			TestSplitFile sf = new TestSplitFile("F:/图片/用途/JAVA相关/Plane/test01.txt","F:/图片/用途/JAVA相关/Plane/testSplit", 50);
//			System.out.println(sf.size);
//			sf.split("F:/图片/用途/JAVA相关/Plane/testSplit");
			sf.mergeFile("F:/图片/用途/JAVA相关/Plane/testSplit/test04.txt");
//			sf.merge("F:/图片/用途/JAVA相关/Plane/testSplit/test03.txt");
			
		}

}
