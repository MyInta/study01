package practice03;
/**
 * ���Է��͸���
 * @author ����
 *����Ϊ������������չ����������
 *
 *������д�����游�����
 *������ʹ�ø�������԰��������
 *����ʹ���Լ�������԰��������
 */
public abstract class Father<T1,T2> {
	T1 age;
	public abstract void test(T2 name);
}

//����	-->��������
//1����ȫ������
class C1<T2,T1,A,B> extends Father<T1,T2>{
	@Override
	public void test(T2 name) {
//		this.age	-->T1
	}
}
//2�������ֱ���
class C2<T1,A,B> extends Father<T1,Integer>{
	@Override
	public void test(Integer name) {
//		this.age 	-->T1
	}
	//������Զ��巽��
	public void test2(A a) {
	}
}
//������	-->����ʵ��
//1������������
class C3<A> extends Father<String,Integer>{
	@Override
	public void test(Integer name) {
//		this.age	-->String
	}
}
//2����û�����͡�����Object��
class C4 extends Father{
	@Override
	public void test(Object name) {
//		this.age	-->Object
	}
}