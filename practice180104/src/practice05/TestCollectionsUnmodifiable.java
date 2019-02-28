
package practice05;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试Collections的三种只读方法
 * @author 银涛
 *
 */
public class TestCollectionsUnmodifiable {
	public static void main(String[] args) {
		Map<String,String> m = new HashMap<>();
		m.put("af", "das");
		m.put("dsagb", "rgyw");
		//只读控制
		Map<String,String> m2 = Collections.unmodifiableMap(m);
//		m2.put("dgaqe", "de");	//不能操作
		System.out.println(m2.size());
		//一个元素的容器测试
		List<String> list = Collections.singletonList(new String());
//		list.add("a");	//只能包含一个元素的List
		System.out.println(list.size());
	}
	@SuppressWarnings("unchecked")
	public static Set<String> oper(Set<String> set){
		if(null==set) {
			return Collections.EMPTY_SET; //外部获取，避免NullPointerException
		}
		//操作
		return set;
		
	}
}
