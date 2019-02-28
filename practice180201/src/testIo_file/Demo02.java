package testIo_file;

import java.io.File;

/**
 * 相对路径与绝对路径构造File对象
 * 假设地址：	E:/java/test/2.jpg
 * 1、相对路径
 * 	  File(String parent,String name) -->new File("E:/java/test","2.jpg");
 * 	  File(File parent,String name)	  -->new File(new File("E:/java/test"),"2.jpg");
 * 2、绝对路径
 * 	  File(String name);
 * @author 银涛
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String parentPath = "E:/java/test";
		String name = "2.jpg";
		//相对路径
		File fi = new File(parentPath,name);
		fi = new File(new File(parentPath),name);//与上面一条测试结果一样
		//绝对路径
		fi = new File("E:/java/test/2.jpg");
		System.out.println(fi.getName());	//文件名
		System.out.println(fi.getParent());	//返回上一级目录
		System.out.println(fi.getPath());	//如果是绝对路径，返回绝对，否者返回相对路径
		System.out.println("======================");
		//没有盘符以user.dir构建
		fi = new File("test.txt");
		System.out.println(fi.getName());	//文件名
		System.out.println(fi.getParent());	//返回上一级目录
		System.out.println(fi.getPath());	//如果是绝对路径，返回绝对，否者返回相对路径
		System.out.println(fi.getAbsolutePath());//获取绝对路径，即上诉的user.dir构建
	}
}
