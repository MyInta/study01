package test.thread.info;
/**
 * ���ȼ�  ���Ǿ��������ϵ��Ⱥ󣬶���ָ���ָ�������
 * MAX_PRIORITY 10
 * NORM_PRIORITY 5(Ĭ��)
 * MIN_PRIORITY	1
 * @author ����
 *
 */
public class InfoDemo02 {
	public static void main(String[] args) throws InterruptedException {
		MyThread it = new MyThread();
		Thread p1 = new Thread(it);
		MyThread it2 = new MyThread();
		Thread p2 = new Thread(it2);
		
		p1.setPriority(Thread.MIN_PRIORITY); 	//�������ȼ�
		p2.setPriority(Thread.MAX_PRIORITY);
		p1.start();
		p2.start();
		
		Thread.sleep(1000);
		it.stop();
		it2.stop();
		
		
	}
}
