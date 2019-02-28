package practice04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试多类型集合后的冒泡法
 * @author 银涛
 *
 */
public class TestUtils001 {
	public static void main(String[] args) {
		System.out.println("==============对基本类冒泡排序==============");
		int[] arr = {8,1,2,3,4};
		Utils.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("==============对字符串类冒泡排序============");
		String[] arr2 = {"adh","def","ad","adhcd","auike"};
		Utils.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("==============对容器内容进行排序============");
		List<String> list = new ArrayList<String>();
		list.add("ac");
		list.add("gdh");
		list.add("acdf");
		list.add("acd");
		list.add("acdfrg");
		list.add("ggggg");
		Utils.sort(list);
		System.out.println(list);
		
		System.out.println("==============使用Comparator排序数组=======");
		arr2 = new String[]{"adh","def","ad","adhcd","auike"};
		Utils.sort(arr2, new StringComp());
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("==============对List+比较器排序============");
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
