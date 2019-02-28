package test.state;

public class Client {
	public static void main(String[] args) {
		HomeContext hs = new HomeContext();
		
		hs.setState(new FreeState());
		hs.setState(new BookedState());
		
	}
}
