package test.state;
/**
 * 房间对象
 * @author 银涛
 *
 */
public class HomeContext {
	private State state;

	public void setState(State s) {
		System.out.println("修改状态");
		this.state = s;
		s.handle();
	}
	
}
