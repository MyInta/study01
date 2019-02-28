package test.command;

public interface Command {
	/**
	 * 这个方法是返回为空的方法
	 * 可以根据实际项目，设计多个不同方法
	 */
	void execute();
}
class ConcreteCommand implements Command{
	private Receiver receiver;
	
	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		//命令执行前或后执行相关处理
		receiver.action();
	}
	
}