package practice01;
/**
 * ÐÂ°æ±¾²âÊÔ
 * @author ÒøÌÎ
 *
 */
public class HelloWorld {
	String name="haha";
	public static void main(String[] args) {
		System.out.println("Hello World~");
		HelloWorld h = new HelloWorld("inta");
		h.showName();
	}
	public HelloWorld(String name) {
		this.name = name;
	}
	public void showName() {
		System.out.println(name);
	}
	public HelloWorld() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
