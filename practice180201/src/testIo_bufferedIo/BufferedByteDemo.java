package testIo_bufferedIo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节流文件拷贝+缓冲流,提高性能
 * 缓冲流（节点流）
 * @author 银涛
 *
 */
public class BufferedByteDemo {
	public static void main(String[] args) {
	}
	/**
	 * 文件的拷贝
	 * @param 源文件路径
	 * @param 目标文件路径
	 * @throws IOException
	 * @return  
	 */
	public static void copyFile(String srcPath,String destPath)
			throws FileNotFoundException, IOException{
		//1、确保源存在且为文件，建立联系源+目的地（文件可以不存在）
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException();
		}
		//2、选择流
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//3、文件的拷贝 循环 +读取 +写出
		byte[] flush = new byte[1024];
		int len =0;
		//读取
		while(-1!=(len=is.read(flush))) {
			//写出
			os.write(flush,0,len);
		}
		os.flush();	//强制刷出
		//关闭流
		os.close();
		is.close();
	}
}
