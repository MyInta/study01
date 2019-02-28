package sorm.utils;
/**
 * 封装了字符串常用操作
 * @author 银涛
 *
 */
public class StringUtils {
	
	/**
	 * 将目标字符串转换为首字母大写
	 * @param str 目标字符串
	 * @return	首字母为大写的字符串
	 */
	public static String firstChar2UpperCase(String str) {
		//abcd-->Abcd
		//abcd-->ABCD-->Abcd
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
}
