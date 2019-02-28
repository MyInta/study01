package testIo_others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 三个常量
 * 1、System.in		输入流 键盘输入
 * 2、System.out	输出流 控制台输出
 * 3、System.err	后两者本质上一样，没区别，只是释义上后者为注明错误信息，会显示红色
 * 
 * ==》重定向
 * setIn()
 * setOut()
 * setErr()
 * FileDescriptor.in 输入
 * FileDescriptor.out输出
 * @author 银涛
 *
 */
public class SystemDemo06 {

	public static void main(String[] args) throws FileNotFoundException  {
		//控制台-->文件
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream(
								"F:/图片/用途/JAVA相关/Plane/psTest01"
								,true)//是否追加
						),true));	//是否打印出来
		System.out.println("hhh");
		//文件-->控制台
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream(
								FileDescriptor.out)),true));
		System.out.println("backing...");
		test01();
		
	}
	public static void test01() throws FileNotFoundException {
		InputStream is = System.in;//键盘输入
		is = new BufferedInputStream(new FileInputStream("F:/图片/用途/JAVA相关/Plane/psTest01"));
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(is);
		//System.out.println("请输入：");
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		
	}
}
