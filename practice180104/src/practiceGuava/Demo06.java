package practiceGuava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 分析查看教师教授课程
 * Multimap :key-value key可以重复,即一个key对应多个value
 * 虽然Mulimap解决了一个key对应多个V的问题，但仍没解决多个K对应多个V的问题（容易产生值被覆盖的现象）
 * @author 银涛
 *
 */
public class Demo06 {
	public static void main(String[] args) {
		Map<String,String> cours = new HashMap<>();
//		cours.put("化学", "牛琦");//虽然Mulimap解决了一个key对应多个V的问题，但仍没解决多个K对应多个V的问题
		cours.put("化学", "张楚馨");
		cours.put("游戏", "张楚馨");
		cours.put("旅游", "张楚馨");
		cours.put("地理", "牛琦");
		cours.put("NBA", "牛琦");
		cours.put("实践", "陈文");
		
		//Multimap
		Multimap<String,String> teachers = ArrayListMultimap.create();
		
		//迭代器
		Iterator<Map.Entry<String,String>> it = cours.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String,String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			//教师-->课程（由Multimap的特性决定了其key的可重复）
			teachers.put(value, key);//不用担心后面的V覆盖掉前面的V
		}
		Set<String> set = teachers.keySet();
		for(String str:set) {
			Collection<String> col = teachers.get(str);
			System.out.println(str+"-->"+/*teachers.get(str)*/col);
		}
		
	}
}
