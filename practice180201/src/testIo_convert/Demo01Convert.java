package testIo_convert;

import java.io.UnsupportedEncodingException;

public class Demo01Convert {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "�й�";
		byte[] date = str.getBytes();
		System.out.println(new String(date,0,3)); 	//�ֽ�����������������
	}
	/**
	 * �����������ַ�����ͳһ���������ײ�������
	 * @throws UnsupportedEncodingException 
	 */
	public static void test01() throws UnsupportedEncodingException {
		// ����
		String str = "�й�"; // gbk
		// ����
		byte[] date = str.getBytes();
		// ����������ַ���ͳһ
		System.out.println(new String(date));
		// ��ͳһ��������
		date = str.getBytes("utf-8");
		System.out.println(new String(date));

		// ����
		byte[] date2 = "�й�".getBytes("utf-8");
		// ����
		str = new String(date2, "utf-8");
		System.out.println(str);
	}
}
