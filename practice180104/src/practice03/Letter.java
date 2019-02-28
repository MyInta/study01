package practice03;
/**
 * javabean 存储数据po bo vo 包含setter getter类  
 * @author 银涛
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
