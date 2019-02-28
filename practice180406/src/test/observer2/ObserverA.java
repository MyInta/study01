package test.observer2;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer{
	private int maState;
	@Override
	public void update(Observable arg0, Object arg1) {
		maState = ((ConcreteSubject)arg0).getState();
	}
	public int getMaState() {
		return maState;
	}
	public void setMaState(int maState) {
		this.maState = maState;
	}
	
}
