package practiceCommons;
/**
 * 等级类
 * @author 银涛
 *
 */
public class Demo02_Level {
	private String name;
	private String level;
	public Demo02_Level() {
	}
	public Demo02_Level(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "(码农："+this.name+",水平："+this.level+")";
	}
}
