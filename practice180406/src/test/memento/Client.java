package test.memento;

public class Client {
	public static void main(String[] args) {
		CareTaker taker = new CareTaker();
		Emp e = new Emp("Lily",18,5000);
		System.out.println("��һ�δ�ӡ����"+e.getEname()+"---"+e.getAge()+"---"+e.getSalary());
		
		taker.setMemento(e.memento());	//����
		
		//�޸�
		e.setEname("Liza");
		e.setAge(20);
		e.setSalary(8000);
		System.out.println("�ڶ��δ�ӡ����"+e.getEname()+"---"+e.getAge()+"---"+e.getSalary());
		
		e.recovery(taker.getMemento());	//�ָ�������¼�������
		System.out.println("�����δ�ӡ����"+e.getEname()+"---"+e.getAge()+"---"+e.getSalary());
		
		
	}
}
