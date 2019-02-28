package test.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * ��װ�˿ڣ���InetAddress������+�˿�
 * @author ����
 *
 */
public class InetSocketDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		InetSocketAddress isa = new InetSocketAddress("localhost"
				,8888);
		System.out.println(isa.getHostName());
		System.out.println(isa.getPort());
		InetAddress ia = isa.getAddress();
		System.out.println(ia.getHostAddress());	//���ص�ַ
		System.out.println(ia.getHostName());		//���ر�����
	}
}
