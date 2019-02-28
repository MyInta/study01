package test.thread.start;

public class StopDemo01 {

	public static void main(String[] args) {
		Study s = new Study();
		new Thread(s).start();
		for(int i=1000;i>=0;i--) {
			if(i==500) {	//外部干涉
				s.stop();
			}
			System.out.println("main-->"+i);
		}
	}

}
class Study implements Runnable{
	//1）线程类中 定义线程体使用标识
	private boolean flag = true;
	@Override
	public void run() {
		//2）线程体使用该标识
		while(flag) {
			System.out.println("studying thread... ...");
		}
	}
	//3)对外提供方法改变标识
	public void stop() {	
		flag = !flag;
	}
}
