package practiceGuava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * HashMap 键唯一，值可以重复
 * BiMap :双向Map（Bidirectional Map），键与值都不可以重复(Unique-valued map)
 * @author 银涛
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		BiMap<String,String> bimap = HashBiMap.create();
		bimap.put("inta","handsome");
		bimap.put("lily","pulchritude");
		String str = bimap.inverse().get("handsome");
		System.out.println(str);
		//反转的反转为自身
		System.out.println("pulchritude"==bimap.inverse().inverse().get("lily"));
	}
}
