package practice04;

import java.util.Comparator;
import java.util.List;



/**
 * ��������ð�ݷ���collection.sort���򷽷�����
 * @author ����
 *
 */
	public class Utils {
		/**
		 * List����
		 * ʹ�ñȽ���
		 */
		@SuppressWarnings("unchecked")
		public static<T> void sort(List<T> list,Comparator<T> com){
			//��һ����ת������
			Object[] arr = list.toArray();
			sort(arr,com);	//����������
			//�ڶ������ı������ж�Ӧ�����飨���ź�˳�����������װ���������
			for(int i=0;i<arr.length;i++) {
				list.set(i, (T) arr[i]);	//ǿתΪ����
			}
		}
		/**
		 * ���������(���ð������,���ڲ��õ��Ǽ򵥵�ģʽ�����Ż���˫������ð��)��
		 * ʵ��comparator�ӿ�
		 */
		@SuppressWarnings("unchecked")
		public static <T>void sort(Object[] arr,Comparator<T> com) {
			/*int len = arr.length;
			for(int i=0;i<len-1;i++) {
				boolean sorted = true;
				for(int j=0;j<len-i-1;j++) {
					if(com.compare((T)arr[j], (T)arr[j+1])>0) {
						Object temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						sorted = false;
					}
				}
				if(sorted)break;
			}*/
			//ʹ�ø߼��汾������
			int left,right,index;
			left = 0;
			right = arr.length-1;
			index = left;
			while(left<right) {
				for(int i=left;i<right;i++) {
					if(com.compare((T)arr[i], (T)arr[i+1])>0) {
						Object temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
						index = i;
					}
					//��ʱ�Ѿ���������Ҳ���Կ�����Ҫ������Ԫ��indexֵ
				}
				//����С������Χ���ұ�����
				right =index; 
				for(int i=right;i>left;i--) {
					if(com.compare((T)arr[i-1], (T)arr[i])>0) {
						Object temp = arr[i-1];
						arr[i-1] = arr[i];
						arr[i] = temp;
						index = i;
					}
				}
				left = index;
			}
		}
		/**
		 * ��������ʹ�÷��ͷ���
		 * ���� T ����ʵ�� Comparable �ӿڣ���������ӿڵ������� T �� T ����һ���ࡣ
		 * ����������T ��ʵ��֮�䣬T ��ʵ�������ĸ����ʵ��֮�䣬�����໥�Ƚϴ�С��
		 */
		@SuppressWarnings("unchecked")
		public static<T extends Comparable<? super T>> void sort(List<T> list){
			//��һ����ת������
			Object[] arr = list.toArray();
			sort(arr);	//����������
			//�ڶ������ı������ж�Ӧ�����飨���ź�˳�����������װ���������
			for(int i=0;i<arr.length;i++) {
				list.set(i, (T) arr[i]);	//ǿתΪ����
			}
		}
		

	/**
	 * ��������ʹ�÷��ͷ���
	 * ���� T ����ʵ�� Comparable �ӿڣ���������ӿڵ������� T��
	 * ֻ��������T ��ʵ��֮������໥�Ƚϴ�С��
	 * @param arr
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static<T extends Comparable<T>> void sort(T[] arr){
		int len = arr.length;
		for(int i=0;i<len-1;i++) {
			boolean sorted = true;
//			System.out.println("��"+(i+1)+"��");
			for(int j=0;j<len-i-1;j++) {
//				System.out.print("��"+(j+1)+"��");
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0) {
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
//				System.out.println(Arrays.toString(arr));
			}
			if(sorted)break;
		}
	}

	
	/**
	 * �����ڶ�̬ʵ�ֲ�ͬ���͵�ð������
	 * @param arr
	 */
	//ʵ���ַ������͵�����ð������
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(Object[] arr) {
		int len = arr.length;
		for(int i=0;i<len-1;i++) {
			boolean sorted = true;
			for(int j=0;j<len-i-1;j++) {
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0) {
					Object temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
			}
			if(sorted)break;
		}
	}
	//ʵ���������͵�ð������
	public static void sort(int[] arr) {
		int len = arr.length;
		for(int i=0;i<len-1;i++) {
			boolean sorted = true;
			for(int j=0;j<len-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
			}
			if(sorted)break;
		}
	}
}
