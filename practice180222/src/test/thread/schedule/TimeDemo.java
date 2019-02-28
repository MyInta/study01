package test.thread.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeDemo {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//第一参数为线程体，第二参数为起始时间点，第三的参数为间隔时间
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("疯狂执行任务-->间隔自定义");
			}
			
		}, new Date(System.currentTimeMillis()+1000), 300);	
	}
}
