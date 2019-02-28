package test.prototype;
/**
 * 深复制
 */
import java.util.Date;

public class Sheep2 implements Cloneable{
	private String name;
	private Date birthday;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		//添加代码实现深复制(deep clone)
		Sheep2 s = (Sheep2) obj;
		s.birthday= (Date) this.birthday.clone();	//把引用属性也进行拷贝 
		return obj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Sheep2(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	public Sheep2() {
	}
	
}
