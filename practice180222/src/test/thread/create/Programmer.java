package test.thread.create;
/**
 * �Ƽ�Runnable�����߳�
 * 1�����ⵥ�̳о�����
 * 2�����ڹ�����Դ
 * 
 * ʹ��Runnable�����߳�
 * 1����ʵ��Runnable�ӿ� ��дrun()���� -->��ʵ��ɫ��
 * 2���������߳� ʹ�þ�̬����
 * 	1��������ʵ��ɫ
 * 	2�����������ɫ+��ʵ��ɫ����
 * 	3������.start()�����߳�
 * @author ����
 *
 */
public class Programmer implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("һ���ô��룬һ�ߡ�����");
		}
	}
}
