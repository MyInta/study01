package test.state;

public class BookedState implements State{

	@Override
	public void handle() {
		System.out.println("房间已被预定，不能入住！");
	}

}
