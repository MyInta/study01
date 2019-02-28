package test.thread.create;

public class ProgrammerApp {

	public static void main(String[] args) {
		//1）创建真实角色
		Programmer pg = new Programmer();
		//2）创建代理角色+真实角色引用  -->Tread和Programmer都实现了Runnable的接口
		Thread proxy = new Thread(pg);
		//3）调用.start()启动线程
		proxy.start();
		for(int i=0;i<500;i++) {
			System.out.println("一边看视频，敲代码ing");
		}
	}

}
