package test.thread.start;


/**
 * ģ�������ӳ�
 * @author ����
 *
 */
public class SleepDemo02 {

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
		private int num = 50;
		@Override
		public void run() {
			while(true) {
				synchronized(this) {
				if(num<=0) {
					break;
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"����Ʊ"+num--);
			}
		}
	}
}