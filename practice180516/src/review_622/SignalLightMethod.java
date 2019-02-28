package review_622;
/**
 * 信号灯法，使用生产者和消费者模式，确保资源的安全使用
 * @author 银涛
 *
 */
public class SignalLightMethod {
	public static void main(String[] args) {
		//共享的资源
		Resourse rs = new Resourse();
		//生产者
		Producer p = new Producer(rs);
		//消费者
		Consumer c = new Consumer(rs);
		//创建线程体
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		//启动线程
		t1.start();
		t2.start();
	}
}

class Resourse{
	//生产信息
	private String str = null;
	//是否生产的传入信号
	private boolean flag = true;
	//生产者生产
	public synchronized void produce(String str) {
		//生产者休息，消费者启动
		if(!flag) {
			try {
				this.wait();//生产者休息
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//否则的话正常生产
		try {
			Thread.sleep(500);	//间隔一段时间生产
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.str = str;
		System.out.println("生产了-->"+str);
		//提醒线程消费者，别wait了，开工了
		this.notify();
		//并关闭掉生产者，用boolean信号
		this.flag=!flag;
	}
	//消费者消费
	public synchronized void consume() {
		//消费者休息，生产者生产
		if(flag) {
			try {
				this.wait(); //消费者等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//否则的话，消费
		System.out.println("消费了-->"+str);
		//唤醒生产者，开始干活了
		this.notify();
		//并关闭消费过程
		this.flag = !flag;
	}
}
/**
 * 生产者
 * @author 银涛
 *
 */
class Producer implements Runnable{
	Resourse rs = null;
	public Producer(Resourse rs) {
		this.rs = rs;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			if(0==i%2) {
				rs.produce("左青龙");
			}else {
				rs.produce("右白虎");
			}
		}
	}
}
/**
 * 消费者
 * @author 银涛
 *
 */
class Consumer implements Runnable{
	Resourse rs = null;
	public Consumer(Resourse rs) {
		this.rs =rs;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			rs.consume();
		}
	}
}