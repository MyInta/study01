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
	 * ��ʼ������ ���������ȷ���ļ���
	 */
	public void init() {
		File src = null;
		//��׳��
		if(null==filePath||!(src=new File(filePath)).exists()) {
			return;
		}
		if(src.isDirectory()) {
			return;
		}
		//�ļ���
		this.fileName = src.getName();
		//������� ʵ�ʴ�С ��ÿ���С
		this.length = src.length();
		//���� ÿ���С
		if(length<this.blockSize) {
			this.blockSize = length;
		}
		//ȷ������ ΪʲôҪ����1.0����Ϊ��Ϊint���ͻ����С��
		size = (int) Math.ceil(length*1.0/this.blockSize);
		//ȷ���ָ���ļ���·��
		initPathName();
	}
	public void initPathName() {
		for(int i=0;i<size;i++) {
			//fileNameΪ�����ļ���׺��ȫ�ƣ���ʹ��substring������ȡ
			this.blockPath.add(destBlockPath+"/"+this.fileName.substring(0, fileName.lastIndexOf("."))+"part"+i);
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
		 long beginPos = 0;	//��ʼ��
		 long actualBlockSize =blockSize;//ʵ�ʷָ��Ĵ�С
		 //�������п��λ�� ��С ����
		 for(int i=0;i<size;i++) {
			 if(i==size-1) {//���Ϊ���һ��
				 actualBlockSize = this.length-beginPos;
			 }
			 spiltDetail(i, beginPos, actualBlockSize);
			 beginPos+=actualBlockSize;
		 }
		 
	 }
	 /**
	  * �ļ��ķָ� ���� ���
	  * �ļ�����
	  * @param idx �ڼ���
	  * @param beginPos ��ʼ��
	  * @param actualBlockSize ʵ�ʴ�С
	  */
	 public void  spiltDetail(int idx,long beginPos,long actualBlockSize) {
		 File src = new File(this.filePath);			//Դ�ļ�
		 File dest = new File(this.blockPath.get(idx));	//ͨ��������List�������Ŀ���ļ�
		 //ѡ����
		 RandomAccessFile raf = null;		//������
		 BufferedOutputStream bos = null;	//�����
		 try {
			raf = new RandomAccessFile(src, "r");//"r"Ϊֻ����ʽ "rw"Ϊ��д��ʽ
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			//��ȡ�ļ�
			raf.seek(beginPos);
			//������
			byte[] flush = new byte[1024];
			//���ܳ���
			int len=0;
			while(-1!=(len=raf.read(flush))) {
				if(actualBlockSize-len>=0) {	//�鿴�Ƿ��㹻
					//д��
					bos.write(flush, 0, len);
					actualBlockSize-=len;//ʣ����
				}else {	//д��ʣ����
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
	  * �ļ��ĺϲ�
	  */
	 public void mergeFile(String destPath) {
		 //����Դ
		 File dest = new File(destPath);
		 //ѡ����
		 BufferedOutputStream bos = null;	//�����
		 BufferedInputStream bis = null;
		 try {
			bos = new BufferedOutputStream(new FileOutputStream(dest,true));	//׷��
			for (int i = 0; i < this.blockPath.size(); i++) {
				bis = new BufferedInputStream(new FileInputStream(new File(blockPath.get(i))));
				//������
				byte[] flush = new byte[1024];
				//���ܳ���
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
		 //����Դ
		 File dest = new File(destPath);
		 //ѡ����
		 BufferedOutputStream bos = null;	//�����
		 SequenceInputStream sis = null;	//������
		 //����һ������
		 Vector<InputStream> vt = new Vector<>();
		 try {
			 for(int i=0;i<blockPath.size();i++) {
				 vt.add(new BufferedInputStream(new FileInputStream(new File(blockPath.get(i)))));
			 }
			 bos = new BufferedOutputStream(new FileOutputStream(dest,true));	//׷��
			 sis = new SequenceInputStream(vt.elements());
			 //������
			 byte[] flush = new byte[1024];
			 //���ܳ���
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
		SplitFile sf = new SplitFile("F:/ͼƬ/��;/JAVA���/Plane/test01.txt","F:/ͼƬ/��;/JAVA���/Plane/testSplit", 50);
//		System.out.println(sf.size);
		sf.split("F:/ͼƬ/��;/JAVA���/Plane/testSplit");
		sf.mergeFile("F:/ͼƬ/��;/JAVA���/Plane/testSplit/test01.txt");
		sf.merge("F:/ͼƬ/��;/JAVA���/Plane/testSplit/test02.txt");
		
	}
}
