package testIo_convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * 转换流：字节转为字符
 * 1、输出流 	OutputStreamWriter	编码
 * 2、输入流	InputStreamReader	解码
 * @author 银涛
 *
 */
public class Demo02Convert {

	public static void main(String[] args) throws IOException {
		File src = new File("F:/图片/用途/JAVA相关/Plane/Demo06.java");
		File dest = new File("F:/图片/用途/JAVA相关/Plane/Demo07.java");
		//指定解码字符集
		BufferedReader br = new BufferedReader(				//缓冲流
				new InputStreamReader(							//转换流 二进制-->字符串
						new FileInputStream(src), "utf-8"));	//节点流
		//写出文件
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(		
						new FileOutputStream(dest),"utf-8"));	//根据解码字符集,选择编码字符集
		String line = null;
		while(null!=(line = br.readLine())) {
			bw.write(line);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
