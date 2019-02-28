package testIo_file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 5、操作目录
 * mkdir() 创建目录，必需确保父目录在，不在则创建失败。
 * mkdirs()创建目录，如果父目录不在，则全部创建。
 * list() 文件：目录名字符串形式
 * listFiles()
 * static listRoots() 根路径
 * @author 银涛
 *
 */
public class Demo04 {
	public static void main(String[] args) {
//		test01();
		String path = "F:/图片/用途/JAVA相关/Plane";
		File src = new File(path);
		if(src.isDirectory()) {
			System.out.println("======子目录|子文件名======");
			String[] subName = src.list();
			for(String str:subName) {
				System.out.println(str);
			}
		}
		System.out.println("======子目录|文件File对象======");
		File[] subFile = src.listFiles();
		for(File temp:subFile) {
			System.out.println(temp.getAbsolutePath());
		}
		System.out.println("======子文件.java.对象======");
		//命令设计模式 添加文件名过滤器
		subFile = src.listFiles(new	FilenameFilter() {
			/**
			 * arg0代表src arg1为该目录下的子文件名(包含扩展名)
			 */
			public boolean accept(File arg0, String arg1) {
				//考虑到有可能是扩展名为png的文件夹，要排除掉，故&&
				return arg1.endsWith(".png")&&new File(arg0,arg1).isFile();
			}
		});
		for(File temp:subFile) {
			System.out.println(temp.getAbsolutePath());
		}
	}
	public static void test01() {
		String path = "F:/图片/用途/JAVA相关/newPlane7654321/飞机01.jpg";
		File fi = new File(path);
		fi.mkdir();	
//		fi.mkdirs();
	}
}
