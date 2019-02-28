package test.memento;
/**
 * Դ������
 * @author ����
 *
 */
public class Emp {
	private String ename;
	private int age;
	private double salary;
	
	//���б��������������ر�������
	public EmpMymemento memento() {
		return new EmpMymemento(this);
	}
	//�������ݻָ����ָ���ָ������¼����
	public void recovery(EmpMymemento emm) {
		this.ename = emm.getEname();
		this.age = emm.getAge();
		this.salary = emm.getSalary();
	}
	
	public Emp(String ename, int age, double salary) {
		super();
		this.ename = ename;
		this.age = age;
		this.salary = salary;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
