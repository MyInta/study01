package test.bean;

public class User {
	private String uname;
	private int id;
	private int age;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public User(String uname, int id, int age) {
		super();
		this.uname = uname;
		this.id = id;
		this.age = age;
	}
	public User() {
	}
	@Override
	public String toString() {
		return this.uname+"--"+this.id+"--"+this.age;
	}
	
}
