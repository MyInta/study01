package practice01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 测试Date，字符串与时间对象之间的转换
 * @author 银涛
 *
 */
public class TestDateFormat {
	public static void main(String[] args) {
		//时间转换为字符串
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss 是当年第w周，当月第W周");
		Date d = new Date(212151313515L);
		String str = df.format(d);
		System.out.println(str);
		System.out.println("###############01");
		//字符串转换为时间对象
		DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日");
		String str2 = "2020年02月20日";	//02和2月一样效果，可换成2月20日
		try {
			Date d2 = df2.parse(str2);
			System.out.println(d2);//Date类型控制台输出有默认日期格式
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("#########02");
		Calendar c = new GregorianCalendar();
//		c.set(1976, 9, 21, 6, 55);
		c.setTime(new Date(212151313515L));
		Date d2 = c.getTime();
		//将时间转换为字符串形式
		DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str3 = df3.format(d2);
		System.out.println(str3);
		System.out.println("###########03");
		//增加原有日期的年份
		c.add(Calendar.YEAR, 42);
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.getTimeInMillis());
		
		
	}
}
