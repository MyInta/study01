package practiceGuava;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 函数式编程
 * 1、Predicate
 * 2、Function
 * 
 * 工具:Collections2.filter() 过滤器
 * Collections2.transform 转换
 * Functions.compose();组合式函数编程
 * @author 银涛
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//组合式函数编程
		//确保容器中长度不超过五，然后全都变大写
		List<String> list = Lists.newArrayList("inta","father","happiness");
		//确保容器中的字符串不超过五个长度
		Function<String,String> f1 = new Function<String,String>(){
			@Override
			public String apply(String input) {
				return input.length()>5?input.substring(0,5):input;
			}
		};
		//转成大写
		Function<String,String> f2 = new Function<String,String>(){
			@Override
			public String apply(String input) {
				return input.toUpperCase();
			}
		};
		//String = f2(f1(String))
		Function<String,String> f = Functions.compose(f1, f2);
		Collection<String> resultCol = Collections2.transform(list, f);
		for(String temp:resultCol) {
			System.out.println(temp);
		}
	}
	/**
	 * 过滤器
	 */
	public static void test01() {
		//创建List 静态初始化
		List<String> list =Lists.newArrayList("moon","son","dad","inta","level");
		//找出回文 palindrome backwords mirror words
		//匿名内部类对象：匿名内部类、同时创建类对象
		Collection<String> palindrome = Collections2.filter(list, new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				//业务逻辑
				return new StringBuilder(input).reverse().toString().equals(input);
			}
			
		});
		for(String temp:palindrome) {
			System.out.println(temp);
		}
	}
	/**
	 * 转换
	 */
	public static void test02() {
		//类型转换
		Set<Long> timeSet = Sets.newHashSet();
		timeSet.add(121132132L);
		timeSet.add(234564644561641L);
		timeSet.add(20000000000L);
		Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long,String>(){

			@Override
			public String apply(Long input) {
				return new SimpleDateFormat("yyyy-MM-dd").format(input);
			}
			
		});
		for(String temp:timeStrCol) {
			System.out.println(temp);
		}
	}
}
