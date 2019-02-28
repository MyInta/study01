package testIo_convert;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * ���⣿���ʵ�ֲ���Reader��Writer
 * ʵ���ַ����ĸı�-->��"utf-8"��"gbk"������Ĳ���
 * �д�ʵ��-->2018-2-7
 * @author ����
 *
 */
public class Demo03Convert {

	public static void main(String[] args) throws IOException {
		String srcStr = new String("F:/ͼƬ/��;/JAVA���/Plane/Demo06.java");
		String destStr = "F:/ͼƬ/��;/JAVA���/Plane/Demo08.java";
		File src = new File(srcStr);
		File dest = new File(destStr);
		//ָ�������ַ���
		BufferedInputStream br = new BufferedInputStream(	
						new FileInputStream(src));
		//д���ļ�
		BufferedOutputStream bw = new BufferedOutputStream(
						new FileOutputStream(dest));	
		byte[] date = new byte[1024];
		int len =0;
		while(-1!=(len=br.read(date))) {
			bw.write(date, 0, len);
		}
		bw.flush();
		testIo_util.FileUtil.close(bw,br);
	}

}
