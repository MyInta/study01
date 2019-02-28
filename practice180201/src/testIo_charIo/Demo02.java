package testIo_charIo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 写出文件
 * @author 银涛
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//创建源
		File src = new File("F:/图片/用途/JAVA相关/Plane/test02.txt");
		//选择流
		Writer writer =null;
		try {
			writer = new FileWriter(src);
			String str = "inta 终于走到了\r\n" + 
					"java学习的一条正轨上\r\n" + 
					"我们有理由相信\r\n" + 
					"在不久的将来\r\n" + 
					"Inta将会从中取得\r\n" + 
					"丰硕的收获\r\n" + 
					"让我们为王的诞生献上贺礼";
			//写出
			writer.write(str);
			
			writer.flush(); 	//强制刷出
		}catch (FileNotFoundException e) {	//文件为空
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		if(null!=writer) {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("文件写出结果失败");
			}
		}
	}
}
