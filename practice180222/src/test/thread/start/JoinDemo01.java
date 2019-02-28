package test.thread.start;

public class JoinDemo01 extends Thread {
	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 jd = new JoinDemo01();
		Thread t = new Thread(jd);//新生
		t.start();//就绪
		//CPU调度运行
		for(int i=0;i<1000;i++) {
			if(50==i) {
				t.join();	//main阻塞
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
