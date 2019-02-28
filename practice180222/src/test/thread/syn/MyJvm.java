package test.thread.syn;
/**
 * ����������ʽ
 * ����ʽ
 * 1����������˽�л��������ⲿ����
 * 2��������˽�о�̬����
 * 3���������ṩ�������Եľ�̬������ȷ���ö������
 * @author ����
 *
 */
public class MyJvm {
	private static MyJvm instance;
	private MyJvm() {
	}
	public static MyJvm getInstance() {
		//˫�ؼ����������߳������͵�Ч��
		if(null==instance) {
			synchronized(MyJvm.class) {
				if(null==instance) {
					instance = new MyJvm();
				}
			}
		}
		return instance;
	}
}
/**
 * ����ʽ
 * 1����������˽�л��������ⲿ����
 * 2��������˽�о�̬���ԣ��������ö���
 * 3���������ṩ�������Եľ�̬������ȷ���ö������
 * @author ����
 *
 */
class MyJvm2 {
	private static MyJvm2 instance= new MyJvm2();
	private MyJvm2() {
	}
	public static MyJvm2 getInstance() {
		//��Ϊ��̬�����˶��������߳��ǰ�ȫ�ģ�����Ҫ�߳���
		return instance;
	}
}
/**
 * ����ʹ�õ�ʱ����أ��ӻ�����ʱ��
 * @author ����
 *
 */
class MyJvm3 {
	//�൱�ڽ�ʵ����������һ����̬�ڲ������棬������Ҫ������ʱ����������Żᴴ�������Ч�����̰߳�ȫ
	private static class MyJvmHolder{
		private static MyJvm3 instance= new MyJvm3();
	}
	private MyJvm3() {
	}
	public static MyJvm3 getInstance() {
		return MyJvmHolder.instance;
	}
}
