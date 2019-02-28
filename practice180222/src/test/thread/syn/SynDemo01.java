package test.thread.syn;
/**
 * synchronized
 * 难点是控制的范围问题，太大，访问效率低下，太小，容易导致锁定资源或范围不正确
 * @author 银涛
 *
 */
public class SynDemo01 {
	public static void main(String[] args) {
		//创建真实角色
		Web12306 web = new Web12306();
		//使用代理
		Thread l1 = new Thread(web, "Inta");
		Thread l2 = new Thread(web, "黄牛");
		Thread l3 = new Thread(web, "牛琦");
		l1.start();
		l2.start();
		l3.start();
	}
}
class Web12306 implements Runnable{
	private int num = 10;
	private boolean flag = true;
	@Override
	public void run() {
		while(flag) {
			test01();
		}
	}
	//线程不安全 锁定资源不正确 
	public void test06() {
			if(num<=0) {
				flag = false;	//跳出循环
				return;
			}
		synchronized (this) {
			try {
				Thread.sleep(500);	//模拟延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到票"+num--);
		}
	}
	//线程不安全 锁定资源不正确 同步块
	public void test05() {
		synchronized ((Integer) num) {
			if (num <= 0) {
				flag = false; // 跳出循环
				return;
			}
			try {
				Thread.sleep(500); // 模拟延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到票" + num--);
		}
	}
	//线程不安全 锁定范围不正确 
	public void test04() {
		synchronized (this) {
			if (num <= 0) {
				flag = false; // 跳出循环
				return;
			}
		}
		try {
			Thread.sleep(500); // 模拟延时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到票" + num--);
	}
	//线程安全 锁定正确 同步块
	public void test03() {
		synchronized (this) {
			if (num <= 0) {
				flag = false; // 跳出循环
				return;
			}
			try {
				Thread.sleep(500); // 模拟延时
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到票" + num--);
		}
	}
	//线程安全 锁定正确
	public synchronized void test02() {
		if (num <= 0) {
			flag = false; // 跳出循环
			return;
		}
		try {
			Thread.sleep(500); // 模拟延时
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到票" + num--);
	}
	//线程不安全
	public void test01() {
		if (num <= 0) {
			flag = false; // 跳出循环
			return;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到票" + num--);
	}
}
