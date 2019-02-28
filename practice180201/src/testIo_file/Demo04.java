package testIo_file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 5������Ŀ¼
 * mkdir() ����Ŀ¼������ȷ����Ŀ¼�ڣ������򴴽�ʧ�ܡ�
 * mkdirs()����Ŀ¼�������Ŀ¼���ڣ���ȫ��������
 * list() �ļ���Ŀ¼���ַ�����ʽ
 * listFiles()
 * static listRoots() ��·��
 * @author ����
 *
 */
public class Demo04 {
	public static void main(String[] args) {
//		test01();
		String path = "F:/ͼƬ/��;/JAVA���/Plane";
		File src = new File(path);
		if(src.isDirectory()) {
			System.out.println("======��Ŀ¼|���ļ���======");
			String[] subName = src.list();
			for(String str:subName) {
				System.out.println(str);
			}
		}
		System.out.println("======��Ŀ¼|�ļ�File����======");
		File[] subFile = src.listFiles();
		for(File temp:subFile) {
			System.out.println(temp.getAbsolutePath());
		}
		System.out.println("======���ļ�.java.����======");
		//�������ģʽ ����ļ���������
		subFile = src.listFiles(new	FilenameFilter() {
			/**
			 * arg0����src arg1Ϊ��Ŀ¼�µ����ļ���(������չ��)
			 */
			public boolean accept(File arg0, String arg1) {
				//���ǵ��п�������չ��Ϊpng���ļ��У�Ҫ�ų�������&&
				return arg1.endsWith(".png")&&new File(arg0,arg1).isFile();
			}
		});
		for(File temp:subFile) {
			System.out.println(temp.getAbsolutePath());
		}
	}
	public static void test01() {
		String path = "F:/ͼƬ/��;/JAVA���/newPlane7654321/�ɻ�01.jpg";
		File fi = new File(path);
		fi.mkdir();	
//		fi.mkdirs();
	}
}
