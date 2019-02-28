package testIo_file;

import java.io.File;

/**
 * ���·�������·������File����
 * �����ַ��	E:/java/test/2.jpg
 * 1�����·��
 * 	  File(String parent,String name) -->new File("E:/java/test","2.jpg");
 * 	  File(File parent,String name)	  -->new File(new File("E:/java/test"),"2.jpg");
 * 2������·��
 * 	  File(String name);
 * @author ����
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String parentPath = "E:/java/test";
		String name = "2.jpg";
		//���·��
		File fi = new File(parentPath,name);
		fi = new File(new File(parentPath),name);//������һ�����Խ��һ��
		//����·��
		fi = new File("E:/java/test/2.jpg");
		System.out.println(fi.getName());	//�ļ���
		System.out.println(fi.getParent());	//������һ��Ŀ¼
		System.out.println(fi.getPath());	//����Ǿ���·�������ؾ��ԣ����߷������·��
		System.out.println("======================");
		//û���̷���user.dir����
		fi = new File("test.txt");
		System.out.println(fi.getName());	//�ļ���
		System.out.println(fi.getParent());	//������һ��Ŀ¼
		System.out.println(fi.getPath());	//����Ǿ���·�������ؾ��ԣ����߷������·��
		System.out.println(fi.getAbsolutePath());//��ȡ����·���������ߵ�user.dir����
	}
}
