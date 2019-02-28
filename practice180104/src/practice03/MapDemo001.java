package practice03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map�ּ�洢�� 1��N
 * ͳ�Ƶ��ʳ��ֵĴ���
 * 
 * ˼·
 * 1���ָ��ַ���
 * 2���ּ�洢
 * 3����Ҫ��鿴 ���ʳ��ֵĴ���
 * @author ����
 *
 */
public class MapDemo001 {
	public static void main(String[] args) {
		//�ָ��ַ���
		String[] arr = "this is a cat and that is a mice and where is the food ?".split(" ");
		//�ּ�洢
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String key:arr) {
//			System.out.println(str);
			if(map.get(key)==null) {//���map�в�����key��Ӧ��valueֵ
				map.put(key, 1);
			}else {
				map.put(key, map.get(key)+1);//����key��value��һ
			}
		}
		//��Ҫ��鿴���ʳ��ֵĴ���
		Set<String> set = map.keySet();
		//��ȡ����
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key+"-->"+value);
		}
		//���ýӿڣ�����ȡ��
		System.out.println("####");
		for(String e:set) {
			System.out.println(e+"-->"+map.get(e));
		}
		
	}
}
