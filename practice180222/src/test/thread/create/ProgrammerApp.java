package test.thread.create;

public class ProgrammerApp {

	public static void main(String[] args) {
		//1��������ʵ��ɫ
		Programmer pg = new Programmer();
		//2�����������ɫ+��ʵ��ɫ����  -->Tread��Programmer��ʵ����Runnable�Ľӿ�
		Thread proxy = new Thread(pg);
		//3������.start()�����߳�
		proxy.start();
		for(int i=0;i<500;i++) {
			System.out.println("һ�߿���Ƶ���ô���ing");
		}
	}

}
