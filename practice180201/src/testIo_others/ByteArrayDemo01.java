package testIo_others;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组 节点流
 * 数组的长度有限，数据量不会很大
 * @author 银涛
 *
 */
public class ByteArrayDemo01 {

	public static void main(String[] args) throws IOException {
		read(write());
	}
	/**
	 * 输出流，操作不一样
	 * 实现与文档不同的新方法，不能用多态
	 */
	public static byte[] write() {
		//目的地
		byte[] dest;
		//选择流
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		//\r相当于“+”，而\n是换行
		String str = "Inta is the king of the new world!\r\n"
				+ "让我们为王的诞生\r\n"
				+ "献上贺礼！！！";
		byte[] src;
		src = str.getBytes();
		bo.write(src, 0, src.length); // 注意长度为该数组长度
		// 获取数据
		// bo.close();//同理，由于继承了closable不需要再重复关闭资源操作
		dest = bo.toByteArray();
		return dest;
	}
	/**
	 * 输入流，操作与文件输入流一致
	 * 读取字节数组
	 * @throws IOException 
	 */
	public static void read(byte[] dest) throws IOException {
		//数据源传入
		//选择流
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(
						dest
						)
				);
		//操作
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(flush))) {
			System.out.println(new String(flush,0,len));
		}
//		is.close();//byteArray类型不需要在关闭，因为本身继承了closable
	}
}
