package test.gof23;
/**
 * ���Զ���ʽ����ģʽ
 * @author ����
 *
 */
public class SingleTon {
	//û����ʱ���ص�����
	private static SingleTon instance = new SingleTon();//���ʼ��ʱ��������
	private SingleTon() {
	}
	//����û��ͬ��������Ч�ʸ�
	public static SingleTon getInstance() {
		return instance;
	}
}
