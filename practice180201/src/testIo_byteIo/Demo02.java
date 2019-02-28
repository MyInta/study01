package testIo_byteIo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 写出文件
 * 1、建立联系File对象	目的地
 * 2、选择流  文件输出流 OutputStream FileOutputStream
 * 3、操作：write()+flush
 * 4、释放资源：关闭
 * @author 银涛
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//1、建立联系File对象	目的地
		File dest = new File("F:/图片/用途/JAVA相关/Plane/test01.txt");
		//2、选择流  文件输出流 OutputStream FileOutputStream
		OutputStream out = null;
		//以追加形式,写出文件
		try {
			out = new FileOutputStream(dest,true);//true表示追加文件，false为覆盖，默认false覆盖
		//3、操作
			String str = "Inta is the king of the new world!";
			char nextLine = '\n';	//换行
			//字符串转换成字节数组
			byte[] date = str.getBytes();
			//写入信息
			out.write(nextLine);
			out.write(date);
			
			out.flush(); 	//强制刷新出去
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("写入信息失败");
		}finally {
			try {
				if (null != out) {
					out.close();
				} 
			} catch (Exception e2) {
				System.out.println("关闭输出流失败");
			}
		}
	}
}
