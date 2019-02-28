package test.state;

public class CheckedState implements State{

	@Override
	public void handle() {
		System.out.println("房间被预定，暂时不能定！");
	}

}
