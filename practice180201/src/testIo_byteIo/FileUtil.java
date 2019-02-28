package testIo_byteIo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 1���ļ�����
 * 2���ļ��п���
 * @author ����
 *
 */
public class FileUtil {
	/**
	 * �ļ��Ŀ���
	 * @param Դ�ļ�·��
	 * @param Ŀ���ļ�·��
	 * @throws IOException
	 * @return  
	 */
	public static void copyFile(String srcPath,String destPath) 
			throws FileNotFoundException, IOException{
		//1��ȷ��Դ������Ϊ�ļ���������ϵԴ+Ŀ�ĵأ��ļ����Բ����ڣ�
		copyFile(new File(srcPath),new File(destPath));
	}
	/**
	 * �ļ��Ŀ���
	 * @param Դ�ļ�File����
	 * @param Ŀ���ļ�File����
	 * @throws IOException
	 * @return  
	 */
	public static void copyFile(File src,File dest) 
			throws FileNotFoundException, IOException{
		if(!src.isFile()) {
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException();
		}
		//���destΪ�Ѵ��ڵ��ļ��У���Ϊ�����ļ��ܸ����ļ��������ܸ���ͬ���ļ��У�����Ҫ���쳣
		if(dest.isDirectory()) {
			System.out.println("���ܽ����ļ���ͬ�����ļ�");
			throw new IOException(dest.getAbsolutePath()+"���ܽ����ļ���ͬ�����ļ�");
		}
		//2��ѡ����-->���Ұ����� ����������--BufferedInputStream()&BufferedOutputStream()
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//3���ļ��Ŀ��� ѭ�� +��ȡ +д��
		byte[] flush = new byte[1024];
		int len =0;
		//��ȡ
		while(-1!=(len=is.read(flush))) {
			//д��
			os.write(flush,0,len);
		}
		os.flush();	//ǿ��ˢ��
		//�ر���
		close(os,is);
	}
	/**
	 * �ر������ͷ���Դ����
	 * @param io
	 */
	 public static void close(Closeable ... io) {
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
	/**
	 * �����ļ���
	 * @param src	Դ·��
	 * @param dest	Ŀ��·��
	 */
	public static void copyDir(String srcPath,String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
	}
	
	/**
	 * �����ļ���-->��Ŀ���ļ��п���Ŀ�ĵ��£������ڲ�ϸ�ڿ���
	 * @param src	ԴFile����
	 * @param dest	Ŀ��File����
	 */
	public static void copyDir(File src,File dest) {
		if(src.isDirectory()) {
			dest = new File(dest,src.getName());	//�����ǽ�src�ļ��п���destԭ��ַ����
		}
		//Ԥ����Ŀ¼������Ŀ¼�����ݹ飬���ɳ���Ŀ¼�ļ�
		if(dest.getAbsolutePath().contains(src.getAbsolutePath())) {
			System.out.println("���ܽ���Ŀ¼��������Ŀ¼��");
			return;
		}
		copyDirDetails(src, dest);
	}
	
	/**
	 * �����ļ���ϸ��
	 * @param src
	 * @param dest
	 */
	private static void copyDirDetails(File src,File dest) {
		//�����ļ�
		if(src.isFile()) {
			try {
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(src.isDirectory()) {
			//ȷ��Ŀ�ĵ��ļ�·������,�������򴴽�һ�����ļ�
			dest.mkdirs();
			//������������Ｖ�����õݹ������
			for(File sub:src.listFiles()) {
				copyDirDetails(sub, new File(dest,sub.getName()));
			}
		}
		
	}
}
