package test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler{
	Star realStar;
	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		Object object = null;
		
		System.out.println("真正的方法执行前！");
		System.out.println("面谈、合同、预付款、订机票");
		if("sing".equals(arg1.getName())) {//判断是否为唱歌类，是才调用方法
			object = arg1.invoke(realStar, arg2);//方法激活
		}
		System.out.println("真正的方法执行后！");
		System.out.println("收尾款!");
		return object;
	}

}
