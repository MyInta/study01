package testIo_charIo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * д���ļ�
 * @author ����
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//����Դ
		File src = new File("F:/ͼƬ/��;/JAVA���/Plane/test02.txt");
		//ѡ����
		Writer writer =null;
		try {
			writer = new FileWriter(src);
			String str = "inta �����ߵ���\r\n" + 
					"javaѧϰ��һ��������\r\n" + 
					"��������������\r\n" + 
					"�ڲ��õĽ���\r\n" + 
					"Inta�������ȡ��\r\n" + 
					"��˶���ջ�\r\n" + 
					"������Ϊ���ĵ������Ϻ���";
			//д��
			writer.write(str);
			
			writer.flush(); 	//ǿ��ˢ��
		}catch (FileNotFoundException e) {	//�ļ�Ϊ��
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		if(null!=writer) {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("�ļ�д�����ʧ��");
			}
		}
	}
}
