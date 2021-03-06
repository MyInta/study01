package testIo_others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型（基本+String）处理流
 * 1、输入流DateInputStream
 * 2、输出流DateOutputStream
 * java.io.EOFException	:该文件虽然是存在的，没有读取到我们需要的内容
 * @author 银涛
 *
 */
public class DataDemo03_File {

	public static void main(String[] args) {
		try {
//			write("F:/图片/用途/JAVA相关/Plane/data.txt");
//			read("F:/图片/用途/JAVA相关/Plane/test01.txt");//非法文件
			read("F:/图片/用途/JAVA相关/Plane/data.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 从文件中读取数据+类型
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException {
		//创建源
		File src = new File(destPath);
		//选择流
		DataInputStream dis = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(src)
							)
				);
		//读取顺序与写出一致 必须存在才能读取
		double point2 = dis.readDouble();
		long num2 = dis.readLong();
		String str2 = dis.readUTF();
		dis.close();
		System.out.println(point2+"-->"+num2+"-->"+str2);
	}
	/**
	 * 数据+类型输出到文件
	 * @throws IOException 
	 */
	public static void write(String destPath) throws IOException {
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		//创建源
		File dest = new File(destPath);
		//选择流
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//操作 写出顺序要与读取顺序一致
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str); 	//注意是UTF，不是writeString-->不存在这个方法
		dos.flush();
		dos.close();
	}
}
