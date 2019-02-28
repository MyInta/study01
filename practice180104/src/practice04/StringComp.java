package practice04;

import java.util.Comparator;

/**
 * 排序规则的业务类
 * @author 银涛
 *
 */
public class StringComp implements Comparator<String> {
	/**
	 * 按长度比大小
	 * 正数>
	 * 负数<
	 * 相等==0
	 */
	@Override
	public int compare(String arg0, String arg1) {
		int len = arg0.length();
		int len2 = arg1.length();
		return (len-len2);
	}
	
}
