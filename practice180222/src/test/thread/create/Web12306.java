package test.thread.create;
/**
 * 方便共享资源
 * 查看test.thread.start。SleepDemo02对资源共享线程问题会有更直观的感受
 * @author 银涛
 *
 */
public class Web12306 implements Runnable{
	private int num = 50;
	@Override
	public void run() {
		//数字倒计时，为零则退出执行动作
		while(true) {
			if(num<=0) {
				break;
			}
			System.out.println(Thread.currentThread().getName()+"抢到票"+num--);
		}
	}
	public static void main(String[] args) {
		//创建真实角色
		Web12306 web = new Web12306();
		//使用代理
		Thread l1 = new Thread(web,"Inta");	//参数一为真实角色，参数二为命名
		Thread l2 = new Thread(web,"黄牛");
		Thread l3 = new Thread(web,"牛琦");
		l1.start();
		l2.start();
		l3.start();
	}
}
