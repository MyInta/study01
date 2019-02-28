package test.observer;

public class ObserverA implements Observer{
	private int myState;	//需要与目标对象的state一致
	@Override
	public void update(Subject sub) {
		myState = ((ConcreteSubject)sub).getState();
	}
	public int getMyState() {
		return myState;
	}
	public void setMyState(int myState) {
		this.myState = myState;
	}
	
}
