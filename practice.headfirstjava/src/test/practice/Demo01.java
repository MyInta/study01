package test.practice;
/**
 * 测试自定义的FileSystemClassLoader
 * @author 银涛
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader = new FileSystemClassLoader("F:/视频教学/JAVA教学/Practice/Compiler"); 
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c);
	}
}
