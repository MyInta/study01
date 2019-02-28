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
 * �ļ��ָ�洢
 * �ļ��ϲ�����
 * @author ����
 *
 */
public class TestSplitFile {
	
	//�ļ�Դ
	private String sourcePath;
	//�ļ�Ŀ�ĵ�
	private String destPath;
	//�ļ���
	private String fileName;
	//�ļ��Ĵ�С
	private long fileLength;
	//�ָ��Ĵ�С
	private long blockSize;
	//�ָ����
	private int size;
	//�ָ�����ɢ�ļ��������淶
	private List<String> blockPath;
	
	/**
	 * ��ʼ���չ�����,��˽�л�������������
	 */
	private TestSplitFile(){
		blockPath = new ArrayList<>();
	}
	/**
	 * ���ι�������ʼ����Ĭ���и�ߴ�Ϊ1024�ֽ�
	 * @param sourcePath ��Ҫ�и���ļ�·��
	 * @param destPath �и����ļ����·��
	 */
	public TestSplitFile(String sourcePath,String destPath) {
		//�������������Ĺ���������������Ĭ���и�ߴ�1024�ֽ�
		this(sourcePath,destPath,1024);
	}
	/**
	 * �����и�ߴ�Ĺ�����
	 * @param sourcePath ��Ҫ�и���ļ�·��
	 * @param destPath �и����ļ����·��
	 * @param blockSize �и�ĳߴ�
	 */
	public TestSplitFile(String sourcePath,String destPath,long blockSize) {
		this();
		this.sourcePath = sourcePath;
		this.destPath = destPath;
		this.blockSize = blockSize;
		init();
	}
	/**
	 * ��ʼ������,���������ȷ���ļ���
	 */
	private void init() {
		File src = null;
		//��׳�� ·��Ϊ�ջ��߸�·�������ļ�����
		if(null==sourcePath||!(src=new File(sourcePath)).exists()) {
			return;
		}
		//������ļ��У���ô��Ǹ��Ҳ�������и�
		if(src.isDirectory()) {
			return;
		}
		//��ʼ������ �ڹ��������Ѿ���ʼ����Դ·����Ŀ�ĵ��Լ��и���С
		this.fileName = src.getName();
		this.fileLength = src.length();
		//У���и��Ĵ�С��������ļ������Ǿ����ļ���С��
		if(blockSize>this.fileLength) {
			blockSize = fileLength;
		}
		//�������
		this.size = (int) Math.ceil(this.fileLength*1.0/this.blockSize);
		//ȷ���ָ���ļ�������
		for(int i=0;i<size;i++) {
			this.blockPath.add(destPath+"/"+fileName.substring(0, fileName.lastIndexOf("."))+"part"+i);
		}
	}
	
	/**
	 * �ļ��ָ�
	 */
	public void split() {
		//�и���ʼ��0
		long beginPoint = 0;
		//���ǵ�ʵ�ʷָ���ʵ�ʷָ�ߴ���,����һ������
		long actualBlockSize = this.blockSize;
		for(int i=0;i<size;i++) {
			//��������һ�飬���ʵ���и��С
			if(size-1==i) {
				actualBlockSize=this.fileLength-beginPoint;
			}
			splitDetails(i,beginPoint,actualBlockSize);
			beginPoint+=actualBlockSize;
		}
	}
	
	/**
	 * �ָ�ϸ��
	 * @param idx ��������ָ�
	 * @param beginPoint �ָ���ʼ��
	 * @param actualBlockSize �ָ���С
	 */
	public void splitDetails(int idx,long beginPoint,long actualBlockSize) {
		//ע�����init�в�һ������Ϊ�Ƿ����ڲ���������������Դ
		File src = new File(this.sourcePath);
		//ÿ���ָ����ļ�·�������Ѿ�׼�������������ڣ�ȡ��������(�ɴ��������������ַ�ʽ)
		File dest = new File(this.blockPath.get(idx));
		//�����
		RandomAccessFile raf = null;
		BufferedOutputStream bos = null;
		try {
			raf = new RandomAccessFile(src, "r");
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			//��ȡ�ļ�
			raf.seek(beginPoint);
			byte[] flush = new byte[1024];
			int len=0;
			while(-1!=(len=raf.read(flush))) {//��Ҫ©��flush���������ݴ��ﲻ��
				//��Ϊ�и���ļ����С���鿴�Ƿ��㹻ʵ���и����
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
	 * �ļ��ĺϲ�
	 */
	public void merge(String destPath) {
		File dest = new File(destPath);
		//�����
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(dest,true));//true׷��
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
	  * �ļ��ĺϲ�
	  */
	 public void mergeFile(String destPath) {
		 //����Դ
		 File dest = new File(destPath);
		 //ѡ����
		 BufferedOutputStream bos = null;	//�����
		 SequenceInputStream sis = null;		//����������
		 //����һ�����������
		 Vector<InputStream> vt = new Vector<>();
		 try {
			 //��������ע����
			 for(int i=0;i<blockPath.size();i++) {
				 vt.add(new BufferedInputStream(new FileInputStream(new File(blockPath.get(i)))));
			 }
			 bos = new BufferedOutputStream(new FileOutputStream(dest,true));	//׷��
			 sis = new SequenceInputStream(vt.elements());	//���������������������������
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
		//ע�⣬������飬�ָ�����ֽ���������kbҲ����m��
		TestSplitFile sf = new TestSplitFile("F:/ͼƬ/��;/JAVA���/Plane/SplitTest.txt","F:/ͼƬ/��;/JAVA���/Plane/testSplit", 50);
//		sf.split();
//		sf.merge("F:/ͼƬ/��;/JAVA���/Plane/testSplit/test03.txt");
		sf.mergeFile("F:/ͼƬ/��;/JAVA���/Plane/testSplit/test04.txt");
		
	}
	
}

class TSF_CloseMethods{
	//�ر�������һ��ʹ�ÿɱ����
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
	//�ر�����������ʹ�÷���
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
