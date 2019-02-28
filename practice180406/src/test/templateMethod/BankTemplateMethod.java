package test.templateMethod;

public abstract class BankTemplateMethod {
	public abstract void transact();	//办理具体的业务，钩子方法
	public void takeNumber() {
		System.out.println("取号排队");
	}
	public void evaluate() {
		System.out.println("反馈评分");
	}
	public final void process() {
		this.takeNumber();
		this.evaluate();
		this.transact();
	}
}
