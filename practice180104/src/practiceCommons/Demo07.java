package practiceCommons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

/**
 * ˫��Map,Ҫ���ֵ�������ظ�,����ͨ��K��V�ҵ���Ӧ��
 * BidiMap
 * 1��DualTreeBidiMap ����
 * 2��DualHashBidiMap ����
 * @author ����
 *
 */
public class Demo07 {
	public static void main(String[] args) {
//		hashBidi();
		treeBidi();
	}
	/**
	 * ����map
	 */
	public static void treeBidi() {
		System.out.println("========�����˫��map==========");
		BidiMap<String,String> bi = new DualTreeBidiMap<>();
		bi.put("inta", "handsome");
		bi.put("lily", "charisma");
		bi.put("elaine", "pulchritude");
		//��ת K V
		MapIterator<String, String> it = bi.inverseBidiMap().mapIterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = it.getValue();
			System.out.println(key+"-->"+value);
		}
	}
	/**
	 * ����map
	 */
	public static void hashBidi() {
		System.out.println("========�����˫��map==========");
		BidiMap<String,String> bi = new DualHashBidiMap<>();
		bi.put("inta", "handsome");
		bi.put("lily", "charisma");
		bi.put("elaine", "pulchritude");
		//��ת K V
		MapIterator<String, String> it = bi.inverseBidiMap().mapIterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = it.getValue();
			System.out.println(key+"-->"+value);
		}
	}
}
