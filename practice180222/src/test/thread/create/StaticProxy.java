package test.thread.create;
/**
 * ��̬�������ģʽ
 * 1����ʵ��ɫ
 * 2�������ɫ:������ʵ��ɫ������ 
 * 3������ʵ����ͬ�Ľӿ� �����ɫ�Է�������д
 * @author ����
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		//������ʵ��ɫ
		You you = new You();
		//���������ɫ+��ʵ��ɫ������
		WeddingAgent wa = new WeddingAgent(you);
		//ִ��
		wa.marry();
	}
}
//��ͬ�Ľӿ�
interface Marry{
	public abstract void marry();
}
//��ʵ��ɫ
class You implements Marry{
	@Override
	public void marry() {
		System.out.println("Inta��Lily�����");
	}
	
}
//�����ɫ
class WeddingAgent implements Marry{
	//��ʵ��ɫ������
	private Marry you;
	private WeddingAgent() {
	}
	public WeddingAgent(Marry you) {
		this();
		this.you = you;
	}
	private void before() {
		System.out.println("���û鷿");
	}
	private void after() {
		System.out.println("�ֶ���");
	}
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}




