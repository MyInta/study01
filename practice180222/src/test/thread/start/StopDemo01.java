package test.thread.start;

public class StopDemo01 {

	public static void main(String[] args) {
		Study s = new Study();
		new Thread(s).start();
		for(int i=1000;i>=0;i--) {
			if(i==500) {	//�ⲿ����
				s.stop();
			}
			System.out.println("main-->"+i);
		}
	}

}
class Study implements Runnable{
	//1���߳����� �����߳���ʹ�ñ�ʶ
	private boolean flag = true;
	@Override
	public void run() {
		//2���߳���ʹ�øñ�ʶ
		while(flag) {
			System.out.println("studying thread... ...");
		}
	}
	//3)�����ṩ�����ı��ʶ
	public void stop() {	
		flag = !flag;
	}
}
