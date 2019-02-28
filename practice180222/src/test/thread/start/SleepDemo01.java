package test.thread.start;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时
 * 1、倒数10个数 一秒打印一个
 * 2、倒计时
 * @author 银涛
 *
 */
public class SleepDemo01 {

	public static void main(String[] args) throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis()+10*1000);
		long end = endTime.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//构建下一秒的时间 相当于自减
			endTime = new Date(endTime.getTime()-1000);	//别用end-1000，因为end是固定值。
			//等待一秒后显示
			Thread.sleep(1000);
			//判断在10s以内继续，否则break
			if(end-10000>=endTime.getTime()) {
				break;
			}
		}
		
	}
	public static void test01() throws InterruptedException{
		int num =10;
		while(true) {
			System.out.println(num--);
			Thread.sleep(1000);	//暂停
			if(num<=0) {
				break;
			}
		}
	}
}
