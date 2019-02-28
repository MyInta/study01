package practice01;
/**
 * 枚举的测试
 * @author 银涛
 *
 */
public class TryEnumeration {
	//定义Day
	enum Day{monday,tuesday,wednesday,thursday,friday,saturday,sunday}
	public static void main(String[] args) {
		//定义三种不同变量的Day
		Day yesterday = Day.tuesday;
		Day today = Day.wednesday;
		Day tomorrow = Day.thursday;
		System.out.println("yesterday was:"+yesterday);
		System.out.println("today is:"+today);
		System.out.println("tomorrow will be:"+tomorrow);
	}
}
