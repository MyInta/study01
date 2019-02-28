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
		
		System.out.println("�����ķ���ִ��ǰ��");
		System.out.println("��̸����ͬ��Ԥ�������Ʊ");
		if("sing".equals(arg1.getName())) {//�ж��Ƿ�Ϊ�����࣬�ǲŵ��÷���
			object = arg1.invoke(realStar, arg2);//��������
		}
		System.out.println("�����ķ���ִ�к�");
		System.out.println("��β��!");
		return object;
	}

}
