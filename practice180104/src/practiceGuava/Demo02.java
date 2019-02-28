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
 * ����ʽ���
 * 1��Predicate
 * 2��Function
 * 
 * ����:Collections2.filter() ������
 * Collections2.transform ת��
 * Functions.compose();���ʽ�������
 * @author ����
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//���ʽ�������
		//ȷ�������г��Ȳ������壬Ȼ��ȫ�����д
		List<String> list = Lists.newArrayList("inta","father","happiness");
		//ȷ�������е��ַ����������������
		Function<String,String> f1 = new Function<String,String>(){
			@Override
			public String apply(String input) {
				return input.length()>5?input.substring(0,5):input;
			}
		};
		//ת�ɴ�д
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
	 * ������
	 */
	public static void test01() {
		//����List ��̬��ʼ��
		List<String> list =Lists.newArrayList("moon","son","dad","inta","level");
		//�ҳ����� palindrome backwords mirror words
		//�����ڲ�����������ڲ��ࡢͬʱ���������
		Collection<String> palindrome = Collections2.filter(list, new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				//ҵ���߼�
				return new StringBuilder(input).reverse().toString().equals(input);
			}
			
		});
		for(String temp:palindrome) {
			System.out.println(temp);
		}
	}
	/**
	 * ת��
	 */
	public static void test02() {
		//����ת��
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
