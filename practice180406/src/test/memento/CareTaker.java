package test.memento;
/**
 * ��������
 * �������
 * @author ����
 *
 */
public class CareTaker {
	private EmpMymemento memento;
	//����ͨ�����������д������ݻ��ݣ�����ʹ��stack(����ʵ�ֺ���ȳ��ķ�ʽ)
	//private List<EpMymemento>list = new ArrayList<>();
	
	public EmpMymemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMymemento memento) {
		this.memento = memento;
	}
	
}
