package review_622;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestIOCopyDir {
	public static void main(String[] args) {
		String src = "F:/图片/用途/JAVA相关/Plane";
		String dest = "F:/图片/用途/JAVA相关/Dir";
		copyDir(src,dest);
	}
	/**
	 * 拷贝文件夹，传入地址
	 * @param srcPath
	 * @param destPath
	 */
	public static void copyDir(String srcPath,String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
	}
	/**
	 * 拷贝文件夹，传入文件
	 * @param src
	 * @param dest
	 */
	public static void copyDir(File src,File dest) {
		if(src.isDirectory()) {
			dest = new File(dest,src.getName());
		}
		//【很重要，安全问题】防止父类文件考到子文件目录中产生无限循环巨型文件
		if(dest.getAbsolutePath().contains(src.getAbsolutePath())) {
			System.out.println("不能将父类文件拷到其自身子文件目录中，会产生异常超长文件");
			return;
		}
		copyDirDetails(src,dest);
	}
	/**
	 * 文件的具体拷贝过程
	 * @param src
	 * @param dest
	 */
	public static void copyDirDetails(File src,File dest) {
		if(src.isFile()) {
			copyFile(src,dest);
		}else if(src.isDirectory()) {
			//确保生成一个目的文件
			dest.mkdirs();
			//遍历源文件内部的所有子文件，递归
			for(File temp:src.listFiles()) {
				copyDirDetails(temp,new File(dest,temp.getName()));
			}
		}
	}
	/**
	 * 拷贝文件，传入文件
	 * @param src
	 * @param dest
	 */
	public static void copyFile(File src,File dest) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1!=(len=is.read(flush))) {
				os.write(flush,0,len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO流异常");
			e.printStackTrace();
		}finally {
			if(null!=is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null!=os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 拷贝文件，传入文件地址
	 * @param srcPath
	 * @param deestPath
	 */
	public static void copyFile(String srcPath,String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyFile(src,dest);
	}
}
