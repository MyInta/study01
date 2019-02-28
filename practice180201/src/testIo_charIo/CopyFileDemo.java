package testIo_charIo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 字符流-->纯文本的拷贝
 * @author 银涛
 *
 */
public class CopyFileDemo {
	public static void main(String[] args) {
		String strScr = "F:/图片/用途/JAVA相关/Plane/test01.txt";
		String strDest = "F:/图片/用途/JAVA相关/Plane/test02.txt";
		File src = new File(strScr);
		File dest = new File(strDest);
		Reader rd = null;
		Writer wt = null;
		try {
			// 选择流
			rd = new FileReader(src);
			wt = new FileWriter(dest);
			char[] flush = new char[1024];
			int len = 0;
			while(-1!=(len=rd.read(flush))) {
				wt.write(flush, 0, len);
			}
			wt.flush(); 	//强制转出
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在，为空");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("文件读取失败");
		}finally {
			if(null!=wt) {
				try {
					wt.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("拷贝后关闭目标文件失败");
				}
			}
			if(null!=rd) {
				try {
					rd.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("拷贝后关闭原文件资源失败");
				}
			}
		}
	}
}
