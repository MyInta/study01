package test.templateMethod;

public abstract class BankTemplateMethod {
	public abstract void transact();	//���������ҵ�񣬹��ӷ���
	public void takeNumber() {
		System.out.println("ȡ���Ŷ�");
	}
	public void evaluate() {
		System.out.println("��������");
	}
	public final void process() {
		this.takeNumber();
		this.evaluate();
		this.transact();
	}
}