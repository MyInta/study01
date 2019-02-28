package test.strategy;
/**
 * �������Ĳ����ཻ��
 * �����Ļ� �ͻ��˺��㷨��������
 * ���ʹ��spring������ע�룬������ͨ�������ļ�����̬ע�벻ͬ���Զ��󣬶�̬�л���ͬ�㷨
 * @author ����
 *
 */
public class Context {
	private Strategy strategy;
	//ͨ����������ע��
	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	//ͨ��set��ע��
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	public void printPrice(double s) {
		System.out.println("���ñ��ۣ�"+strategy.getPrice(s));
	}
}
