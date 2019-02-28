package testIo_others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、文件--> 程序-->字节数组
 * 	1) 文件输入流	
 * 	2) 字节数组输出流
 * 2、字节数组-->程序-->文件
 * 	1）字节数组输入流
 * 	2）文件输出流
 * @author 银涛
 *
 */
public class ByteArrayDemo02 {

	public static void main(String[] args) throws IOException {
		String path ="F:/图片/用途/JAVA相关/Plane/bg.jpg";
		String destPath = "F:/图片/用途/JAVA相关/Plane/文件-字节数组-文件.jpg";
		byte[] date = getBytesFromFile(path);
		toFileFromByteArray(date, destPath);
	}
	
	/**
	 * 1、文件--> 程序-->字节数组
	 *  1) 文件输入流 
	 *  2) 字节数组输出流
	 * @param strPath
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesFromFile(String strPath) throws IOException {
		//创建文件源
		File src = new File(strPath);
		//创建字节数组目的地
		byte[] dest = null;
		//选择流
		// 文件输入流
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		// 字节输出流 不能使用多态
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			//写出到字节数组中
			bo.write(flush, 0, len);
		}
		bo.flush();//强制刷出
		//获取数据
		dest = bo.toByteArray();
		
		is.close();
		bo.close();
		return dest;
	}
	/**
	 * 2、字节数组-->程序-->文件
	 * 	1）字节数组输入流
	 * 	2）文件输出流
	 */
	public static void toFileFromByteArray(byte[] src,String destPath) throws IOException {
		//创建源
		//目的地
		File dest = new File(destPath);
		//字节数组输入流
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//文件输出流
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//操作 不断读取字节数组
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			//写出到文件中
			os.write(flush, 0, len);
		}
		os.flush();//强制刷出
		is.close();
		os.close();
	}
}
