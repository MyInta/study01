package practiceGuava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * HashMap ��Ψһ��ֵ�����ظ�
 * BiMap :˫��Map��Bidirectional Map��������ֵ���������ظ�(Unique-valued map)
 * @author ����
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		BiMap<String,String> bimap = HashBiMap.create();
		bimap.put("inta","handsome");
		bimap.put("lily","pulchritude");
		String str = bimap.inverse().get("handsome");
		System.out.println(str);
		//��ת�ķ�תΪ����
		System.out.println("pulchritude"==bimap.inverse().inverse().get("lily"));
	}
}
