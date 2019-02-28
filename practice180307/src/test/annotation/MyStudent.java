package test.annotation;
@MyTable("tb_student")
public class MyStudent {
	@MyField(columName="sname",type="verchar",length=10)
	private String sname;
	@MyField(columName="id",type="int",length=10)
	private int id;
	@MyField(columName="age",type="int",length=3)
	private int age;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
