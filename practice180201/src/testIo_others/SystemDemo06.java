package testIo_others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * ��������
 * 1��System.in		������ ��������
 * 2��System.out	����� ����̨���
 * 3��System.err	�����߱�����һ����û����ֻ�������Ϻ���Ϊע��������Ϣ������ʾ��ɫ
 * 
 * ==���ض���
 * setIn()
 * setOut()
 * setErr()
 * FileDescriptor.in ����
 * FileDescriptor.out���
 * @author ����
 *
 */
public class SystemDemo06 {

	public static void main(String[] args) throws FileNotFoundException  {
		//����̨-->�ļ�
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream(
								"F:/ͼƬ/��;/JAVA���/Plane/psTest01"
								,true)//�Ƿ�׷��
						),true));	//�Ƿ��ӡ����
		System.out.println("hhh");
		//�ļ�-->����̨
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream(
								FileDescriptor.out)),true));
		System.out.println("backing...");
		test01();
		
	}
	public static void test01() throws FileNotFoundException {
		InputStream is = System.in;//��������
		is = new BufferedInputStream(new FileInputStream("F:/ͼƬ/��;/JAVA���/Plane/psTest01"));
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(is);
		//System.out.println("�����룺");
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		
	}
}
