package testIo_others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 数据类型(基本+String字符串)的处理流
 * 1、输入流DateInputStream
 * 2、输出流DateOutputStream
 * java.io.EOFException	:该文件虽然是存在的，没有读取到我们需要的内容
 * @author 银涛
 *
 */
public class DataDemo03_ByteArray {

	public static void main(String[] args) {
		try {
			byte[] data = write();
			System.out.println(data.length);
			read(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 从文件中读取数据+类型
	 * @throws IOException 
	 */
	public static void read(byte[] data) throws IOException {
		//选择流
		DataInputStream dis = new DataInputStream(
					new BufferedInputStream(
							new ByteArrayInputStream(data)//因为字节数组输入流没有多态行为，可以直接new
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
	 * 数据+类型输出到字节数组中
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException {
		//新建字节数组
		byte[] dest = new byte[1024];
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		//因为用的是字节数组输出流，要用其方法，不能多态故新建
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//选择流
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						bos
						)
				);
		//操作 写出顺序要与读取顺序一致
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str); 	//注意是UTF，不是writeString-->不存在这个方法
		dos.flush();
		//获取数据，在关闭之前
		dest = bos.toByteArray();
		dos.close();
		bos.close();
		return dest;
	}
}
