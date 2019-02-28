package practiceGuava;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * 统计单词出现的次数	
 * 1、HashMap分拣存储+面向对象思维-->判断	可以查看practice03.MapDemo001&002&Letter
 * 2、Multiset 无序 可重复 .count()获取重复次数 增强了可读性、操作简单
 * 	（set无序不可重复）
 * @author 银涛
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		String str = "this is a cat and that is a mice and where is the food ?";
		//分割字符串
		String[] strArray = str.split(" ");
		//存储到Multiset
		Multiset<String> set = HashMultiset.create();
		for(String temp:strArray){
			set.add(temp);
		}
		//获取所有单词的set
		Set<String> letter = set.elementSet();	//elementSet的功能：获取独立非重复的元素集合
		for(String strLet:letter) {
			System.out.println(strLet+"-->"+set.count(strLet));
		}
		
		
		
	}
}
