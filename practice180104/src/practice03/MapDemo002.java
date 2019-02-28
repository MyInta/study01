package practice03;

import java.util.HashMap;
import java.util.Map;

/**
 * Map分拣存储的 1：N
 * 统计单词出现的次数
 * 
 * 思路
 * 1、分割字符串
 * 2、分拣存储
 * 3、按要求查看 单词出现的次数
 * 4、加入面向对象
 * @author 银涛
 *
 */
public class MapDemo002 {
	public static void main(String[] args) {
		//1、分割字符串
		String[] arr = "this is a cat and that is a mice and where is the food ?".split(" ");
		//2、分拣存储
		Map<String,Letter> map = new HashMap<String,Letter>();
		for(String key:arr) {
			//第一次查看是否存在letter
			if(map.get(key)==null) {
				map.put(key, new Letter(key));	//准备好袋子
			}
			//获取袋子
			Letter value = map.get(key);
			value.setCount(value.getCount()+1);	//装东西
		}
		//3、按要求查看单词出现的次数
		for(String e :map.keySet()) {
			Letter value = map.get(e);
			System.out.println(e+"-->"+value.getCount());
		}
		
	}
}
