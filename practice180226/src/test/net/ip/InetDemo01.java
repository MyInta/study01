package test.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * û�з�װ�˿�
 * @author ����
 *
 */
public class InetDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost����InetAddress����
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());	//����ip��ַ
		System.out.println(addr.getHostName());	//���ؼ������
		addr = InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostAddress());//������ҳip��ַ
		System.out.println(addr.getHostName());		//��������
		addr = InetAddress.getByName("127.0.0.1");
//		addr = InetAddress.getByName("183.232.231.173");
		System.out.println(addr.getHostAddress());		//������ҳip��ַ
		System.out.println(addr.getHostName());		//���޷����ʸ�ipʱ�򷵻�ip��ַ�����߷�������
	}
}
