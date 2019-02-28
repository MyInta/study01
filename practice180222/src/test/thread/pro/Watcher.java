package test.thread.pro;
/**
 * 消费者
 * @author 银涛
 *
 */
public class Watcher implements Runnable{
	private Movie m;
	public Watcher(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			m.watch();
		}
	}
}
