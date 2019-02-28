package testIo_file;

import java.io.File;
import java.io.IOException;

/**
 * ���÷���
 * 1���ļ���
 * 	  getName()�ļ�����·����
 * 	  getPath()·����
 * 	  getAbsoluteFile	����·���»�ȡFile����
 * 	  getAbsolutePath	����·����
 * 	  getParent()		��Ŀ¼�����·���ĸ�ĸ¼������Ϊnull����ɾ�������Ľ��
 * 2���ж���Ϣ
 * 	  exists()
 * 	  canWrite()
 * 	  canRead()
 * 	  isFile()
 * 	  isDirectory()
 * 	  isAbsolute() :����ƽ̨���죬ie���̷���ͷ��������/��ͷ
 * 3������ -->�ֽ��� ���ܶ�ȡ�ļ��еĳ��ȣ�����ʾΪ0
 * 	  length()
 * 4��������ɾ��
 * 	  createNewFile() �����ڴ����ļ������ڷ���false
 * 	  delete() ɾ���ļ�
 * 	  static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp) Ĭ����ʱ�ռ�
 * 	  static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp,Ŀ¼)
 * 	  deleteOnExit() �˳������ɾ������������ʱ�ļ���ɾ��
 * @author ����
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
				System.out.println("�ļ�����ʧ��");
			}
	}
	//1���ļ���
	public static void test01() {
		File fi = new File("E:/java/test/2.jpg");
//		fi = new File("2.jpg");//���·������
		System.out.println(fi.getName());	//�ļ���
		System.out.println(fi.getParent());	//������һ��Ŀ¼���������ԣ�����Ϊnull
		System.out.println(fi.getPath());	//����Ǿ���·�������ؾ��ԣ����߷������·��
		System.out.println(fi.getAbsolutePath());//���ؾ���·��
	}
	//2���ж���Ϣ
	public static void test02() {
		String path = "F:/ͼƬ/��;/JAVA���/Plane/�ɻ�01.jpg";	//����main�����жϴ������
		File fi = new File(path);
		//�Ƿ����
		System.out.println("�ļ��Ƿ����"+fi.exists());
		//�Ƿ�ɶ�
		System.out.println("�ļ��Ƿ����"+fi.canRead());
		System.out.println("===================");
		//isFile()
		//isDirectory()
		if(fi.isFile()) {
			System.out.println("�ǡ��ļ���");
		}else if(fi.isDirectory()){
			System.out.println("�ǡ��ļ��С�");
		}else {
			System.out.println("�ļ�������");
		}
		//isAbsolute() :����ƽ̨���죬ie���̷���ͷ��������/��ͷ
		System.out.println("�Ƿ�Ϊ����·��:"+fi.isAbsolute());
		//�����ֽ���
		System.out.println("���ȵ��ֽ���Ϊ��"+fi.length());
	}
	public static void test03() throws IOException, InterruptedException {
		//createNewFile() �����ڴ����ļ�
//		String path = "F:/ͼƬ/��;/JAVA���/Plane/con";//������ʧ��
		String path = "F:/ͼƬ/��;/JAVA���/Plane/�ɻ�08.jpg";
		File fi = new File(path);
		if(!fi.exists()) {
			//�������ļ���������Ҫ�жϲ����ɹ������ʱ��ʧ�ܣ����ļ���Ϊ�ؼ���con
			boolean flag = fi.createNewFile();
			System.out.println(flag?"�������ļ��ɹ�":"�������ļ�ʧ��");
		}
		
		//delete() ɾ���ļ�
		boolean flag = fi.delete();
		System.out.println(flag?"ɾ���ļ��ɹ�":"ɾ���ļ�ʧ��");
		//static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp) Ĭ����ʱ�ռ�
		//static createTempFile(ǰ׺3���ֽڳ�����׺Ĭ��.temp,Ŀ¼)
		File temp = File.createTempFile("test", ".temp", new File("F:/ͼƬ/��;/JAVA���/Plane/"));
		Thread.sleep(3000);
		temp.deleteOnExit();//�˳���ɾ��
	}
}
