package practiceCommons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

/**
 * 双向Map,要求键值都不能重复,可以通过K或V找到对应面
 * BidiMap
 * 1、DualTreeBidiMap 有序
 * 2、DualHashBidiMap 无序
 * @author 银涛
 *
 */
public class Demo07 {
	public static void main(String[] args) {
//		hashBidi();
		treeBidi();
	}
	/**
	 * 有序map
	 */
	public static void treeBidi() {
		System.out.println("========有序的双向map==========");
		BidiMap<String,String> bi = new DualTreeBidiMap<>();
		bi.put("inta", "handsome");
		bi.put("lily", "charisma");
		bi.put("elaine", "pulchritude");
		//翻转 K V
		MapIterator<String, String> it = bi.inverseBidiMap().mapIterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = it.getValue();
			System.out.println(key+"-->"+value);
		}
	}
	/**
	 * 无序map
	 */
	public static void hashBidi() {
		System.out.println("========无序的双向map==========");
		BidiMap<String,String> bi = new DualHashBidiMap<>();
		bi.put("inta", "handsome");
		bi.put("lily", "charisma");
		bi.put("elaine", "pulchritude");
		//翻转 K V
		MapIterator<String, String> it = bi.inverseBidiMap().mapIterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = it.getValue();
			System.out.println(key+"-->"+value);
		}
	}
}
