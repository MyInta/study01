package testIo_byteIo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * д���ļ�
 * 1��������ϵFile����	Ŀ�ĵ�
 * 2��ѡ����  �ļ������ OutputStream FileOutputStream
 * 3��������write()+flush
 * 4���ͷ���Դ���ر�
 * @author ����
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//1��������ϵFile����	Ŀ�ĵ�
		File dest = new File("F:/ͼƬ/��;/JAVA���/Plane/test01.txt");
		//2��ѡ����  �ļ������ OutputStream FileOutputStream
		OutputStream out = null;
		//��׷����ʽ,д���ļ�
		try {
			out = new FileOutputStream(dest,true);//true��ʾ׷���ļ���falseΪ���ǣ�Ĭ��false����
		//3������
			String str = "Inta is the king of the new world!";
			char nextLine = '\n';	//����
			//�ַ���ת�����ֽ�����
			byte[] date = str.getBytes();
			//д����Ϣ
			out.write(nextLine);
			out.write(date);
			
			out.flush(); 	//ǿ��ˢ�³�ȥ
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�δ�ҵ�");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("д����Ϣʧ��");
		}finally {
			try {
				if (null != out) {
					out.close();
				} 
			} catch (Exception e2) {
				System.out.println("�ر������ʧ��");
			}
		}
	}
}
