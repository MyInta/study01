package test.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ʹ��Callable�ӿڴ����߳�
 * @author ����
 *
 */
public class Call {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//�����߳�
		ExecutorService es = Executors.newFixedThreadPool(2);	//���������߳�
		Race tortoise = new Race("����",1000);	//1000ms�൱��1s
		Race rabbit = new Race("����",500);
		//��ȡֵ
		Future<Integer> result1 = es.submit(tortoise);
		Future<Integer> result2 = es.submit(rabbit);
		
		Thread.sleep(2000);//2s��ֹͣ
		tortoise.setFlag(false);//ֹͣ�߳���ѭ��
		rabbit.setFlag(false);
		
		int num1 = result1.get();
		int num2 = result2.get();
		System.out.println("�ڹ�����-->"+num1+"��");
		System.out.println("С��������-->"+num2+"��");
		es.shutdown();//ֹͣ����
	}
}
class Race implements Callable<Integer>{
	private String name;	//����
	private long time;		//��ʱʱ��
	private boolean flag=true;
	private int step = 0;	//���˶��ٲ�
	public Race() {
	}
	public Race(String name) {
		super();
		this.name = name;
	}
	public Race(String name,long time) {
		super();
		this.name = name;
		this.time = time;
	}

	@Override
	public Integer call() throws Exception {
		while(flag) {
			Thread.sleep(time);//��ʱ
			step++;
		}
		return step;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
}