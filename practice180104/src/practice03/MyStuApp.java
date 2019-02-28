package practice03;
/**
 * 没有泛型的类存储数据，结果麻烦
 * @author 银涛
 *
 */
public class MyStuApp {
	public static void main(String[] args) {
		MyStudent stu = new MyStudent(80);
		//接受回来
		Object javase = stu.getJavase();
		//避免转换异常
		if(javase instanceof Integer) {
			Integer javaScore = (Integer) javase;
			System.out.println(javaScore);
		}
	}
}
