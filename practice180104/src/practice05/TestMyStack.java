package practice05;
/**
 * �����Զ����ջ
 * @author ����
 *
 */
public class TestMyStack {
	public static void main(String[] args) {
		MyStack<String> nest = new MyStack<String>(3);
		nest.push("�ΰ��ΰ���");
		nest.push("�ڳ�����");
		nest.push("���ֵ�С����");
		nest.push("�ܿ�ɭ");
		System.out.println(nest.size());
		
		//����
		String item = null;
		while(null!=(item=nest.pop())) {
			System.out.println(item);
		}
	}
}
