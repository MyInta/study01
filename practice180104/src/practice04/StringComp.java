package practice04;

import java.util.Comparator;

/**
 * ��������ҵ����
 * @author ����
 *
 */
public class StringComp implements Comparator<String> {
	/**
	 * �����ȱȴ�С
	 * ����>
	 * ����<
	 * ���==0
	 */
	@Override
	public int compare(String arg0, String arg1) {
		int len = arg0.length();
		int len2 = arg1.length();
		return (len-len2);
	}
	
}
