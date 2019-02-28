package practice04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���Զ����ͼ��Ϻ��ð�ݷ�
 * @author ����
 *
 */
public class TestUtils001 {
	public static void main(String[] args) {
		System.out.println("==============�Ի�����ð������==============");
		int[] arr = {8,1,2,3,4};
		Utils.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("==============���ַ�����ð������============");
		String[] arr2 = {"adh","def","ad","adhcd","auike"};
		Utils.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("==============���������ݽ�������============");
		List<String> list = new ArrayList<String>();
		list.add("ac");
		list.add("gdh");
		list.add("acdf");
		list.add("acd");
		list.add("acdfrg");
		list.add("ggggg");
		Utils.sort(list);
		System.out.println(list);
		
		System.out.println("==============ʹ��Comparator��������=======");
		arr2 = new String[]{"adh","def","ad","adhcd","auike"};
		Utils.sort(arr2, new StringComp());
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("==============��List+�Ƚ�������============");
		list = new ArrayList<String>();
		list.add("ac");
		list.add("gdh");
		list.add("acdf");
		list.add("acd");
		list.add("acdfrg");
		list.add("ggggg");
		Utils.sort(list,new StringComp());
		System.out.println(list);
		
	}
}
