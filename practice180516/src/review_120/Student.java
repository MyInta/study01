package review_120;

public class Student {
	/**
	 * 班级编号
	 */
	private String no;
	/**
	 * 学生姓名
	 */
	private String name;
	/**
	 * 学生成绩
	 */
	private int score;
	public Student() {
	}
	public Student(String no, String name, int score) {
		super();
		this.no = no;
		this.name = name;
		this.score = score;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	
}
