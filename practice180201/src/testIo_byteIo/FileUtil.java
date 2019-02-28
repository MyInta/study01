package testIo_byteIo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 1、文件拷贝
 * 2、文件夹拷贝
 * @author 银涛
 *
 */
public class FileUtil {
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
		copyFile(new File(srcPath),new File(destPath));
	}
	/**
	 * 文件的拷贝
	 * @param 源文件File对象
	 * @param 目标文件File对象
	 * @throws IOException
	 * @return  
	 */
	public static void copyFile(File src,File dest) 
			throws FileNotFoundException, IOException{
		if(!src.isFile()) {
			System.out.println("只能拷贝文件");
			throw new IOException();
		}
		//如果dest为已存在的文件夹，因为拷贝文件能覆盖文件，但不能覆盖同名文件夹，故需要抛异常
		if(dest.isDirectory()) {
			System.out.println("不能建立文件夹同名的文件");
			throw new IOException(dest.getAbsolutePath()+"不能建立文件夹同名的文件");
		}
		//2、选择流-->并且包裹成 【缓冲流】--BufferedInputStream()&BufferedOutputStream()
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
		close(os,is);
	}
	/**
	 * 关闭流，释放资源操作
	 * @param io
	 */
	 public static void close(Closeable ... io) {
		 for(Closeable temp:io) {
			 if(null!=temp) {
				 try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		 }
	 }
	/**
	 * 拷贝文件夹
	 * @param src	源路径
	 * @param dest	目标路径
	 */
	public static void copyDir(String srcPath,String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
	}
	
	/**
	 * 拷贝文件夹-->将目标文件夹考到目的地下，并将内部细节拷贝
	 * @param src	源File对象
	 * @param dest	目标File对象
	 */
	public static void copyDir(File src,File dest) {
		if(src.isDirectory()) {
			dest = new File(dest,src.getName());	//作用是将src文件夹拷到dest原地址名下
		}
		//预防父目录进入子目录产生递归，生成超长目录文件
		if(dest.getAbsolutePath().contains(src.getAbsolutePath())) {
			System.out.println("不能将父目录拷贝到子目录下");
			return;
		}
		copyDirDetails(src, dest);
	}
	
	/**
	 * 拷贝文件夹细节
	 * @param src
	 * @param dest
	 */
	private static void copyDirDetails(File src,File dest) {
		//查找文件
		if(src.isFile()) {
			try {
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(src.isDirectory()) {
			//确保目的地文件路径存在,不存在则创建一个新文件
			dest.mkdirs();
			//遍历里面的子孙级，利用递归层层剥析
			for(File sub:src.listFiles()) {
				copyDirDetails(sub, new File(dest,sub.getName()));
			}
		}
		
	}
}
