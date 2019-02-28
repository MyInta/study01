package testIo_byteIo;

import java.io.File;
import java.io.IOException;

/**
 *  文件夹的拷贝
 *  1、文件赋值 CopyFile
 *  2、文件创建 mkdirs()
 *  3、递归查找子孙级
 * @author 银涛
 *
 */
public class Demo04_CopyDir {
	public static void main(String[] args) {
		String srcStr = "F:/图片/用途/JAVA相关/Plane";
		String destStr = "F:/图片/用途/JAVA相关/Dir";
		copyDir(srcStr,destStr);
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
			dest = new File(dest,src.getName());	
			//作用是将src文件夹拷到dest原地址名下(parent,name)
		}
		copyDirDetails(src, dest);
	}
	
	/**
	 * 拷贝文件夹细节
	 * @param src 源头
	 * @param dest 终点
	 */
	public static void copyDirDetails(File src,File dest) {
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
