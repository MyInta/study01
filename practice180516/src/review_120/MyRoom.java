package review_120;

import java.util.ArrayList;
import java.util.List;

public class MyRoom {
	/**
	 * 班级编号
	 */
	private String no;
	/**
	 * 班级内的学生列表
	 */
	private List<Student> stuList;
	/**
	 *班级总成绩
	 */
	private double tolScore;
	public MyRoom() {
		stuList = new ArrayList<Student>();
	}
	public MyRoom(String no) {
		this();
		this.no = no;
	}
	public MyRoom(String no, List<Student> stuList) {
		super();
		this.no = no;
		this.stuList = stuList;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<Student> getStuList() {
		return stuList;
	}
	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	public double getTolScore() {
		return tolScore;
	}
	public void setTolScore(double tolScore) {
		this.tolScore = tolScore;
	}
	
}
