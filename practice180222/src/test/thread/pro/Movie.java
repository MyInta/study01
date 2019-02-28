package test.thread.pro;
/**
 * 一个场景,一个共同的资源
 * 生产者消费者模式 信号灯法
 * wait() 等待 释放锁 sleep()等待 不释放锁
 * notify()/notifyAll():唤醒
 * 与synchronized 一起使用
 * @author 银涛
 *
 */
public class Movie {
	private String pic;
	//信号灯
	//flag-->T生产者生产，消费者等待,生产完后通知消费
	//flag-->F消费者消费，生产者等待，消费完后通知生产
	private boolean flag = true;
	public synchronized void play(String pic) {
		if(!flag) {//生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(500);	//生产一段时间
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//生产完毕
		this.pic = pic;
		
		System.out.println("生产了-->"+pic);
		//唤醒消费者
		this.notify();
		//停止生产者
		this.flag = false;
	}
	public synchronized void watch() {
		if(flag) {	//消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//消费者消费一段时间
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//消费完毕
		System.out.println("消费了-->"+pic);
		//唤醒生产者
		this.notify();
		//停止消费者
		this.flag = true;
	}
}
