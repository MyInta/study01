package dto;

import java.io.Serializable;

public class Player implements Comparable<Player>,Serializable{
	
	private String name;
	
	private int point;

	public Player() {
	}
	
	public Player(String name, int point) {
		super();
		this.name = name;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	/**
	 * 按分数倒叙，及返回值为负，从大到小排序。对应参数形式为，后者减去前者及实现倒叙，反之正序。
	 */
	@Override
	public int compareTo(Player pla) {
		return pla.point-this.point;
	}
	
}
