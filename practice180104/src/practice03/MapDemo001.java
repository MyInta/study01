package practice03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map分拣存储的 1：N
 * 统计单词出现的次数
 * 
 * 思路
 * 1、分割字符串
 * 2、分拣存储
 * 3、按要求查看 单词出现的次数
 * @author 银涛
 *
 */
public class MapDemo001 {
	public static void main(String[] args) {
		//分割字符串
		String[] arr = "this is a cat and that is a mice and where is the food ?".split(" ");
		//分拣存储
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String key:arr) {
//			System.out.println(str);
			if(map.get(key)==null) {//如果map中不存在key对应的value值
				map.put(key, 1);
			}else {
				map.put(key, map.get(key)+1);//否则key的value加一
			}
		}
		//按要求查看单词出现的次数
		Set<String> set = map.keySet();
		//获取对象
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key+"-->"+value);
		}
		//不用接口，常规取出
		System.out.println("####");
		for(String e:set) {
			System.out.println(e+"-->"+map.get(e));
		}
		
	}
}
