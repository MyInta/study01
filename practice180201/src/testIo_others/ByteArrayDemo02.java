package testIo_others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1���ļ�--> ����-->�ֽ�����
 * 	1) �ļ�������	
 * 	2) �ֽ����������
 * 2���ֽ�����-->����-->�ļ�
 * 	1���ֽ�����������
 * 	2���ļ������
 * @author ����
 *
 */
public class ByteArrayDemo02 {

	public static void main(String[] args) throws IOException {
		String path ="F:/ͼƬ/��;/JAVA���/Plane/bg.jpg";
		String destPath = "F:/ͼƬ/��;/JAVA���/Plane/�ļ�-�ֽ�����-�ļ�.jpg";
		byte[] date = getBytesFromFile(path);
		toFileFromByteArray(date, destPath);
	}
	
	/**
	 * 1���ļ�--> ����-->�ֽ�����
	 *  1) �ļ������� 
	 *  2) �ֽ����������
	 * @param strPath
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesFromFile(String strPath) throws IOException {
		//�����ļ�Դ
		File src = new File(strPath);
		//�����ֽ�����Ŀ�ĵ�
		byte[] dest = null;
		//ѡ����
		// �ļ�������
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		// �ֽ������ ����ʹ�ö�̬
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			//д�����ֽ�������
			bo.write(flush, 0, len);
		}
		bo.flush();//ǿ��ˢ��
		//��ȡ����
		dest = bo.toByteArray();
		
		is.close();
		bo.close();
		return dest;
	}
	/**
	 * 2���ֽ�����-->����-->�ļ�
	 * 	1���ֽ�����������
	 * 	2���ļ������
	 */
	public static void toFileFromByteArray(byte[] src,String destPath) throws IOException {
		//����Դ
		//Ŀ�ĵ�
		File dest = new File(destPath);
		//�ֽ�����������
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//�ļ������
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//���� ���϶�ȡ�ֽ�����
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			//д�����ļ���
			os.write(flush, 0, len);
		}
		os.flush();//ǿ��ˢ��
		is.close();
		os.close();
	}
}
