package practice03;
/**
 * 测试泛型父类
 * @author 银涛
 *子类为富二代，可扩展，但不能少
 *
 *子类重写方法随父类而定
 *子类中使用父类的属性按父类而定
 *子类使用自己打的属性按子类而定
 */
public abstract class Father<T1,T2> {
	T1 age;
	public abstract void test(T2 name);
}

//保留	-->泛型子类
//1）、全部保留
class C1<T2,T1,A,B> extends Father<T1,T2>{
	@Override
	public void test(T2 name) {
//		this.age	-->T1
	}
}
//2）、部分保留
class C2<T1,A,B> extends Father<T1,Integer>{
	@Override
	public void test(Integer name) {
//		this.age 	-->T1
	}
	//子类可自定义方法
	public void test2(A a) {
	}
}
//不保留	-->按需实现
//1）、具体类型
class C3<A> extends Father<String,Integer>{
	@Override
	public void test(Integer name) {
//		this.age	-->String
	}
}
//2）、没有类型、擦除Object类
class C4 extends Father{
	@Override
	public void test(Object name) {
//		this.age	-->Object
	}
}