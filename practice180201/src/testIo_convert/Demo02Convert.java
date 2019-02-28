package testIo_convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * ת�������ֽ�תΪ�ַ�
 * 1������� 	OutputStreamWriter	����
 * 2��������	InputStreamReader	����
 * @author ����
 *
 */
public class Demo02Convert {

	public static void main(String[] args) throws IOException {
		File src = new File("F:/ͼƬ/��;/JAVA���/Plane/Demo06.java");
		File dest = new File("F:/ͼƬ/��;/JAVA���/Plane/Demo07.java");
		//ָ�������ַ���
		BufferedReader br = new BufferedReader(				//������
				new InputStreamReader(							//ת���� ������-->�ַ���
						new FileInputStream(src), "utf-8"));	//�ڵ���
		//д���ļ�
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(		
						new FileOutputStream(dest),"utf-8"));	//���ݽ����ַ���,ѡ������ַ���
		String line = null;
		while(null!=(line = br.readLine())) {
			bw.write(line);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
