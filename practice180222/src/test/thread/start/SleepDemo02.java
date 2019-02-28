package test.thread.start;


/**
 * 模拟网络延迟
 * @author 银涛
 *
 */
public class SleepDemo02 {

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
		private int num = 50;
		@Override
		public void run() {
			while(true) {
				synchronized(this) {
				if(num<=0) {
					break;
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"抢到票"+num--);
			}
		}
	}
}