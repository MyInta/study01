package testIo_charIo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * �Ա�copyFileDemoȱ���½��ļ��������У�
 * ԭ����FileReader�Ѿ�ʵ����str���ļ���ת��
 * @author ����
 *
 */
public class Review01 {
	public static void main(String[] args) {
		String src = "F:/ͼƬ/��;/JAVA���/Plane/test01.txt";
		String dest = "F:/ͼƬ/��;/JAVA���/Plane/test02.txt";
		Reader rd = null;
		Writer wt = null;
		try {
			rd = new FileReader(src);
			wt = new FileWriter(dest);
			char[] flush = new char[1024];
			int len =0;
			while(-1!=(len=rd.read(flush))) {
				wt.write(flush,0,len);
			}
			wt.flush();
		} catch (IOException e) {
			System.out.println("�Ҳ����ļ�");
			e.printStackTrace();
		}finally {
			testIo_util.FileUtil.close(wt,rd);
		}
		
	}
}
