package practice05;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 测试Queue模拟的银行服务
 * 先进先出
 * @author 银涛
 *
 */
public class TestQueue01 {
	public static void main(String[] args) {
	Queue<Request> que = new ArrayDeque<>();
	//模拟排队的情况
	for(int i=0;i<10;i++) {
		final int num = i;
		que.offer(new Request() {
			@Override
			public void deposit() {
				System.out.println("第"+num+"个人，办理业务，其存款为："+Math.random()*10000);
			}
		});
		
	}
	dealWith(que);
	}
	//办理业务
	public static void dealWith(Queue<Request> que){
		Request req= null;
		while(null!=(req=que.poll())) {
			req.deposit();
		}
	}
	
}
interface Request{
	//存款
	void deposit();
}