package practice03;
/**
 * javabean �洢����po bo vo ����setter getter��  
 * @author ����
 *
 */
public class Letter {
	private String name;
	private int count;
	public Letter() {
	}
	public Letter(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Letter(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	
}