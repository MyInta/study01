package practice04;
/**
 * 实现Comparable的接口
 * @author 银涛
 *
 */
public class Person02 implements java.lang.Comparable<Person02> {
	private String name;
	private int score;
	public Person02() {
	}
	public Person02(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * 重写compareTo的方法
	 */
	@Override
	public int compareTo(Person02 arg0) {
		//返回值正，即前者大于后者降序；零即相等；负数说明前者小于后者为升序
		return this.score>arg0.getScore()?1:this.score==arg0.getScore()?0:-1;
	}
	@Override
	public String toString() {
		return "名字："+name+"颜值分数："+score+"\n";
	}
}
