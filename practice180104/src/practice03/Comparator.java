package practice03;
/**
 * ���ͽӿ��뷺����ͬ��
 * 
 * @author ����
 *
 */
public interface Comparator<T> {
	//ȫ�ֳ���
	public static final int MAX_VALUE=100;
	//��������
	public abstract void test(T t);
}
//ʵ��
class InterC1<A> implements Comparator{

	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub
		
	}
}
class InterC2<T,B> implements Comparator<T>{

	@Override
	public void test(T t) {
		// TODO Auto-generated method stub
		
	}
}
class InterC3<A> implements Comparator<Integer>{

	@Override
	public void test(Integer t) {
		// TODO Auto-generated method stub
		
	}
}
