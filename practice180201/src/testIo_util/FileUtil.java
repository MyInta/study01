package testIo_util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 
 * @author 银涛
 *
 */
public class FileUtil {
	/**
	 * JDK1.7之后的特性，可以直接使用try(){}catch{}实现关闭close  -->resourse
	 * 工具类关闭流
	 * 可变参数：... 表示所有实现了Closeable接口的类，只能放置于形参最后一个位置,处理方式与数组一致
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
	  * 使用泛型方法
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
