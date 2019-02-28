package practice04;
/**
 * 用于TreeSet的测试Comparator材料 实体类
 * @author 银涛
 *
 */
public class Person {
	//加final是防止TreeSet自动加行加序过程，一旦更改内容，导致的顺序不符
	private final String name;
	private final int score;
	public Person() {
		name = null;
		score = 0;
	}
	public Person(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getScore() {
		return score;
	}
//	public void setScore(int score) {
//		this.score = score;
//	}
	@Override
	public String toString() {
		return "姓名："+name+"颜值"+score+"\n";
	}
}
