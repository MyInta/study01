package practice03;
/**
 * �Զ��巺����
 * 1��<> -->Ϊ�˹淶�õ�����д��ĸ�������ܼ���֪��
 * 2��T Tape 	
 * 	K V Key Value 
 * 	E Element
 * 3�����Ͳ���ʹ���ھ�̬������
 * ָ�������Ͳ���Ϊ��������
 * 
 * @author ����
 *
 */
public class Student<T> {
	private T javase;
	public Student() {
	}
	public Student(T javase) {
		super();
		this.javase = javase;
	}
	public T getJavase() {
		return javase;
	}
	public void setJavase(T javase) {
		this.javase = javase;
	}
}
