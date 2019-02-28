package programTest01;

import java.util.ArrayList;
import java.util.List;

/**
 * 教室类
 * 一个班级多个学生
 * @author 银涛
 *
 */
public class ProClassRoom {
	private String no;	//班级编号
	private List<ProStudent> stuList;	//学生列表
	private double total;	//班级总成绩的容器
	public ProClassRoom() {
		stuList = new ArrayList<ProStudent>();
	}
	public ProClassRoom(String no) {
		this();
		this.no = no;
	}
	public ProClassRoom(String no, List<ProStudent> stuList, double total) {
		super();
		this.no = no;
		this.stuList = stuList;
		this.total = total;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<ProStudent> getStuList() {
		return stuList;
	}
	public void setStuList(List<ProStudent> stuList) {
		this.stuList = stuList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
