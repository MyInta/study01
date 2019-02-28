package test.thread.info;
/**
 * Thread.currentThread()
 * setName()
 * getName()
 * isAlive()
 * @author 银涛
 *
 */
public class InfoDemo01 {

	public static void main(String[] args) throws InterruptedException {
		MyThread it1 = new MyThread();
		Thread proxy = new Thread(it1,"挨踢1");
		proxy.setName("test01");
//		System.out.println(proxy.getName());
//		System.out.println(Thread.currentThread().getName());//main线程
		proxy.start();
		System.out.println("启动后的状态："+proxy.isAlive());
		Thread.sleep(200);
		it1.stop();
		Thread.sleep(100);
		System.out.println("停止后的状态："+proxy.isAlive());
	}

}
