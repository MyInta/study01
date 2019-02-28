package programTest01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 一个可视化日历的小程序
 * @author 银涛
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("请输入年月日，以yyyy-MM-dd的形式输入：");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		
		String str = inputStr;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		try {
			Date date = df.parse(str);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			//获得输入时候的当天信息
			int presentDay = calendar.get(calendar.DATE);
			//将时间归为当月首天
			calendar.set(calendar.DATE, 1);
			//获得当月最大天数
			int dayMax = calendar.getActualMaximum(calendar.DATE);
			//根据第一天是周几往前面排空格
			for(int i=1;i<calendar.get(calendar.DAY_OF_WEEK);i++) {
				System.out.print("\t");
			}
			for(int i=1;i<=dayMax;i++) {
				System.out.print(i);
				if(i==presentDay) {
					System.out.print("*");
				}
				System.out.print("\t");
				//如果日期到了周六，则额外加个换行操作
				if(calendar.get(calendar.DAY_OF_WEEK)==calendar.SATURDAY) {
					System.out.print('\n');
				}
				//日期加一天
				calendar.add(calendar.DATE, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
