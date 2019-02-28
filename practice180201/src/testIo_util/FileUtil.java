package testIo_util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 
 * @author ����
 *
 */
public class FileUtil {
	/**
	 * JDK1.7֮������ԣ�����ֱ��ʹ��try(){}catch{}ʵ�ֹر�close  -->resourse
	 * ������ر���
	 * �ɱ������... ��ʾ����ʵ����Closeable�ӿڵ��ֻ࣬�ܷ������β����һ��λ��,����ʽ������һ��
	 */
	 public static void close(Closeable ... io) {
		 for(Closeable temp:io) {
			 if(null!=temp) {
				 try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		 }
	 }
	 /**
	  * ʹ�÷��ͷ���
	  */
	 @SafeVarargs
	public static<T extends Closeable> void closeAll(T ... io) {
		 for(Closeable temp:io) {
			 if(null!=temp) {
				 try {
					 temp.close();
				 } catch (IOException e) {
					 e.printStackTrace();
				 }
			 }
		 }
	 }
	 
}
