package practice01;
/**
 * �����¼���private default protected public
 * ������set&get
 * @author ����
 *
 */
public class TestEncapsulation {
	private String name;
	private int id;
	private boolean man;
	public static final int MAX_SPEED=120;
	public static int cc;
	
	
	public boolean isMan() {	//ע��boolean�е�set&get��setΪisXXX
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
