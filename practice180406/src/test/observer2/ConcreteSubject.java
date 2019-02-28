package test.observer2;

import java.util.Observable;
//Ŀ�����
public class ConcreteSubject extends Observable{
	private int state;
	public void set(int s){
		state = s;		//
		setChanged();	//���������Ѿ��ı�
		notifyObservers(state);	//֪ͨ���й۲��߸ı�
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
