package test.thread.info;
/**
 * Thread.currentThread()
 * setName()
 * getName()
 * isAlive()
 * @author ����
 *
 */
public class InfoDemo01 {

	public static void main(String[] args) throws InterruptedException {
		MyThread it1 = new MyThread();
		Thread proxy = new Thread(it1,"����1");
		proxy.setName("test01");
//		System.out.println(proxy.getName());
//		System.out.println(Thread.currentThread().getName());//main�߳�
		proxy.start();
		System.out.println("�������״̬��"+proxy.isAlive());
		Thread.sleep(200);
		it1.stop();
		Thread.sleep(100);
		System.out.println("ֹͣ���״̬��"+proxy.isAlive());
	}

}
