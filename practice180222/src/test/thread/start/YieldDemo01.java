package test.thread.start;

public class YieldDemo01 extends Thread {
	public static void main(String[] args) {
		YieldDemo01 yd = new YieldDemo01();
		Thread t = new Thread(yd);//����
		t.start();//����
		//CPU��������
		for(int i=0;i<1000;i++) {
			if(i%20==0) {
				//��ͣ���߳�
				Thread.yield();
			}
			System.out.println("main...-->"+i);
		}
	}
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("yeild...-->"+i);
		}
	}
}
