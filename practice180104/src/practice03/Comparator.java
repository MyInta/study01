package practice03;
/**
 * 泛型接口与泛型类同理
 * 
 * @author 银涛
 *
 */
public interface Comparator<T> {
	//全局常量
	public static final int MAX_VALUE=100;
	//公共方法
	public abstract void test(T t);
}
//实现
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
