package practice01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * �����ĵ��쳣������
 * @author ����
 *
 */
public class TestReadFile {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("D:/music/a.txt");
			char c = (char)reader.read();
			char c2 = (char)reader.read();
			System.out.println(""+c+c2);
		}catch(FileNotFoundException e) {//�쳣���ͳ���˳���������ٸ���
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader!=null) {
					reader.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
