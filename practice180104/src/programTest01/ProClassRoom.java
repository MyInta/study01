package programTest01;

import java.util.ArrayList;
import java.util.List;

/**
 * ������
 * һ���༶���ѧ��
 * @author ����
 *
 */
public class ProClassRoom {
	private String no;	//�༶���
	private List<ProStudent> stuList;	//ѧ���б�
	private double total;	//�༶�ܳɼ�������
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
