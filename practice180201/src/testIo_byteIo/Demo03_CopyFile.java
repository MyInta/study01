package testIo_byteIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1��������ϵ	File���� Դͷ Ŀ�ĵ�
 * 2��ѡ����
 * 		�ļ������� InputStream FileInputStream
 * 		�ļ������ OutputStream FileOutputStream
 * 3��������	����
 * 		byte[] flush = byte[1024];
 * 		int len = 0;
 * 		while(-1!=(len=������.read(flush))){
 * 			�����.write(flush,0,len);
 * 		}
 * 4���ͷ���Դ���ر�������
 * @author ����
 *
 */
public class Demo03_CopyFile {
	public static void main(String[] args) {
		String srcPath = "F:/ͼƬ/��;/JAVA���/Plane/bg.jpg";  //���Խ�������ļ�����ȥ�����쳣���
		String destPath = "F:/ͼƬ/��;/JAVA���/Plane/bg2.jpg";
		try {
			copyFile(srcPath, destPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�Ϊ��");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�����ļ�ʧ��");
		}
	}
	/**
	 * �ļ��Ŀ���
	 * @param Դ�ļ�·��
	 * @param Ŀ���ļ�·��
	 * @throws IOException
	 * @return  
	 */
	public static void copyFile(String srcPath,String destPath) throws FileNotFoundException, IOException{
		//1��ȷ��Դ������Ϊ�ļ���������ϵԴ+Ŀ�ĵأ��ļ����Բ����ڣ�
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.isFile()) {
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException();
		}
		//2��ѡ����
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
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
		os.close();
		is.close();
	}
}
