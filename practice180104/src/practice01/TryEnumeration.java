package practice01;
/**
 * ö�ٵĲ���
 * @author ����
 *
 */
public class TryEnumeration {
	//����Day
	enum Day{monday,tuesday,wednesday,thursday,friday,saturday,sunday}
	public static void main(String[] args) {
		//�������ֲ�ͬ������Day
		Day yesterday = Day.tuesday;
		Day today = Day.wednesday;
		Day tomorrow = Day.thursday;
		System.out.println("yesterday was:"+yesterday);
		System.out.println("today is:"+today);
		System.out.println("tomorrow will be:"+tomorrow);
	}
}
