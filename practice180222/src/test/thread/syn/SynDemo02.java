package test.thread.syn;
/**
 * �������ģʽ
 * ȷ��һ����ֻ��һ������
 * @author ����
 *
 */
public class SynDemo02 {
	public static void main(String[] args) {
//		Jvm jvm = Jvm.getInstance();
//		Jvm jvm2 = Jvm.getInstance();
//		System.out.println(jvm);
//		System.out.println(jvm2);
		JvmThread thread1 = new JvmThread();
		JvmThread thread2 = new JvmThread();
		thread1.start();
		thread2.start();
	}
}
class JvmThread extends Thread{
	private long time;
	public JvmThread() {
	}
	public JvmThread(long time) {
		this.time = time;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()
				+"-->����"+Jvm.getInstance(time));
	}
}
/**
 * �������ģʽ
 * ȷ��һ����ֻ��һ������
 * ����ʽ double checking
 * 1����������˽�л��������ⲿ��������
 * 2��������һ����̬��˽�б���
 * 3��������һ�������ľ�̬�������ʸñ������������û�ж��󣬴�������
 *
 */
class Jvm{
	//2��������һ����̬��˽�б���
	private static Jvm instance = null;
	//1����������˽�л��������ⲿ��������
	private Jvm() {
	}
	//3��������һ�������ľ�̬�������ʸñ������������û�ж��󣬴�������
	public static Jvm getInstance(long time) {
		//�Ľ�Ч�ʡ����ڶ������̷��أ�����Ҫ�ٽ�ȥ�ȴ�
		if(null==instance) {
		synchronized(Jvm.class) {	//��Ϊû��this�������ø�����ֽ�����Ϣ
			if(null==instance) {
				try {
					Thread.sleep(time);	//��ʱ���Ŵ����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
			}
			}
		}
		return instance;
	}
	/**
	 * ͬ����
	 * @param time �ȴ�ʱ��
	 * @return Jvm����
	 */
	public static Jvm getInstance3(long time) {
		//Ч�ʲ��ߡ����ڶ���Ҳ��Ҫ�ȴ�
		synchronized(Jvm.class) {	//��Ϊû��this�������ø�����ֽ�����Ϣ
		if(null==instance) {
			try {
				Thread.sleep(time);	//��ʱ���Ŵ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
		}
	}
	/**
	 * ����ֱ��ͬ����
	 * @param time �ȴ�ʱ��
	 * @return Jvm����
	 */
	public static synchronized Jvm getInstance2(long time) {
		if(null==instance) {
			try {
				Thread.sleep(time);	//��ʱ���Ŵ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}
	/**
	 * δͬ�����̲߳���ȫ
	 * @param time �ȴ�ʱ��
	 * @return Jvm����
	 */
	public static Jvm getInstance1(long time) {
		if(null==instance) {
			try {
				Thread.sleep(time);	//��ʱ���Ŵ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}
}
