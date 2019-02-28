package practice01;
/**
 * 测试下几个private default protected public
 * 测试下set&get
 * @author 银涛
 *
 */
public class TestEncapsulation {
	private String name;
	private int id;
	private boolean man;
	public static final int MAX_SPEED=120;
	public static int cc;
	
	
	public boolean isMan() {	//注意boolean中的set&get的set为isXXX
		return man;
	}

	public void setMan(boolean man) {
		this.man = man;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getCc() {
		return cc;
	}

	public static void setCc(int cc) {
		TestEncapsulation.cc = cc;
	}
}
