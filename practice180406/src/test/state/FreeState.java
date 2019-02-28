package test.state;

public class FreeState implements State{

	@Override
	public void handle() {
		System.out.println("房间空着，欢迎入住！");
	}

}
