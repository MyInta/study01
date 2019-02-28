package test.thread.syn;
/**
 * synchronized
 * �ѵ��ǿ��Ƶķ�Χ���⣬̫�󣬷���Ч�ʵ��£�̫С�����׵���������Դ��Χ����ȷ
 * @author ����
 *
 */
public class SynDemo01 {
	public static void main(String[] args) {
		//������ʵ��ɫ
		Web12306 web = new Web12306();
		//ʹ�ô���
		Thread l1 = new Thread(web, "Inta");
		Thread l2 = new Thread(web, "��ţ");
		Thread l3 = new Thread(web, "ţ��");
		l1.start();
		l2.start();
		l3.start();
	}
}
class Web12306 implements Runnable{
	private int num = 10;
	private boolean flag = true;
	@Override
	public void run() {
		while(flag) {
			test01();
		}
	}
	//�̲߳���ȫ ������Դ����ȷ 
	public void test06() {
			if(num<=0) {
				flag = false;	//����ѭ��
				return;
			}
		synchronized (this) {
			try {
				Thread.sleep(500);	//ģ����ʱ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"����Ʊ"+num--);
		}
	}
	//�̲߳���ȫ ������Դ����ȷ ͬ����
	public void test05() {
		synchronized ((Integer) num) {
			if (num <= 0) {
				flag = false; // ����ѭ��
				return;
			}
			try {
				Thread.sleep(500); // ģ����ʱ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "����Ʊ" + num--);
		}
	}
	//�̲߳���ȫ ������Χ����ȷ 
	public void test04() {
		synchronized (this) {
			if (num <= 0) {
				flag = false; // ����ѭ��
				return;
			}
		}
		try {
			Thread.sleep(500); // ģ����ʱ
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "����Ʊ" + num--);
	}
	//�̰߳�ȫ ������ȷ ͬ����
	public void test03() {
		synchronized (this) {
			if (num <= 0) {
				flag = false; // ����ѭ��
				return;
			}
			try {
				Thread.sleep(500); // ģ����ʱ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "����Ʊ" + num--);
		}
	}
	//�̰߳�ȫ ������ȷ
	public synchronized void test02() {
		if (num <= 0) {
			flag = false; // ����ѭ��
			return;
		}
		try {
			Thread.sleep(500); // ģ����ʱ
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "����Ʊ" + num--);
	}
	//�̲߳���ȫ
	public void test01() {
		if (num <= 0) {
			flag = false; // ����ѭ��
			return;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "����Ʊ" + num--);
	}
}
