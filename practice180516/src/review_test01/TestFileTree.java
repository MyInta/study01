package review_test01;

import java.io.File;

/**
 * ���Դ�ӡ��Ŀ��Ŀ¼�������ļ����ƣ�ƽ�Ұ��ղ㼶��ӡǰ׺-����
 * @author ����
 *
 */
public class TestFileTree {

	public static void main(String[] args) {
		
		File f = new File("F:/ͼƬ/��;");
		printFileNames(f, 0);
	}
	
	/**
	 * ��ӡ�ļ����Ƶķ���
	 * ����˼���ǵݹ�
	 * Ҫʵ�ֵݹ�ͷ�͵ݹ���
	 * @param f �����ļ���Ŀ¼
	 * @param level �ļ��㼶
	 */
	public static void printFileNames(File parent,int level) {
		
		//�����㼶����ǰ׺-����
		for(int i=0;i<level;i++) {
			System.out.print("-");
		}
		//�ȴ�ӡ�����ļ�����
		System.out.println(parent.getName());
		//�ж�������Ŀ¼���ݹ�
		if(parent.isDirectory()) {
			//�����Ŀ¼�ļ��У���Ѱ�������ļ�
			File[] files = parent.listFiles();
			//�������ļ����ݹ�˼���ظ��ж�
			for(File file:files) {
				printFileNames(file,level+1);
			}
		}
		//�������Ŀ¼�ļ�����ǰ·�����ý���ݹ�
		
	}
}
