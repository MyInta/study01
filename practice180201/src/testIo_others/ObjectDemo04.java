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
 * �������ж��󶼿������л� java.io.NotSerializableException
 * �����������Զ���Ҫ���л� transient-->�ᷢ��transient��Ԫ��Ϊ����
 * @author ����
 *
 */
public class ObjectDemo04 {
	public static void main(String[] args) throws ClassNotFoundException {
//		seri("F:/ͼƬ/��;/JAVA���/Plane/seri.txt");
		try {
			seri("F:/ͼƬ/��;/JAVA���/Plane/seri.txt");
			read("F:/ͼƬ/��;/JAVA���/Plane/seri.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �����л�
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
			//Employee��name�����������Ϊtransient�������л���ʱ�򲻳���ֵ
			System.out.println(emp.getName()+"-->"+emp.getSalary());
		}
		
		//����Ҳ�������л�
		obj = ois.readObject();	//�����¶���
		int[] arr = (int[])obj;
		System.out.println(Arrays.toString(arr));
		ois.close();
	}
	/**
	 * ���л�
	 * @param destPath
	 * @throws IOException
	 */
	public static void seri(String destPath) throws IOException {
		Employee emp= new Employee("elaine",10000);
		int[] arr = {1,2,3,4,5,678};
		//����Դ
		File dest = new File(destPath);
		//ѡ����
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
