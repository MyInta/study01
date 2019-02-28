package testIo_others;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * PrintStream 打印流-->处理流
 * @author 银涛
 *
 */
public class PrintStreamDemo05 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("test");
		PrintStream ps = System.out;
		ps.print("It's a new test");
		//输出到文件
		//新建文件
		File src = new File("F:/图片/用途/JAVA相关/Plane/psTest01");
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(src,true)));//true表示可累加
		ps.print("In this world i am the king!");
//		ps.flush();
		testIo_util.FileUtil.close(ps);
	}
}
