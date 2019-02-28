package test.thread.start;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ
 * 1������10���� һ���ӡһ��
 * 2������ʱ
 * @author ����
 *
 */
public class SleepDemo01 {

	public static void main(String[] args) throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis()+10*1000);
		long end = endTime.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//������һ���ʱ�� �൱���Լ�
			endTime = new Date(endTime.getTime()-1000);	//����end-1000����Ϊend�ǹ̶�ֵ��
			//�ȴ�һ�����ʾ
			Thread.sleep(1000);
			//�ж���10s���ڼ���������break
			if(end-10000>=endTime.getTime()) {
				break;
			}
		}
		
	}
	public static void test01() throws InterruptedException{
		int num =10;
		while(true) {
			System.out.println(num--);
			Thread.sleep(1000);	//��ͣ
			if(num<=0) {
				break;
			}
		}
	}
}
