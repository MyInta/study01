package testIo_file;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙级目录|文件名称（绝对路径）
 * 1、ListFiles()
 * 2、递归
 * 
 * static listRoots() 根路径
 * @author 银涛
 *
 */
public class Demo05 {

	public static void main(String[] args) {
		String path = "F:/图片/用途/JAVA相关/Plane";
		File src = new File(path);
		printName(src);
		System.out.println("=========根目录==========");
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
	}
	public static void printName(File arg0) {
		//先排除空与不存在情况
		if (arg0 == null || !arg0.exists()) {
			return;
		}
		System.out.println(arg0.getAbsolutePath());
		//判断arg0下面还有无子文件，有则递归法全导出来
		if(arg0.isDirectory()) {
			for(File temp:arg0.listFiles()) {
				printName(temp);	//递归法，将子文件导出
			}
		}
	}
}
