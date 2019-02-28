package testIo_others;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ֽ����� �ڵ���
 * ����ĳ������ޣ�����������ܴ�
 * @author ����
 *
 */
public class ByteArrayDemo01 {

	public static void main(String[] args) throws IOException {
		read(write());
	}
	/**
	 * �������������һ��
	 * ʵ�����ĵ���ͬ���·����������ö�̬
	 */
	public static byte[] write() {
		//Ŀ�ĵ�
		byte[] dest;
		//ѡ����
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		//\r�൱�ڡ�+������\n�ǻ���
		String str = "Inta is the king of the new world!\r\n"
				+ "������Ϊ���ĵ���\r\n"
				+ "���Ϻ��񣡣���";
		byte[] src;
		src = str.getBytes();
		bo.write(src, 0, src.length); // ע�ⳤ��Ϊ�����鳤��
		// ��ȡ����
		// bo.close();//ͬ�����ڼ̳���closable����Ҫ���ظ��ر���Դ����
		dest = bo.toByteArray();
		return dest;
	}
	/**
	 * ���������������ļ�������һ��
	 * ��ȡ�ֽ�����
	 * @throws IOException 
	 */
	public static void read(byte[] dest) throws IOException {
		//����Դ����
		//ѡ����
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(
						dest
						)
				);
		//����
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			System.out.println(new String(flush,0,len));
		}
//		is.close();//byteArray���Ͳ���Ҫ�ڹرգ���Ϊ����̳���closable
	}
}
