package practiceGuava;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * ͳ�Ƶ��ʳ��ֵĴ���	
 * 1��HashMap�ּ�洢+�������˼ά-->�ж�	���Բ鿴practice03.MapDemo001&002&Letter
 * 2��Multiset ���� ���ظ� .count()��ȡ�ظ����� ��ǿ�˿ɶ��ԡ�������
 * 	��set���򲻿��ظ���
 * @author ����
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		String str = "this is a cat and that is a mice and where is the food ?";
		//�ָ��ַ���
		String[] strArray = str.split(" ");
		//�洢��Multiset
		Multiset<String> set = HashMultiset.create();
		for(String temp:strArray){
			set.add(temp);
		}
		//��ȡ���е��ʵ�set
		Set<String> letter = set.elementSet();	//elementSet�Ĺ��ܣ���ȡ�������ظ���Ԫ�ؼ���
		for(String strLet:letter) {
			System.out.println(strLet+"-->"+set.count(strLet));
		}
		
		
		
	}
}
