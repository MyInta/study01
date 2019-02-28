package test.memento;

public class Client {
	public static void main(String[] args) {
		CareTaker taker = new CareTaker();
		Emp e = new Emp("Lily",18,5000);
		System.out.println("第一次打印对象："+e.getEname()+"---"+e.getAge()+"---"+e.getSalary());
		
		taker.setMemento(e.memento());	//备忘
		
		//修改
		e.setEname("Liza");
		e.setAge(20);
		e.setSalary(8000);
		System.out.println("第二次打印对象："+e.getEname()+"---"+e.getAge()+"---"+e.getSalary());
		
		e.recovery(taker.getMemento());	//恢复到备忘录保存对象
		System.out.println("第三次打印对象："+e.getEname()+"---"+e.getAge()+"---"+e.getSalary());
		
		
	}
}
