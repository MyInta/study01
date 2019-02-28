package practice01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * ����Date���ַ�����ʱ�����֮���ת��
 * @author ����
 *
 */
public class TestDateFormat {
	public static void main(String[] args) {
		//ʱ��ת��Ϊ�ַ���
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss �ǵ����w�ܣ����µ�W��");
		Date d = new Date(212151313515L);
		String str = df.format(d);
		System.out.println(str);
		System.out.println("###############01");
		//�ַ���ת��Ϊʱ�����
		DateFormat df2 = new SimpleDateFormat("yyyy��MM��dd��");
		String str2 = "2020��02��20��";	//02��2��һ��Ч�����ɻ���2��20��
		try {
			Date d2 = df2.parse(str2);
			System.out.println(d2);//Date���Ϳ���̨�����Ĭ�����ڸ�ʽ
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("#########02");
		Calendar c = new GregorianCalendar();
//		c.set(1976, 9, 21, 6, 55);
		c.setTime(new Date(212151313515L));
		Date d2 = c.getTime();
		//��ʱ��ת��Ϊ�ַ�����ʽ
		DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str3 = df3.format(d2);
		System.out.println(str3);
		System.out.println("###########03");
		//����ԭ�����ڵ����
		c.add(Calendar.YEAR, 42);
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.getTimeInMillis());
		
		
	}
}
