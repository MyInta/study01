package test.thread.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeDemo {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//��һ����Ϊ�߳��壬�ڶ�����Ϊ��ʼʱ��㣬�����Ĳ���Ϊ���ʱ��
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("���ִ������-->����Զ���");
			}
			
		}, new Date(System.currentTimeMillis()+1000), 300);	
	}
}
