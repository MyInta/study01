package practice04;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author 银涛
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {9,1,2,4,3,5};
		sortSlow(arr);
		
		System.out.println("####################");
		arr = new int[] {9,1,2,4,3,5};
		sortFast(arr);
	}
	public static void sortSlow(int[] arr) {
		int len = arr.length;
		for(int i=0;i<len-1;i++) {
			System.out.println("第"+(i+1)+"趟");
			for(int j=0;j<len-i-1;j++) {
				System.out.print("第"+(j+1)+"次");
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				System.out.println(Arrays.toString(arr));
			}
//			System.out.println('\n'+"此趟最终为："+Arrays.toString(arr));
		}
	}
	public static void sortFast(int[] arr) {
		int len = arr.length;
		for(int i=0;i<len-1;i++) {
			boolean sorted = true;
			System.out.println("第"+(i+1)+"趟");
			for(int j=0;j<len-i-1;j++) {
				System.out.print("第"+(j+1)+"次");
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
				System.out.println(Arrays.toString(arr));
			}
			if(sorted)break;
//			System.out.println('\n'+"此趟最终为："+Arrays.toString(arr));
		}
	}
}
