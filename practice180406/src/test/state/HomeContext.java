package test.state;
/**
 * �������
 * @author ����
 *
 */
public class HomeContext {
	private State state;

	public void setState(State s) {
		System.out.println("�޸�״̬");
		this.state = s;
		s.handle();
	}
	
}
