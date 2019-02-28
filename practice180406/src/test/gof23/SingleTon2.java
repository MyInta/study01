package test.gof23;
/**
 * ��������ʽ����ģʽ
 * @author ����
 *
 */
public class SingleTon2 {
	//����ʱ���ص�����,������ʱ�ټ���
	private static SingleTon2 instance;
	private SingleTon2() {
	}
	//����û��ͬ��������Ч�ʸ�
	public static synchronized SingleTon2 getInstance() {
		if(instance==null) {
			instance = new SingleTon2();
		}
		return instance;
	}
}
