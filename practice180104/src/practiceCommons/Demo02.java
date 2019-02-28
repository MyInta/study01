package practiceCommons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;



/**
 * 
 * new Transformer<类型>() +transform方法重写
 * 
 * @author 银涛
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		System.out.println("========自定义=======");
		//自定义判别式
		Predicate<Demo02_Employee> isLow = new Predicate<Demo02_Employee>() {
			@Override
			public boolean evaluate(Demo02_Employee object) {
				return object.getSalary()<10000;
			}
		};
		Predicate<Demo02_Employee> isHigh = new Predicate<Demo02_Employee>() {
			@Override
			public boolean evaluate(Demo02_Employee input) {
				return input.getSalary()>=10000;
			}
		};
		Predicate[] pres = {isLow,isHigh};
		//转换
		Transformer<Demo02_Employee,Demo02_Level> transLow = new Transformer<Demo02_Employee,Demo02_Level>() {
			@Override
			public Demo02_Level transform(Demo02_Employee input) {
				return new Demo02_Level(input.getName(),"卖身中");
			}
		};
		Transformer<Demo02_Employee,Demo02_Level> transHigh = new Transformer<Demo02_Employee,Demo02_Level>() {
			@Override
			public Demo02_Level transform(Demo02_Employee input) {
				return new Demo02_Level(input.getName(),"养生中");
			}
		};
		Transformer[] trans = {transLow,transHigh};
		//两者关联 
		Transformer switchTrans = new SwitchTransformer(pres, trans, null);
		//容器
		List<Demo02_Employee> list = new ArrayList<Demo02_Employee>();
		list.add(new Demo02_Employee("inta",20000));
		list.add(new Demo02_Employee("lily",500));
		Collection<Demo02_Level> levelList =CollectionUtils.collect(list, switchTrans);
		//遍历容器
		Iterator<Demo02_Level> it = levelList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * 内置类型转换
	 */
	public static void inner() {
		System.out.println("========将长整型转换成字符串=======");
		System.out.println("内置类型转换，时间长整数转化成指定格式的字符串");
		Transformer<Long,String> trans = new Transformer<Long,String>() {
			@Override
			public String transform(Long input) {
				return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(input);
			}
		};
		//容器
		List<Long> list = new ArrayList<Long>();
		list.add(1000000000L);
		list.add(35414451L);
		//工具类
		Collection<String> col = CollectionUtils.collect(list, trans);
		//遍历查看结果
		for(String temp:col) {
			System.out.println(temp);
		}
	}
}
