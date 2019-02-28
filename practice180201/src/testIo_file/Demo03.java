package testIo_file;

import java.io.File;
import java.io.IOException;

/**
 * 常用方法
 * 1、文件名
 * 	  getName()文件名、路径名
 * 	  getPath()路径名
 * 	  getAbsoluteFile	绝对路径下获取File对象
 * 	  getAbsolutePath	绝对路径名
 * 	  getParent()		父目录，相对路径的父母录，可能为null，如删除本身后的结果
 * 2、判断信息
 * 	  exists()
 * 	  canWrite()
 * 	  canRead()
 * 	  isFile()
 * 	  isDirectory()
 * 	  isAbsolute() :消除平台差异，ie以盘符开头，其他以/开头
 * 3、长度 -->字节数 不能读取文件夹的长度，会显示为0
 * 	  length()
 * 4、创建、删除
 * 	  createNewFile() 不存在创建文件，存在返回false
 * 	  delete() 删除文件
 * 	  static createTempFile(前缀3个字节长，后缀默认.temp) 默认临时空间
 * 	  static createTempFile(前缀3个字节长，后缀默认.temp,目录)
 * 	  deleteOnExit() 退出虚拟机删除，常用于临时文件的删除
 * @author 银涛
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		test02();
		try {
			try {
				test03();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("文件操作失败");
			}
	}
	//1、文件名
	public static void test01() {
		File fi = new File("E:/java/test/2.jpg");
//		fi = new File("2.jpg");//相对路径案例
		System.out.println(fi.getName());	//文件名
		System.out.println(fi.getParent());	//返回上一级目录，如果是相对，可能为null
		System.out.println(fi.getPath());	//如果是绝对路径，返回绝对，否者返回相对路径
		System.out.println(fi.getAbsolutePath());//返回绝对路径
	}
	//2、判断信息
	public static void test02() {
		String path = "F:/图片/用途/JAVA相关/Plane/飞机01.jpg";	//用于main里面判断存在与否
		File fi = new File(path);
		//是否存在
		System.out.println("文件是否存在"+fi.exists());
		//是否可读
		System.out.println("文件是否存在"+fi.canRead());
		System.out.println("===================");
		//isFile()
		//isDirectory()
		if(fi.isFile()) {
			System.out.println("是【文件】");
		}else if(fi.isDirectory()){
			System.out.println("是【文件夹】");
		}else {
			System.out.println("文件不存在");
		}
		//isAbsolute() :消除平台差异，ie以盘符开头，其他以/开头
		System.out.println("是否为绝对路径:"+fi.isAbsolute());
		//长度字节数
		System.out.println("长度的字节数为："+fi.length());
	}
	public static void test03() throws IOException, InterruptedException {
		//createNewFile() 不存在创建文件
//		String path = "F:/图片/用途/JAVA相关/Plane/con";//创建会失败
		String path = "F:/图片/用途/JAVA相关/Plane/飞机08.jpg";
		File fi = new File(path);
		if(!fi.exists()) {
			//创建新文件，并且需要判断操作成功与否，有时会失败，如文件名为关键字con
			boolean flag = fi.createNewFile();
			System.out.println(flag?"创建新文件成功":"创建新文件失败");
		}
		
		//delete() 删除文件
		boolean flag = fi.delete();
		System.out.println(flag?"删除文件成功":"删除文件失败");
		//static createTempFile(前缀3个字节长，后缀默认.temp) 默认临时空间
		//static createTempFile(前缀3个字节长，后缀默认.temp,目录)
		File temp = File.createTempFile("test", ".temp", new File("F:/图片/用途/JAVA相关/Plane/"));
		Thread.sleep(3000);
		temp.deleteOnExit();//退出即删除
	}
}
