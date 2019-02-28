package programTest01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * һ�����ӻ�������С����
 * @author ����
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("�����������գ���yyyy-MM-dd����ʽ���룺");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		
		String str = inputStr;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		try {
			Date date = df.parse(str);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			//�������ʱ��ĵ�����Ϣ
			int presentDay = calendar.get(calendar.DATE);
			//��ʱ���Ϊ��������
			calendar.set(calendar.DATE, 1);
			//��õ����������
			int dayMax = calendar.getActualMaximum(calendar.DATE);
			//���ݵ�һ�����ܼ���ǰ���ſո�
			for(int i=1;i<calendar.get(calendar.DAY_OF_WEEK);i++) {
				System.out.print("\t");
			}
			for(int i=1;i<=dayMax;i++) {
				System.out.print(i);
				if(i==presentDay) {
					System.out.print("*");
				}
				System.out.print("\t");
				//������ڵ��������������Ӹ����в���
				if(calendar.get(calendar.DAY_OF_WEEK)==calendar.SATURDAY) {
					System.out.print('\n');
				}
				//���ڼ�һ��
				calendar.add(calendar.DATE, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
