package practiceCommons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.AllPredicate;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;


/**
 * 函数式编程之Predicate断言
 * 封装条件或判别式if else的替代
 * 1、new EqualPredicate<类型>(值)
 * 		EqualPredicate.equalPredicate(值)
 * 2、NotNullPredicate.INSTANCE
 * 3、UniquePredicate.uniquePredicate()
 * 4、自定义判断	
 *   new Predicate<T>()+evaluate方法
 * 		PredicateUtils.allPredicate可以两个以上  andPredicate只能传两个相当于“且”
 * 											   anyPredicate其中一个为true即可相当于“或”
 * 		PredicatedXxx.predicatedXxx(容器,判断)
 * @author 银涛
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println("=========自定义判断========");
		//自定义的判别式
		Predicate<String> preSelf = new Predicate<String>() {
			@Override
			public boolean evaluate(String object) {
				return object.length()>=5&&object.length()<=20;
			}
		};
		Predicate notNull = NotNullPredicate.notNullPredicate();
		Predicate all = PredicateUtils.allPredicate(notNull,preSelf);//换括号里面的顺序影响判断顺序
		//实现了将长度和是否空的判断与容器解耦开来，需要一定工具类
		List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), all);
		//list.add("inta");//长度不够报错
		//list.add(null);	//空指针异常 
		list.add("intadd");
	}
	/**
	 * 判断唯一性
	 */
	public static void unique() {
		System.out.println("=========唯一性判断========");
		org.apache.commons.collections4.Predicate<Long> unique = UniquePredicate.uniquePredicate();
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), 
				unique);
		list.add(100L);
		list.add(200L);
//		list.add(100L);	//出现重复值，抛出异常
	}
	/**
	 * 非空判断
	 */
	public static void notNull() {
		System.out.println("=========非空判断========");
		org.apache.commons.collections4.Predicate<Object> notNull = NotNullPredicate.INSTANCE;
//		org.apache.commons.collections4.Predicate<Object> notNull = NotNullPredicate.notNullPredicate();
//		String str = "id";
		String str = null;
		System.out.println(notNull.evaluate(str));
		//添加容器
		List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), 
				notNull/*NotNullPredicate.INSTANCE*/);
		list.add(10000L);
//		list.add(null);
	}
	/**
	 * 比较相等判断
	 */
	public static void equal() {
		System.out.println("=========相等判断========");
//		EqualPredicate<String> pre = (EqualPredicate<String>) EqualPredicate.equalPredicate("inta");
		EqualPredicate<String> pre = new EqualPredicate<String>("inta");
		boolean test01 = pre.evaluate("intadd");
		System.out.println(test01);
	}
}
