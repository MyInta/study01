package test.command;
/**
 * ����ĵ����ߺͷ�����
 * @author ����
 *
 */
public class Invoke {
	private Command command;	//Ҳ����ͨ������List<Command>ʵ�ֺܶ������,�����ݿ�ײ���������

	public Invoke(Command command) {
		super();
		this.command = command;
	}
	//ҵ�񷽷������ڵ���������ķ���
	public void call() {
		command.execute();
	}
}
