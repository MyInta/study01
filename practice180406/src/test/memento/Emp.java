package test.memento;
/**
 * 源发器类
 * @author 银涛
 *
 */
public class Emp {
	private String ename;
	private int age;
	private double salary;
	
	//进行备忘操作，并返回备忘对象
	public EmpMymemento memento() {
		return new EmpMymemento(this);
	}
	//进行数据恢复，恢复成指定备忘录对象
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
