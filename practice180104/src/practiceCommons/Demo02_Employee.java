package practiceCommons;
/**
 * Ա����
 * @author ����
 *
 */
public class Demo02_Employee {
	private String name;
	private double salary;
	public Demo02_Employee() {
	}
	public Demo02_Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "��ũ��"+this.name+"\t���ʣ�"+this.salary;
	}
}
