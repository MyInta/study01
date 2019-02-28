package practiceCommons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;


/**
 * 函数式编程 Closure 闭包，封装特定的业务功能
 * 1、Closure
 * 	  IterableUtils.forEach(容器,功能类对象)
 * 2、IfClosure
 * 	  IfClosure.ifClosure(判断, true功能1, false功能2);//类似？X：Y
 * 3、WhileClosure
 * 	  WhileClosure.whileClosure(判断,实现功能, false); true-->do while
 * 4、ChainedClosure
 * 	  ChainedClosure.chainedClosure(功能1,功能2); 实现功能1后继续实现功能2，最好功能里加判断实现条件
 * @author 银涛
 *
 */
public class Demo03 {

	public static void main(String[] args) {
		//basic();
		//ifClosure();
		//whileClosure();
		chainedClosure();
	}
	/**
	 * 链式功能实现，先判断打折，再判断要不要满减
	 */
	public static void chainedClosure() {
		List<Demo03_Goods> goodsList = new ArrayList<>();
		goodsList.add(new Demo03_Goods("电脑",4000,false));
		goodsList.add(new Demo03_Goods("手机",3000,false));
		goodsList.add(new Demo03_Goods("iPad",1200,true));
		goodsList.add(new Demo03_Goods("原木桌",888,false));
		goodsList.add(new Demo03_Goods("kindle",558,true));
		//每满千减二十
		Closure<Demo03_Goods> subtract = new Closure<Demo03_Goods>() {
			@Override
			public void execute(Demo03_Goods goods) {
				int n = (int) (goods.getPrice()/1000);
				goods.setPrice(goods.getPrice()-20*n);
			}
		};
		//打九折
		Closure<Demo03_Goods> discount = new Closure<Demo03_Goods>() {
			@Override
			public void execute(Demo03_Goods goods) {
				if(goods.isDiscount()) {
					goods.setPrice(goods.getPrice()*0.9);
				}
			}
		};
	
		//链式操作
		Closure<Demo03_Goods> chainedClo = ChainedClosure.chainedClosure(discount,subtract);
		//工具类
		IterableUtils.forEach(goodsList, chainedClo);	//容器,功能
		Iterator<Demo03_Goods> iterGoods = goodsList.iterator();
		while(iterGoods.hasNext()) {
			System.out.println(iterGoods.next());
		}
	}
	/**
	 *循环功能至莫条件
	 */
	public static void whileClosure() {
		//保证员工工资都为10000+,不到则涨0.2倍，类推
		List<Demo02_Employee> list = new ArrayList<>();
		list.add(new Demo02_Employee("inta",20000));
		list.add(new Demo02_Employee("lily",500));
		list.add(new Demo02_Employee("elaine",9000));
		Closure<Demo02_Employee> clo = new Closure<>() {
			@Override
			public void execute(Demo02_Employee input) {
				input.setSalary(input.getSalary()*1.2);
			}
		};
		//判断
		Predicate<Demo02_Employee> pre = new Predicate<Demo02_Employee>() {
			@Override
			public boolean evaluate(Demo02_Employee emp) {
				return emp.getSalary()<10000;
			}
		};
		//选择 false 和true的区别，一个为while 一个为do while
		Closure<Demo02_Employee> whileClo = WhileClosure.whileClosure(pre, clo, false);
		//工具类
		IterableUtils.forEach(list, whileClo);
		//新加一个容器转移原始数据并处理小数点保留位数
		List<Demo02_Employee> list2 = new ArrayList();
		for(Demo02_Employee emp:list) {
			emp.setSalary(Math.round(emp.getSalary()*10)/10);
			list2.add(emp);
		}
		//迭代遍历
		Iterator<Demo02_Employee> iter = list2.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	/**
	 *二选一
	 */
	public static void ifClosure() {
		//非打折商品每满1000减20，打折商品打九折
		List<Demo03_Goods> goodsList = new ArrayList<>();
		goodsList.add(new Demo03_Goods("电脑",4000,false));
		goodsList.add(new Demo03_Goods("手机",3000,false));
		goodsList.add(new Demo03_Goods("iPad",1200,true));
		goodsList.add(new Demo03_Goods("原木桌",888,false));
		goodsList.add(new Demo03_Goods("kindle",558,true));
		//每满千减二十
		Closure<Demo03_Goods> subtract = new Closure<Demo03_Goods>() {
			@Override
			public void execute(Demo03_Goods goods) {
				int n = (int) (goods.getPrice()/1000);
				goods.setPrice(goods.getPrice()-20*n);
			}
		};
		//打九折
		Closure<Demo03_Goods> discount = new Closure<Demo03_Goods>() {
			@Override
			public void execute(Demo03_Goods goods) {
				goods.setPrice(goods.getPrice()*0.9);
			}
		};
		//判断
		Predicate<Demo03_Goods> pre = new Predicate<Demo03_Goods>() {
			@Override
			public boolean evaluate(Demo03_Goods ifDiscount) {
				return ifDiscount.isDiscount();	//返回是否折扣
			}
		};
		//二选一
		Closure<Demo03_Goods> ifClo = IfClosure.ifClosure(pre, discount, subtract);//类似？X：Y
		//工具类
		IterableUtils.forEach(goodsList, ifClo);	//容器,功能
		Iterator<Demo03_Goods> iterGoods = goodsList.iterator();
		while(iterGoods.hasNext()) {
			System.out.println(iterGoods.next());
		}
	}
	/**
	 * 基本操作
	 */
	public static void basic() {
		//数据
		List<Demo02_Employee> list = new ArrayList<>();
		list.add(new Demo02_Employee("inta",20000));
		list.add(new Demo02_Employee("lily",500));
		list.add(new Demo02_Employee("elaine",15000));
		Closure<Demo02_Employee> clo = new Closure<>() {
			@Override
			public void execute(Demo02_Employee input) {
				input.setSalary(input.getSalary()*1.2);
			}
		};
		//工具类
		//CollectionUtils.forAllDo(list, clo);//已被IterableUtils.forEach()替代
		//迭代遍历
		Iterator<Demo02_Employee> iter = list.iterator();
		IterableUtils.forEach(list, clo);
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
