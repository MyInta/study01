package test.practice;
/**
 * �����Զ����FileSystemClassLoader
 * @author ����
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader = new FileSystemClassLoader("F:/��Ƶ��ѧ/JAVA��ѧ/Practice/Compiler"); 
		Class<?> c = loader.loadClass("HelloWorld");
		System.out.println(c);
	}
}
