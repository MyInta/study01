package testIo_byteIo;

import java.io.File;
import java.io.IOException;

/**
 *  �ļ��еĿ���
 *  1���ļ���ֵ CopyFile
 *  2���ļ����� mkdirs()
 *  3���ݹ�������Ｖ
 * @author ����
 *
 */
public class Demo04_CopyDir {
	public static void main(String[] args) {
		String srcStr = "F:/ͼƬ/��;/JAVA���/Plane";
		String destStr = "F:/ͼƬ/��;/JAVA���/Dir";
		copyDir(srcStr,destStr);
	}
	
	
	/**
	 * �����ļ���
	 * @param src	Դ·��
	 * @param dest	Ŀ��·��
	 */
	public static void copyDir(String srcPath,String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src,dest);
	}
	
	/**
	 * �����ļ���-->��Ŀ���ļ��п���Ŀ�ĵ��£������ڲ�ϸ�ڿ���
	 * @param src	ԴFile����
	 * @param dest	Ŀ��File����
	 */
	public static void copyDir(File src,File dest) {
		if(src.isDirectory()) {
			dest = new File(dest,src.getName());	
			//�����ǽ�src�ļ��п���destԭ��ַ����(parent,name)
		}
		copyDirDetails(src, dest);
	}
	
	/**
	 * �����ļ���ϸ��
	 * @param src Դͷ
	 * @param dest �յ�
	 */
	public static void copyDirDetails(File src,File dest) {
		//�����ļ�
		if(src.isFile()) {
			try {
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(src.isDirectory()) {
			//ȷ��Ŀ�ĵ��ļ�·������,�������򴴽�һ�����ļ�
			dest.mkdirs();
			//������������Ｖ�����õݹ������
			for(File sub:src.listFiles()) {
				copyDirDetails(sub, new File(dest,sub.getName()));
			}
		}
		
	}
}
