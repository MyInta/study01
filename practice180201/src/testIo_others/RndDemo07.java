package testIo_others;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �ļ��ָ� ˼·
 * 1���ָ���� size
 * 2��ÿһ��Ĵ�С blockSize
 * 	  ���һ��Ĵ�С���ܵ��ļ���С-��n-1��blockSize
 * @author ����
 *
 */
public class RndDemo07 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(
				new File("F:/ͼƬ/��;/JAVA���/Plane/test01.txt"
						)
				,"r");//rΪ������ֻ��
		raf.seek(20);//���ļ����ݵڼ�����ʼ
		//���建��
		byte[] flush = new byte[30];
		int len = 0;
		//û�㶮���������߼����⣬break?�Լ��и�����Ĵ�С80��
		//����ֻ��ʾ80�ֽڷ�Χ�ڵ���Ϣ������ʾ����
		while(-1!=(len=raf.read(flush))) {
			if(len>80) {
				System.out.println(new String(flush,0,80));
				break;
			}else {
				System.out.println(new String(flush,0,len));
			}
		}
		testIo_util.FileUtil.close(raf);
	}
}
