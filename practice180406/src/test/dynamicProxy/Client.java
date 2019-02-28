package test.dynamicProxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		Star realStar = new RealStar();
		StarHandler handler = new StarHandler(realStar);
		//JDK�Դ���ϵͳ����
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {Star.class}, handler);
		//proxy.bookTicket();
		proxy.sing();
		
	}
}
