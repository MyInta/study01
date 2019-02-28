package review_260;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {
	public static void main(String[] args) {
		String str = "asafd123&fad5456&fdas465";
//		Pattern p =Pattern.compile("([a-z]+)([0-9]+)");
		Pattern p = Pattern.compile("\\W");
		Matcher m = p.matcher(str);
		/*System.out.println(m.find());
		System.out.println(m.find());
		System.out.println(m.find());
		System.out.println(m.find());*/
		/*while(m.find()) {
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}*/
		String newStr = m.replaceAll("_");
		System.out.println(newStr);
		String[] s =str.split("\\d+");
		System.out.println(Arrays.toString(s));
	}
}
