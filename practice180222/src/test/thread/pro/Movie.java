package test.thread.pro;
/**
 * һ������,һ����ͬ����Դ
 * ������������ģʽ �źŵƷ�
 * wait() �ȴ� �ͷ��� sleep()�ȴ� ���ͷ���
 * notify()/notifyAll():����
 * ��synchronized һ��ʹ��
 * @author ����
 *
 */
public class Movie {
	private String pic;
	//�źŵ�
	//flag-->T�����������������ߵȴ�,�������֪ͨ����
	//flag-->F���������ѣ������ߵȴ����������֪ͨ����
	private boolean flag = true;
	public synchronized void play(String pic) {
		if(!flag) {//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(500);	//����һ��ʱ��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�������
		this.pic = pic;
		
		System.out.println("������-->"+pic);
		//����������
		this.notify();
		//ֹͣ������
		this.flag = false;
	}
	public synchronized void watch() {
		if(flag) {	//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//����������һ��ʱ��
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�������
		System.out.println("������-->"+pic);
		//����������
		this.notify();
		//ֹͣ������
		this.flag = true;
	}
}
