package test.command;
/**
 * 命令的调用者和发起者
 * @author 银涛
 *
 */
public class Invoke {
	private Command command;	//也可以通过容器List<Command>实现很多个命令,如数据库底层的事务管理

	public Invoke(Command command) {
		super();
		this.command = command;
	}
	//业务方法，用于调用命令类的方法
	public void call() {
		command.execute();
	}
}
