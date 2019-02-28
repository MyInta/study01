package test.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> list = new ArrayList<>();
	
	public void register(Observer obs) {
		list.add(obs);
	}
	public void remove(Observer obs) {
		list.remove(obs);
	}
	//֪ͨ���й۲��߸���״̬
	public void notifyAllObservers() {
		for(Observer obs:list) {
			obs.update(this);
		}
	}
}
