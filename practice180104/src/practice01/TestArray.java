package practice01;
/**
 * ��������
 * @author ����
 *
 */
public class TestArray {
	public static void main(String[] args) {
		int [] a;
		a = new int[4];
		for(int i=0;i<a.length;i++) {
			a[i] = i*12;
		}
		//��̬��ʼ��
		int[] b = {12,11,15,10};	//����4������0~3
		HelloWorld[] h = {
							new HelloWorld("����1"),
							new HelloWorld("����1"),
							new HelloWorld("����2"),
							new HelloWorld("����3")
						};
		h[2].showName();
		HelloWorld h2 = new HelloWorld("����1");
		//������Ƚ�h2��h[0]��==��equal��Ϊfalse,�����ַ��ͬ
		System.out.println(h2.name==h[0].name);
		System.out.println(h2.equals(h[0]));
		System.out.println(h[0].toString());//������Ԫ�ش���������ǵ���
		System.out.println(h[1].toString());
		System.out.println(h[0].equals(h[1]));//����Ϊ���������õ�ַ��ͬ��
		System.out.println(b[2]);
	}
}
