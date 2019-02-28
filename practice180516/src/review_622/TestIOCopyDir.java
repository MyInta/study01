package review_622;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestIOCopyDir {
	public static void main(String[] args) {
		String src = "F:/ͼƬ/��;/JAVA���/Plane";
		String dest = "F:/ͼƬ/��;/JAVA���/Dir";
		copyDir(src,dest);
	}
	/**
	 * �����ļ��У������ַ
	 * @param srcPath
	 * @param destPath
	 */
	public static void copyDir(String srcPath,String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
	}
	/**
	 * �����ļ��У������ļ�
	 * @param src
	 * @param dest
	 */
	public static void copyDir(File src,File dest) {
		if(src.isDirectory()) {
			dest = new File(dest,src.getName());
		}
		//������Ҫ����ȫ���⡿��ֹ�����ļ��������ļ�Ŀ¼�в�������ѭ�������ļ�
		if(dest.getAbsolutePath().contains(src.getAbsolutePath())) {
			System.out.println("���ܽ������ļ��������������ļ�Ŀ¼�У�������쳣�����ļ�");
			return;
		}
		copyDirDetails(src,dest);
	}
	/**
	 * �ļ��ľ��忽������
	 * @param src
	 * @param dest
	 */
	public static void copyDirDetails(File src,File dest) {
		if(src.isFile()) {
			copyFile(src,dest);
		}else if(src.isDirectory()) {
			//ȷ������һ��Ŀ���ļ�
			dest.mkdirs();
			//����Դ�ļ��ڲ����������ļ����ݹ�
			for(File temp:src.listFiles()) {
				copyDirDetails(temp,new File(dest,temp.getName()));
			}
		}
	}
	/**
	 * �����ļ��������ļ�
	 * @param src
	 * @param dest
	 */
	public static void copyFile(File src,File dest) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1!=(len=is.read(flush))) {
				os.write(flush,0,len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�������");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO���쳣");
			e.printStackTrace();
		}finally {
			if(null!=is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null!=os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * �����ļ��������ļ���ַ
	 * @param srcPath
	 * @param deestPath
	 */
	public static void copyFile(String srcPath,String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyFile(src,dest);
	}
}
