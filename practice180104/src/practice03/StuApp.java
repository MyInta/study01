package practice03;
/**
 * 
 * @author ÒøÌÎ
 *
 */
public class StuApp {
	public static void main(String[] args) {
//		Student<int> stu = new Student<int>();
		Student<Integer> stu = new Student<Integer>();
		stu.setJavase(80);
		Integer score = stu.getJavase();
		System.out.println(score);
	}
}
