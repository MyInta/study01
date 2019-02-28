package testIo_others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �������ͣ�����+String��������
 * 1��������DateInputStream
 * 2�������DateOutputStream
 * java.io.EOFException	:���ļ���Ȼ�Ǵ��ڵģ�û�ж�ȡ��������Ҫ������
 * @author ����
 *
 */
public class DataDemo03_File {

	public static void main(String[] args) {
		try {
//			write("F:/ͼƬ/��;/JAVA���/Plane/data.txt");
//			read("F:/ͼƬ/��;/JAVA���/Plane/test01.txt");//�Ƿ��ļ�
			read("F:/ͼƬ/��;/JAVA���/Plane/data.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ���ļ��ж�ȡ����+����
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException {
		//����Դ
		File src = new File(destPath);
		//ѡ����
		DataInputStream dis = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(src)
							)
				);
		//��ȡ˳����д��һ�� ������ڲ��ܶ�ȡ
		double point2 = dis.readDouble();
		long num2 = dis.readLong();
		String str2 = dis.readUTF();
		dis.close();
		System.out.println(point2+"-->"+num2+"-->"+str2);
	}
	/**
	 * ����+����������ļ�
	 * @throws IOException 
	 */
	public static void write(String destPath) throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "��������";
		//����Դ
		File dest = new File(destPath);
		//ѡ����
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//���� д��˳��Ҫ���ȡ˳��һ��
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str); 	//ע����UTF������writeString-->�������������
		dos.flush();
		dos.close();
	}
}
