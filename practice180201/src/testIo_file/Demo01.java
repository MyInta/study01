package testIo_file;

import java.io.File;


/**
 * ��������
 * 1��·���ָ���
 * 2�����Ʒָ�� \��windows�� --&-- /��Linux �ȣ�
 * @author ����
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);	//�൱�ھ��ǡ�;����
		System.out.println(File.separator); 	//�൱�ڡ�\�� 
		//·����ʾ
		String path = "F:\\ͼƬ\\��;\\JAVA���\\Plane"; //eclipse�Ѿ�ʵ���Զ�����\\����\������ת������
		path = "F:"+File.separator+"ͼƬ"+File.separator+"��;"+File.separator+
				"JAVA���"+File.separator+"Plane";		//�Ƽ��ڶ�̬������ʹ�ã���ֵ������ʹ��
		path = "F:/ͼƬ/��;/JAVA���/Plane";				//Ctrl+F�滻��\\Ϊ/
		System.out.println(path);
	}
}
