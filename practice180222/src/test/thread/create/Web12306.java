package test.thread.create;
/**
 * ���㹲����Դ
 * �鿴test.thread.start��SleepDemo02����Դ�����߳�������и�ֱ�۵ĸ���
 * @author ����
 *
 */
public class Web12306 implements Runnable{
	private int num = 50;
	@Override
	public void run() {
		//���ֵ���ʱ��Ϊ�����˳�ִ�ж���
		while(true) {
			if(num<=0) {
				break;
			}
			System.out.println(Thread.currentThread().getName()+"����Ʊ"+num--);
		}
	}
	public static void main(String[] args) {
		//������ʵ��ɫ
		Web12306 web = new Web12306();
		//ʹ�ô���
		Thread l1 = new Thread(web,"Inta");	//����һΪ��ʵ��ɫ��������Ϊ����
		Thread l2 = new Thread(web,"��ţ");
		Thread l3 = new Thread(web,"ţ��");
		l1.start();
		l2.start();
		l3.start();
	}
}
