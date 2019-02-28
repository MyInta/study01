package testIo_bufferedIo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 字符缓冲流+新增方法（不能发生多态，故要用新的类型的变量-->将原来的Reader rd和Writer wt都改掉）
 * @author 银涛
 *
 */
public class BufferedCharIo {
	public static void main(String[] args) {
		String strScr = "F:/图片/用途/JAVA相关/Plane/test01.txt";
		String strDest = "F:/图片/用途/JAVA相关/Plane/test02.txt";
		File src = new File(strScr);
		File dest = new File(strDest);
		BufferedReader rd = null;
		BufferedWriter wt = null;
		try {
			// 选择流
			rd = new BufferedReader(new FileReader(src));
			wt = new BufferedWriter(new FileWriter(dest));
			/*char[] flush = new char[1024];
			int len = 0;
			while(-1!=(len=rd.read(flush))) {
				wt.write(flush, 0, len);
			}*/
			//新增的方法
			String line = null;
			while(null!=(line=rd.readLine())) {
				wt.write(line);	//输出该行
				wt.newLine(); 	//换行-->相当于 wt.append("\r\n");
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
