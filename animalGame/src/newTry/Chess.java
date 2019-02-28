package newTry;

public class Chess{
	//棋子名称
	private String name;
	//棋子归属 1或者2
	private int home;
	//棋子是否存在棋盘boolean true存在 false不存在
	private boolean live;
	//棋子在棋盘的编码xCode与yCode
	private int xCode;
	private int yCode;
	//棋子的大小
	private int power;
	
	/**
	 * 空构造器
	 */
	private Chess() {
		
	}
	/**
	 * 带参构造
	 * @param name
	 * @param home
	 * @param power
	 */
	public Chess(String name, int home, int power) {
		super();
		this.name = name;
		this.home = home;
		this.power = power;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHome() {
		return home;
	}
	public void setHome(int home) {
		this.home = home;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public int getxCode() {
		return xCode;
	}
	public void setxCode(int xCode) {
		this.xCode = xCode;
	}
	public int getyCode() {
		return yCode;
	}
	public void setyCode(int yCode) {
		this.yCode = yCode;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
}
