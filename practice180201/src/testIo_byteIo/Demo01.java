package testIo_byteIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件的读取
 * 1、建立联系File对象	源头
 * 2、选择流  文件输入流 InputStream FileInputStream
 * 3、操作：byte[] car = new byte[1024]; +read +读取大小
 * 		      输出
 * 4、释放资源：关闭
 * @author 银涛
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//1、建立联系File对象
		File src = new File("F:/图片/用途/JAVA相关/Plane/test01.txt");
		//2、选择流 
		InputStream in = null;	//提升作用域
		try {
			in = new FileInputStream(src);
			//3、操作不断读取	缓冲数组
			byte[] car = new byte[10];
			int len = 0;//接受实际读取大小
			//循环读取
			while(-1!=(len=in.read(car))) {
				//输出 字节数组转成字符串
				String info = new String(car, 0, len);
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件为空");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取文件失败");
		}finally {
			try {
				//4、释放资源
				if (null != in) {	//Alt+shift+z 选择catch 即数字7的功能
					in.close();
				} 
			} catch (Exception e2) {
				System.out.println("关闭文件输入流失败");
			}
		}
		

	}
}
