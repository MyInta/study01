package test.thread.start;

public class JoinDemo01 extends Thread {
	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 jd = new JoinDemo01();
		Thread t = new Thread(jd);//����
		t.start();//����
		//CPU��������
		for(int i=0;i<1000;i++) {
			if(50==i) {
				t.join();	//main����
			}
			System.out.println("main...-->"+i);
		}
	}
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("join...-->"+i);
		}
	}
}
