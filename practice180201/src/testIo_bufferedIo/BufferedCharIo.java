package testIo_bufferedIo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * �ַ�������+�������������ܷ�����̬����Ҫ���µ����͵ı���-->��ԭ����Reader rd��Writer wt���ĵ���
 * @author ����
 *
 */
public class BufferedCharIo {
	public static void main(String[] args) {
		String strScr = "F:/ͼƬ/��;/JAVA���/Plane/test01.txt";
		String strDest = "F:/ͼƬ/��;/JAVA���/Plane/test02.txt";
		File src = new File(strScr);
		File dest = new File(strDest);
		BufferedReader rd = null;
		BufferedWriter wt = null;
		try {
			// ѡ����
			rd = new BufferedReader(new FileReader(src));
			wt = new BufferedWriter(new FileWriter(dest));
			/*char[] flush = new char[1024];
			int len = 0;
			while(-1!=(len=rd.read(flush))) {
				wt.write(flush, 0, len);
			}*/
			//�����ķ���
			String line = null;
			while(null!=(line=rd.readLine())) {
				wt.write(line);	//�������
				wt.newLine(); 	//����-->�൱�� wt.append("\r\n");
			}
			wt.flush(); 	//ǿ��ת��
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ������ڣ�Ϊ��");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("�ļ���ȡʧ��");
		}finally {
			if(null!=wt) {
				try {
					wt.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("������ر�Ŀ���ļ�ʧ��");
				}
			}
			if(null!=rd) {
				try {
					rd.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("������ر�ԭ�ļ���Դʧ��");
				}
			}
		}
	}
}
