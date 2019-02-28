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
 * new Transformer<����>() +transform������д
 * 
 * @author ����
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		System.out.println("========�Զ���=======");
		//�Զ����б�ʽ
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
		//ת��
		Transformer<Demo02_Employee,Demo02_Level> transLow = new Transformer<Demo02_Employee,Demo02_Level>() {
			@Override
			public Demo02_Level transform(Demo02_Employee input) {
				return new Demo02_Level(input.getName(),"������");
			}
		};
		Transformer<Demo02_Employee,Demo02_Level> transHigh = new Transformer<Demo02_Employee,Demo02_Level>() {
			@Override
			public Demo02_Level transform(Demo02_Employee input) {
				return new Demo02_Level(input.getName(),"������");
			}
		};
		Transformer[] trans = {transLow,transHigh};
		//���߹��� 
		Transformer switchTrans = new SwitchTransformer(pres, trans, null);
		//����
		List<Demo02_Employee> list = new ArrayList<Demo02_Employee>();
		list.add(new Demo02_Employee("inta",20000));
		list.add(new Demo02_Employee("lily",500));
		Collection<Demo02_Level> levelList =CollectionUtils.collect(list, switchTrans);
		//��������
		Iterator<Demo02_Level> it = levelList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * ��������ת��
	 */
	public static void inner() {
		System.out.println("========��������ת�����ַ���=======");
		System.out.println("��������ת����ʱ�䳤����ת����ָ����ʽ���ַ���");
		Transformer<Long,String> trans = new Transformer<Long,String>() {
			@Override
			public String transform(Long input) {
				return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(input);
			}
		};
		//����
		List<Long> list = new ArrayList<Long>();
		list.add(1000000000L);
		list.add(35414451L);
		//������
		Collection<String> col = CollectionUtils.collect(list, trans);
		//�����鿴���
		for(String temp:col) {
			System.out.println(temp);
		}
	}
}
