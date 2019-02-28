package practice03;

import java.util.HashMap;
import java.util.Map;

/**
 * Map�ּ�洢�� 1��N
 * ͳ�Ƶ��ʳ��ֵĴ���
 * 
 * ˼·
 * 1���ָ��ַ���
 * 2���ּ�洢
 * 3����Ҫ��鿴 ���ʳ��ֵĴ���
 * 4�������������
 * @author ����
 *
 */
public class MapDemo002 {
	public static void main(String[] args) {
		//1���ָ��ַ���
		String[] arr = "this is a cat and that is a mice and where is the food ?".split(" ");
		//2���ּ�洢
		Map<String,Letter> map = new HashMap<String,Letter>();
		for(String key:arr) {
			//��һ�β鿴�Ƿ����letter
			if(map.get(key)==null) {
				map.put(key, new Letter(key));	//׼���ô���
			}
			//��ȡ����
			Letter value = map.get(key);
			value.setCount(value.getCount()+1);	//װ����
		}
		//3����Ҫ��鿴���ʳ��ֵĴ���
		for(String e :map.keySet()) {
			Letter value = map.get(e);
			System.out.println(e+"-->"+value.getCount());
		}
		
	}
}
