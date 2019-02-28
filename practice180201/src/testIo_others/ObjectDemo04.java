package testIo_others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
/**
 * 不是所有对象都可以序列化 java.io.NotSerializableException
 * 不是所有属性都需要序列化 transient-->会发现transient的元素为空了
 * @author 银涛
 *
 */
public class ObjectDemo04 {
	public static void main(String[] args) throws ClassNotFoundException {
//		seri("F:/图片/用途/JAVA相关/Plane/seri.txt");
		try {
			seri("F:/图片/用途/JAVA相关/Plane/seri.txt");
			read("F:/图片/用途/JAVA相关/Plane/seri.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 反序列化
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void read(String srcPath)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		File src = new File(srcPath);
		ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
			);
		Object obj = ois.readObject();
		if(obj instanceof Employee) {
			Employee emp = (Employee)obj;
			//Employee中name属性如果设置为transient则在序列化的时候不呈现值
			System.out.println(emp.getName()+"-->"+emp.getSalary());
		}
		
		//数组也可以序列化
		obj = ois.readObject();	//创建新对象
		int[] arr = (int[])obj;
		System.out.println(Arrays.toString(arr));
		ois.close();
	}
	/**
	 * 序列化
	 * @param destPath
	 * @throws IOException
	 */
	public static void seri(String destPath) throws IOException {
		Employee emp= new Employee("elaine",10000);
		int[] arr = {1,2,3,4,5,678};
		//创建源
		File dest = new File(destPath);
		//选择流
		ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		oos.writeObject(emp);
		oos.writeObject(arr);
		oos.close();
	}
}
