package testIo_byteIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、建立联系	File对象 源头 目的地
 * 2、选择流
 * 		文件输入流 InputStream FileInputStream
 * 		文件输出流 OutputStream FileOutputStream
 * 3、操作：	拷贝
 * 		byte[] flush = byte[1024];
 * 		int len = 0;
 * 		while(-1!=(len=输入流.read(flush))){
 * 			输出流.write(flush,0,len);
 * 		}
 * 4、释放资源：关闭两个流
 * @author 银涛
 *
 */
public class Demo03_CopyFile {
	public static void main(String[] args) {
		String srcPath = "F:/图片/用途/JAVA相关/Plane/bg.jpg";  //试试将后面的文件名隐去，报异常情况
		String destPath = "F:/图片/用途/JAVA相关/Plane/bg2.jpg";
		try {
			copyFile(srcPath, destPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件为空");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("拷贝文件失败");
		}
	}
	/**
	 * 文件的拷贝
	 * @param 源文件路径
	 * @param 目标文件路径
	 * @throws IOException
	 * @return  
	 */
	public static void copyFile(String srcPath,String destPath) throws FileNotFoundException, IOException{
		//1、确保源存在且为文件，建立联系源+目的地（文件可以不存在）
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException();
		}
		//2、选择流
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
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
