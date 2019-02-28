package test.thread.info;
/**
 * 优先级  并非绝对意义上的先后，而是指出现概率优先
 * MAX_PRIORITY 10
 * NORM_PRIORITY 5(默认)
 * MIN_PRIORITY	1
 * @author 银涛
 *
 */
public class InfoDemo02 {
	public static void main(String[] args) throws InterruptedException {
		MyThread it = new MyThread();
		Thread p1 = new Thread(it);
		MyThread it2 = new MyThread();
		Thread p2 = new Thread(it2);
		
		p1.setPriority(Thread.MIN_PRIORITY); 	//设置优先级
		p2.setPriority(Thread.MAX_PRIORITY);
		p1.start();
		p2.start();
		
		Thread.sleep(1000);
		it.stop();
		it2.stop();
		
		
	}
}
