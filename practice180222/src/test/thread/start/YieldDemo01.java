package test.thread.start;

public class YieldDemo01 extends Thread {
	public static void main(String[] args) {
		YieldDemo01 yd = new YieldDemo01();
		Thread t = new Thread(yd);//新生
		t.start();//就绪
		//CPU调度运行
		for(int i=0;i<1000;i++) {
			if(i%20==0) {
				//暂停本线程
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
