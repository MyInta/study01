package practice03;
/**
 * û�з��͵���洢���ݣ�����鷳
 * @author ����
 *
 */
public class MyStuApp {
	public static void main(String[] args) {
		MyStudent stu = new MyStudent(80);
		//���ܻ���
		Object javase = stu.getJavase();
		//����ת���쳣
		if(javase instanceof Integer) {
			Integer javaScore = (Integer) javase;
			System.out.println(javaScore);
		}
	}
}
