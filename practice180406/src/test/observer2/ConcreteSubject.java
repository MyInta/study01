package test.observer2;

import java.util.Observable;
//目标对象
public class ConcreteSubject extends Observable{
	private int state;
	public void set(int s){
		state = s;		//
		setChanged();	//表明对象已经改变
		notifyObservers(state);	//通知所有观察者改变
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
