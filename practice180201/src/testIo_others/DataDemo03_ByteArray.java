package testIo_others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * ��������(����+String�ַ���)�Ĵ�����
 * 1��������DateInputStream
 * 2�������DateOutputStream
 * java.io.EOFException	:���ļ���Ȼ�Ǵ��ڵģ�û�ж�ȡ��������Ҫ������
 * @author ����
 *
 */
public class DataDemo03_ByteArray {

	public static void main(String[] args) {
		try {
			byte[] data = write();
			System.out.println(data.length);
			read(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ���ļ��ж�ȡ����+����
	 * @throws IOException 
	 */
	public static void read(byte[] data) throws IOException {
		//ѡ����
		DataInputStream dis = new DataInputStream(
					new BufferedInputStream(
							new ByteArrayInputStream(data)//��Ϊ�ֽ�����������û�ж�̬��Ϊ������ֱ��new
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
	 * ����+����������ֽ�������
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException {
		//�½��ֽ�����
		byte[] dest = new byte[1024];
		double point = 2.5;
		long num = 100L;
		String str = "��������";
		//��Ϊ�õ����ֽ������������Ҫ���䷽�������ܶ�̬���½�
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//ѡ����
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						bos
						)
				);
		//���� д��˳��Ҫ���ȡ˳��һ��
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str); 	//ע����UTF������writeString-->�������������
		dos.flush();
		//��ȡ���ݣ��ڹر�֮ǰ
		dest = bos.toByteArray();
		dos.close();
		bos.close();
		return dest;
	}
}
