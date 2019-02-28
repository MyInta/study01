package test.javassist;

public class Emp {
	private String ename;
	private int empno;
	
	public void sayHello(int a) {
		System.out.println("Say Hello-->"+a);
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public Emp(String ename, int empno) {
		super();
		this.ename = ename;
		this.empno = empno;
	}
	public Emp() {
	}
}
