package test.memento;
/**
 * 负责人类
 * 管理对象
 * @author 银涛
 *
 */
public class CareTaker {
	private EmpMymemento memento;
	//可以通过容器来进行大量数据回溯，建议使用stack(可以实现后进先出的方式)
	//private List<EpMymemento>list = new ArrayList<>();
	
	public EmpMymemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMymemento memento) {
		this.memento = memento;
	}
	
}
