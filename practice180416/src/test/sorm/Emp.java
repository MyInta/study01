package test.sorm;

import java.sql.Date;

public class Emp { //表结构和类一致
	private Integer id;
	private String empname;
	private double salary;
	private Date birthday;
	private Integer age;
	private Integer deptId;

	public Emp() {
	}
	
	public Emp(Integer id, String empname, double salary, Date birthday, Integer age, Integer deptId) {
		super();
		this.id = id;
		this.empname = empname;
		this.salary = salary;
		this.birthday = birthday;
		this.age = age;
		this.deptId = deptId;
	}
	
	public Emp(String empname, double salary, Integer age) {
		super();
		this.empname = empname;
		this.salary = salary;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
}
