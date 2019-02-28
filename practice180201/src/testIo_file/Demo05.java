package testIo_file;

import java.io.File;
import java.util.Arrays;

/**
 * ������ＶĿ¼|�ļ����ƣ�����·����
 * 1��ListFiles()
 * 2���ݹ�
 * 
 * static listRoots() ��·��
 * @author ����
 *
 */
public class Demo05 {

	public static void main(String[] args) {
		String path = "F:/ͼƬ/��;/JAVA���/Plane";
		File src = new File(path);
		printName(src);
		System.out.println("=========��Ŀ¼==========");
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
	}
	public static void printName(File arg0) {
		//���ų����벻�������
		if (arg0 == null || !arg0.exists()) {
			return;
		}
		System.out.println(arg0.getAbsolutePath());
		//�ж�arg0���滹�������ļ�������ݹ鷨ȫ������
		if(arg0.isDirectory()) {
			for(File temp:arg0.listFiles()) {
				printName(temp);	//�ݹ鷨�������ļ�����
			}
		}
	}
}
