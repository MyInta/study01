package test.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 没有封装端口
 * @author 银涛
 *
 */
public class InetDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost创建InetAddress对象
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());	//返回ip地址
		System.out.println(addr.getHostName());	//返回计算机名
		addr = InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostAddress());//返回主页ip地址
		System.out.println(addr.getHostName());		//返回域名
		addr = InetAddress.getByName("127.0.0.1");
//		addr = InetAddress.getByName("183.232.231.173");
		System.out.println(addr.getHostAddress());		//返回主页ip地址
		System.out.println(addr.getHostName());		//当无法访问该ip时候返回ip地址，否者返回域名
	}
}
