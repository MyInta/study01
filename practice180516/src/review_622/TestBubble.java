package review_622;

import java.util.Arrays;

/**
 * ð������ĸ�ϰ������ʵ��
 * @author ����
 *
 */
public class TestBubble {
	public static void main(String[] args) {
		int[] obj ={7,8,5,2,4,2,3,5,15,12,10,6,19,3,1,20,21,22};
		test04(obj);
		System.out.println(Arrays.toString(obj));
	}

	/**
	 * ��򵥵�һ��ʵ��
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
	 * ���������棬ʹ��boolean �жϽ����Ƿ���ڣ��޳�����Ľ�������
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
	 * �߼����ð�����򣬼�¼���һ�ν���λ��
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
	 * ���߼�ð�������㷨��ʹ����˫������
	 * @param arr
	 * @return
	 */
	public static int[] test04(int[] arr) {
		//�����ȡ�ĳ�ʼ��
		int left=0;
		//�����ȡ�����յ�
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
