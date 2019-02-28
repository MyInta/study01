package review_622;
/**
 * �źŵƷ���ʹ�������ߺ�������ģʽ��ȷ����Դ�İ�ȫʹ��
 * @author ����
 *
 */
public class SignalLightMethod {
	public static void main(String[] args) {
		//�������Դ
		Resourse rs = new Resourse();
		//������
		Producer p = new Producer(rs);
		//������
		Consumer c = new Consumer(rs);
		//�����߳���
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		//�����߳�
		t1.start();
		t2.start();
	}
}

class Resourse{
	//������Ϣ
	private String str = null;
	//�Ƿ������Ĵ����ź�
	private boolean flag = true;
	//����������
	public synchronized void produce(String str) {
		//��������Ϣ������������
		if(!flag) {
			try {
				this.wait();//��������Ϣ
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//����Ļ���������
		try {
			Thread.sleep(500);	//���һ��ʱ������
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.str = str;
		System.out.println("������-->"+str);
		//�����߳������ߣ���wait�ˣ�������
		this.notify();
		//���رյ������ߣ���boolean�ź�
		this.flag=!flag;
	}
	//����������
	public synchronized void consume() {
		//��������Ϣ������������
		if(flag) {
			try {
				this.wait(); //�����ߵȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//����Ļ�������
		System.out.println("������-->"+str);
		//���������ߣ���ʼ�ɻ���
		this.notify();
		//���ر����ѹ���
		this.flag = !flag;
	}
}
/**
 * ������
 * @author ����
 *
 */
class Producer implements Runnable{
	Resourse rs = null;
	public Producer(Resourse rs) {
		this.rs = rs;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			if(0==i%2) {
				rs.produce("������");
			}else {
				rs.produce("�Ұ׻�");
			}
		}
	}
}
/**
 * ������
 * @author ����
 *
 */
class Consumer implements Runnable{
	Resourse rs = null;
	public Consumer(Resourse rs) {
		this.rs =rs;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			rs.consume();
		}
	}
}