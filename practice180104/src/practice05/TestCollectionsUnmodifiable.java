
package practice05;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ����Collections������ֻ������
 * @author ����
 *
 */
public class TestCollectionsUnmodifiable {
	public static void main(String[] args) {
		Map<String,String> m = new HashMap<>();
		m.put("af", "das");
		m.put("dsagb", "rgyw");
		//ֻ������
		Map<String,String> m2 = Collections.unmodifiableMap(m);
//		m2.put("dgaqe", "de");	//���ܲ���
		System.out.println(m2.size());
		//һ��Ԫ�ص���������
		List<String> list = Collections.singletonList(new String());
//		list.add("a");	//ֻ�ܰ���һ��Ԫ�ص�List
		System.out.println(list.size());
	}
	@SuppressWarnings("unchecked")
	public static Set<String> oper(Set<String> set){
		if(null==set) {
			return Collections.EMPTY_SET; //�ⲿ��ȡ������NullPointerException
		}
		//����
		return set;
		
	}
}
