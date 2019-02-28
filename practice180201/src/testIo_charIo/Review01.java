package testIo_charIo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 对比copyFileDemo缺少新建文件，但可行，
 * 原因是FileReader已经实现了str对文件的转变
 * @author 银涛
 *
 */
public class Review01 {
	public static void main(String[] args) {
		String src = "F:/图片/用途/JAVA相关/Plane/test01.txt";
		String dest = "F:/图片/用途/JAVA相关/Plane/test02.txt";
		Reader rd = null;
		Writer wt = null;
		try {
			rd = new FileReader(src);
			wt = new FileWriter(dest);
			char[] flush = new char[1024];
			int len =0;
			while(-1!=(len=rd.read(flush))) {
				wt.write(flush,0,len);
			}
			wt.flush();
		} catch (IOException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		}finally {
			testIo_util.FileUtil.close(wt,rd);
		}
		
	}
}
