package test.mediator;

public class Development implements Department{
	private Mediator m;	//持有中介者(总经理)的引用
	
	public Development(Mediator m) {
		super();
		this.m = m;
		m.register("development", this);
	}

	@Override
	public void selfAction() {
		System.out.println("专心科研");
	}

	@Override
	public void outAction() {
		System.out.println("汇报工作！没钱了，需要上级支持");
		m.command("finacial");
	}

}
