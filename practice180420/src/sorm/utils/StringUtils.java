package sorm.utils;
/**
 * ��װ���ַ������ò���
 * @author ����
 *
 */
public class StringUtils {
	
	/**
	 * ��Ŀ���ַ���ת��Ϊ����ĸ��д
	 * @param str Ŀ���ַ���
	 * @return	����ĸΪ��д���ַ���
	 */
	public static String firstChar2UpperCase(String str) {
		//abcd-->Abcd
		//abcd-->ABCD-->Abcd
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
}
