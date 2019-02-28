package test.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 封装端口：在InetAddress基础上+端口
 * @author 银涛
 *
 */
public class InetSocketDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		InetSocketAddress isa = new InetSocketAddress("localhost"
				,8888);
		System.out.println(isa.getHostName());
		System.out.println(isa.getPort());
		InetAddress ia = isa.getAddress();
		System.out.println(ia.getHostAddress());	//返回地址
		System.out.println(ia.getHostName());		//返回本地名
	}
}
