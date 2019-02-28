package test.gof23;
/**
 * ��̬�ڲ��� ��������
 * @author ����
 *
 */
public class SingleTon3 {
	private static class SingleTonClassInstance{
		private static final SingleTon3 instance = new SingleTon3();
	}
	private SingleTon3() {
	}
	public static SingleTon3 getInstance() {
		return SingleTonClassInstance.instance;
	}
}
