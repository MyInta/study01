package newTry;

public class Chess{
	//��������
	private String name;
	//���ӹ��� 1����2
	private int home;
	//�����Ƿ��������boolean true���� false������
	private boolean live;
	//���������̵ı���xCode��yCode
	private int xCode;
	private int yCode;
	//���ӵĴ�С
	private int power;
	
	/**
	 * �չ�����
	 */
	private Chess() {
		
	}
	/**
	 * ���ι���
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
