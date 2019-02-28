package testIo_byteIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ļ��Ķ�ȡ
 * 1��������ϵFile����	Դͷ
 * 2��ѡ����  �ļ������� InputStream FileInputStream
 * 3��������byte[] car = new byte[1024]; +read +��ȡ��С
 * 		      ���
 * 4���ͷ���Դ���ر�
 * @author ����
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//1��������ϵFile����
		File src = new File("F:/ͼƬ/��;/JAVA���/Plane/test01.txt");
		//2��ѡ���� 
		InputStream in = null;	//����������
		try {
			in = new FileInputStream(src);
			//3���������϶�ȡ	��������
			byte[] car = new byte[10];
			int len = 0;//����ʵ�ʶ�ȡ��С
			//ѭ����ȡ
			while(-1!=(len=in.read(car))) {
				//��� �ֽ�����ת���ַ���
				String info = new String(car, 0, len);
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�Ϊ��");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("��ȡ�ļ�ʧ��");
		}finally {
			try {
				//4���ͷ���Դ
				if (null != in) {	//Alt+shift+z ѡ��catch ������7�Ĺ���
					in.close();
				} 
			} catch (Exception e2) {
				System.out.println("�ر��ļ�������ʧ��");
			}
		}
		

	}
}
