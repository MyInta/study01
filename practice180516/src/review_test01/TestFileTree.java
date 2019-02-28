package review_test01;

import java.io.File;

/**
 * 测试打印出目标目录下所有文件名称，平且按照层级打印前缀-符号
 * @author 银涛
 *
 */
public class TestFileTree {

	public static void main(String[] args) {
		
		File f = new File("F:/图片/用途");
		printFileNames(f, 0);
	}
	
	/**
	 * 打印文件名称的方法
	 * 核心思想是递归
	 * 要实现递归头和递归体
	 * @param f 传入文件父目录
	 * @param level 文件层级
	 */
	public static void printFileNames(File parent,int level) {
		
		//遍历层级创建前缀-符号
		for(int i=0;i<level;i++) {
			System.out.print("-");
		}
		//先打印出其文件名称
		System.out.println(parent.getName());
		//判断有无子目录，递归
		if(parent.isDirectory()) {
			//如果是目录文件夹，则寻找其子文件
			File[] files = parent.listFiles();
			//遍历子文件，递归思想重复判断
			for(File file:files) {
				printFileNames(file,level+1);
			}
		}
		//如果不是目录文件，则当前路径不用进入递归
		
	}
}
