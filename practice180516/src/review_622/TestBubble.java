package review_622;

import java.util.Arrays;

/**
 * 冒泡排序的复习，快速实现
 * @author 银涛
 *
 */
public class TestBubble {
	public static void main(String[] args) {
		int[] obj ={7,8,5,2,4,2,3,5,15,12,10,6,19,3,1,20,21,22};
		test04(obj);
		System.out.println(Arrays.toString(obj));
	}

	/**
	 * 最简单的一种实现
	 * @param arr
	 * @return
	 */
	public static int[] test01(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	/**
	 * 排序法升级版，使用boolean 判断交换是否存在，剔除多余的交换过程
	 * @param arr
	 * @return
	 */
	public static int[] test02(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			boolean flag=false;
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}
			}
			if(!flag) {
				break;
			}
		}
		return arr;
	}
	/**
	 * 高级版的冒泡排序，记录最后一次交换位置
	 * @param arr
	 * @return
	 */
	public static int[] test03(int[] arr) {
		int idx = arr.length-1;
		for(int i=0;i<arr.length-1;i++) {
			int idxTemp = idx;
			for(int j=0;j<idxTemp;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					idx = j;
				}
			}
		}
		return arr;
	}
	/**
	 * 超高级冒泡排序算法，使用了双向排序
	 * @param arr
	 * @return
	 */
	public static int[] test04(int[] arr) {
		//排序截取的初始点
		int left=0;
		//排序截取的最终点
		int right = arr.length-1;
		int idx = 0;
		while(left<right) {
			for(int j=left;j<right;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					idx=j;
				}
			}
			right = idx;
			for(int j=right;j>left;j--) {
				if(arr[j]<arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					idx=j;
				}
			}
			left = idx;
		}
		return arr;
	}
	
}
