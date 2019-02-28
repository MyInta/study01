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
 * ����ʽ��� Closure �հ�����װ�ض���ҵ����
 * 1��Closure
 * 	  IterableUtils.forEach(����,���������)
 * 2��IfClosure
 * 	  IfClosure.ifClosure(�ж�, true����1, false����2);//���ƣ�X��Y
 * 3��WhileClosure
 * 	  WhileClosure.whileClosure(�ж�,ʵ�ֹ���, false); true-->do while
 * 4��ChainedClosure
 * 	  ChainedClosure.chainedClosure(����1,����2); ʵ�ֹ���1�����ʵ�ֹ���2����ù�������ж�ʵ������
 * @author ����
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
	 * ��ʽ����ʵ�֣����жϴ��ۣ����ж�Ҫ��Ҫ����
	 */
	public static void chainedClosure() {
		List<Demo03_Goods> goodsList = new ArrayList<>();
		goodsList.add(new Demo03_Goods("����",4000,false));
		goodsList.add(new Demo03_Goods("�ֻ�",3000,false));
		goodsList.add(new Demo03_Goods("iPad",1200,true));
		goodsList.add(new Demo03_Goods("ԭľ��",888,false));
		goodsList.add(new Demo03_Goods("kindle",558,true));
		//ÿ��ǧ����ʮ
		Closure<Demo03_Goods> subtract = new Closure<Demo03_Goods>() {
			@Override
			public void execute(Demo03_Goods goods) {
				int n = (int) (goods.getPrice()/1000);
				goods.setPrice(goods.getPrice()-20*n);
			}
		};
		//�����
		Closure<Demo03_Goods> discount = new Closure<Demo03_Goods>() {
			@Override
			public void execute(Demo03_Goods goods) {
				if(goods.isDiscount()) {
					goods.setPrice(goods.getPrice()*0.9);
				}
			}
		};
	
		//��ʽ����
		Closure<Demo03_Goods> chainedClo = ChainedClosure.chainedClosure(discount,subtract);
		//������
		IterableUtils.forEach(goodsList, chainedClo);	//����,����
		Iterator<Demo03_Goods> iterGoods = goodsList.iterator();
		while(iterGoods.hasNext()) {
			System.out.println(iterGoods.next());
		}
	}
	/**
	 *ѭ��������Ī����
	 */
	public static void whileClosure() {
		//��֤Ա�����ʶ�Ϊ10000+,��������0.2��������
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
		//�ж�
		Predicate<Demo02_Employee> pre = new Predicate<Demo02_Employee>() {
			@Override
			public boolean evaluate(Demo02_Employee emp) {
				return emp.getSalary()<10000;
			}
		};
		//ѡ�� false ��true������һ��Ϊwhile һ��Ϊdo while
		Closure<Demo02_Employee> whileClo = WhileClosure.whileClosure(pre, clo, false);
		//������
		IterableUtils.forEach(list, whileClo);
		//�¼�һ������ת��ԭʼ���ݲ�����С���㱣��λ��
		List<Demo02_Employee> list2 = new ArrayList();
		for(Demo02_Employee emp:list) {
			emp.setSalary(Math.round(emp.getSalary()*10)/10);
			list2.add(emp);
		}
		//��������
		Iterator<Demo02_Employee> iter = list2.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	/**
	 *��ѡһ
	 */
	public static void ifClosure() {
		//�Ǵ�����Ʒÿ��1000��20��������Ʒ�����
		List<Demo03_Goods> goodsList = new ArrayList<>();
		goodsList.add(new Demo03_Goods("����",4000,false));
		goodsList.add(new Demo03_Goods("�ֻ�",3000,false));
		goodsList.add(new Demo03_Goods("iPad",1200,true));
		goodsList.add(new Demo03_Goods("ԭľ��",888,false));
		goodsList.add(new Demo03_Goods("kindle",558,true));
		//ÿ��ǧ����ʮ
		Closure<Demo03_Goods> subtract = new Closure<Demo03_Goods>() {
			@Override
			public void execute(Demo03_Goods goods) {
				int n = (int) (goods.getPrice()/1000);
				goods.setPrice(goods.getPrice()-20*n);
			}
		};
		//�����
		Closure<Demo03_Goods> discount = new Closure<Demo03_Goods>() {
			@Override
			public void execute(Demo03_Goods goods) {
				goods.setPrice(goods.getPrice()*0.9);
			}
		};
		//�ж�
		Predicate<Demo03_Goods> pre = new Predicate<Demo03_Goods>() {
			@Override
			public boolean evaluate(Demo03_Goods ifDiscount) {
				return ifDiscount.isDiscount();	//�����Ƿ��ۿ�
			}
		};
		//��ѡһ
		Closure<Demo03_Goods> ifClo = IfClosure.ifClosure(pre, discount, subtract);//���ƣ�X��Y
		//������
		IterableUtils.forEach(goodsList, ifClo);	//����,����
		Iterator<Demo03_Goods> iterGoods = goodsList.iterator();
		while(iterGoods.hasNext()) {
			System.out.println(iterGoods.next());
		}
	}
	/**
	 * ��������
	 */
	public static void basic() {
		//����
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
		//������
		//CollectionUtils.forAllDo(list, clo);//�ѱ�IterableUtils.forEach()���
		//��������
		Iterator<Demo02_Employee> iter = list.iterator();
		IterableUtils.forEach(list, clo);
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
