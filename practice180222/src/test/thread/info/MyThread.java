package test.thread.info;

public class MyThread implements Runnable{
	//标识符
	private boolean flag= true;
	private int num =0;
	@Override
	public void run() {
		while(flag) {
			System.out.println(Thread.currentThread().getName()+"-->"+num++);
		}
	}
	public void stop() {
		this.flag = !this.flag;	//调整标识符控制线程进行
	}
	
}
