package practice03;
/**
 * 自定义泛型类
 * 1、<> -->为了规范用单个大写字母，尽可能见名知意
 * 2、T Tape 	
 * 	K V Key Value 
 * 	E Element
 * 3、泛型不能使用在静态属性上
 * 指定的类型不能为基本类型
 * 
 * @author 银涛
 *
 */
public class Student<T> {
	private T javase;
	public Student() {
	}
	public Student(T javase) {
		super();
		this.javase = javase;
	}
	public T getJavase() {
		return javase;
	}
	public void setJavase(T javase) {
		this.javase = javase;
	}
}
