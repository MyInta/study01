package programTest01;
/**
 * 学生类
 * @author 银涛
 *
 */
public class ProStudent {
	private String name;	//姓名
	private String no;		//班级
	private double score;	//成绩
public ProStudent() {
}
public ProStudent(String name, String no, double score) {
	super();
	this.name = name;
	this.no = no;
	this.score = score;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNo() {
	return no;
}
public void setNo(String no) {
	this.no = no;
}
public double getScore() {
	return score;
}
public void setScore(double score) {
	this.score = score;
}
}
