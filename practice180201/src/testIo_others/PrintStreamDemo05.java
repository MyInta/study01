package testIo_others;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * PrintStream ��ӡ��-->������
 * @author ����
 *
 */
public class PrintStreamDemo05 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("test");
		PrintStream ps = System.out;
		ps.print("It's a new test");
		//������ļ�
		//�½��ļ�
		File src = new File("F:/ͼƬ/��;/JAVA���/Plane/psTest01");
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(src,true)));//true��ʾ���ۼ�
		ps.print("In this world i am the king!");
//		ps.flush();
		testIo_util.FileUtil.close(ps);
	}
}
