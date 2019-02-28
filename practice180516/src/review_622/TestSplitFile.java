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
		//·��
	private String filePath;
		//�ļ���
	private String fileName;
		//�ļ��Ĵ�С
	private long length;
		//����
	private int size;
		//ÿ��Ĵ�С
	private long blockSize;
		//ÿ�������
	private List<String> blockPath;
		//�ָ���ļ��Ĵ��Ŀ¼
	private String destBlockPath;
		/**
		 * ��������ʼ������
		 * �����ļ���Դ��ַ�����շָ�Ĺ����ػ�����ṩ�и��Ĵ�С��Ĭ��1024
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
		 * ��ʼ������ ���������ȷ���ļ���
		 */
		public void init() {
			File src = null;
			//��׳�ԣ��ų��ļ������ں��ļ�Ϊ�ļ��е����
			if(null==filePath||!(src=new File(filePath)).exists()) {
				return;
			}
			if(src.isDirectory()) {
				return;
			}
			//�ļ���
			this.fileName = src.getName();
			//ȷ���ָ�����ͷָ�ʵ�ʴ�С
			//�ļ��Ĵ�С
			this.length = src.length();
			if(length<blockSize) {
				//����и�ĳߴ����ʵ�ʴ�С�����и��趨Ϊʵ�ʴ�С
				this.blockSize = length;
			}
			this.size = (int)Math.ceil(length*1.0/this.blockSize);
			//�ָ����ļ�������ַ
			initPathName();
		}
		/**
		 * �ָ���ļ��Ĺ�����ַ�ĳ�ʼ��
		 */
		public void initPathName() {
			//�����ж��ٿ�����������ַ
			for(int i=0;i<size;i++) {
				this.blockPath.add(destBlockPath+"/"+this.fileName+".part"+i);
			}
		}
		
		/**
		 * �ļ��ķָ�
		 * 0�����ڼ���
		 * 1������ʼλ��
		 * 2����ʵ�ʴ�С
		 * @param destPath �ָ��ļ����Ŀ¼
		 */
		 public void split(String destPath) {
			 //��ʼ��
			 long beginPoint = 0;
			 //ʵ�ʷָ��С
			 long actualSplitSize = this.blockSize;
			 //�������п飬��ʼ����ָ���ʼλ�úͷָ��С
			 for(int i=0;i<size;i++) {
				 //���ǵ����һ��ķָ�ʵ�ʴ�СС���趨�ָ��С��Ҫ����
				 if(size-1==i) {
					 actualSplitSize = this.length-beginPoint;
				 }
				 //ÿ����ļ��ľ���ָ� �ڼ��顢��ʼ�ָ�㡢�ָ�Ĵ�С
				 spiltDetail(i,beginPoint,actualSplitSize);
				 beginPoint+=actualSplitSize;
			 }
		 }
		 /**
		  * �ļ��ķָ� ���� ���
		  * �ļ�����
		  * @param idx �ڼ���
		  * @param beginPoint ��ʼ��
		  * @param actualSplitSize ʵ�ʴ�С
		  */
		 public void  spiltDetail(int idx,long beginPoint,long actualSplitSize) {
			 //�ļ�Դͷ
			 File src = new File(this.filePath);
			 //�ļ�������ַ
			 File dest = new File(this.blockPath.get(idx));
			 //ѡ����
			 RandomAccessFile raf = null;
			 BufferedOutputStream bos = null;
			 try {
				raf = new RandomAccessFile(src, "r");
				bos = new BufferedOutputStream(new FileOutputStream(dest));
				//Ѱ�ҵ��ָ���ʼ��
				raf.seek(beginPoint);
				byte[] flush = new byte[1024];
				int len =0;
				while(-1!=(len=raf.read(flush))) {
					//���ǵ����һ��ʵ���и��С����С�ڻ�����ֽ����飬�����жϺ�����
					if(actualSplitSize>len) {
						bos.write(flush,0,len);
						//ÿ�ζ�ȡ��Ҫ�ѳߴ���С,�൱�����ڽ�ȡ��һ������С���������и�����и����һ������
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
				//�ر�������ȫ
				review_622.FileUtil.close(raf,bos);
			}
		 }
		 /**
		  * �ļ��ĺϲ�
		  */
		 public void mergeFile(String destPath) {
			 BufferedOutputStream bos = null;
			 BufferedInputStream bis = null;
			 try {
				 //�������ļ�Ҫ���ۼӣ������ȡ�ٶ࣬���ᱻ���ǣ���true
				bos = new BufferedOutputStream(new FileOutputStream(new File(destPath),true));
				//��ΪҪ��ȡ���ļ��࣬ʹ��forѭ��
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
			 //����Դ
			 //ѡ����
			 //����һ������
		 }
		public static void main(String[] args) {
			TestSplitFile sf = new TestSplitFile("F:/ͼƬ/��;/JAVA���/Plane/test01.txt","F:/ͼƬ/��;/JAVA���/Plane/testSplit", 50);
//			System.out.println(sf.size);
//			sf.split("F:/ͼƬ/��;/JAVA���/Plane/testSplit");
			sf.mergeFile("F:/ͼƬ/��;/JAVA���/Plane/testSplit/test04.txt");
//			sf.merge("F:/ͼƬ/��;/JAVA���/Plane/testSplit/test03.txt");
			
		}

}
