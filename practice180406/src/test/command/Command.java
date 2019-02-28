package test.command;

public interface Command {
	/**
	 * ��������Ƿ���Ϊ�յķ���
	 * ���Ը���ʵ����Ŀ����ƶ����ͬ����
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
		//����ִ��ǰ���ִ����ش���
		receiver.action();
	}
	
}