package practice04;

import java.util.Comparator;
import java.util.List;



/**
 * 各种类型冒泡法的collection.sort排序方法集合
 * @author 银涛
 *
 */
	public class Utils {
		/**
		 * List排序，
		 * 使用比较器
		 */
		@SuppressWarnings("unchecked")
		public static<T> void sort(List<T> list,Comparator<T> com){
			//第一步，转成数组
			Object[] arr = list.toArray();
			sort(arr,com);	//对数组排序
			//第二步，改变容器中对应的数组（将排好顺序的数组依此装填回容器）
			for(int i=0;i<arr.length;i++) {
				list.set(i, (T) arr[i]);	//强转为泛型
			}
		}
		/**
		 * 数组的排序(结合冒泡排序,现在采用的是简单的模式，可优化成双向排序冒泡)，
		 * 实现comparator接口
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
			//使用高级版本的排序
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
					//此时已经锁定最靠近右侧的仍可能需要交换的元素index值
				}
				//“缩小”排序范围，右边收缩
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
		 * 容器排序，使用泛型方法
		 * 类型 T 必须实现 Comparable 接口，并且这个接口的类型是 T 或 T 的任一父类。
		 * 这样声明后，T 的实例之间，T 的实例和它的父类的实例之间，可以相互比较大小。
		 */
		@SuppressWarnings("unchecked")
		public static<T extends Comparable<? super T>> void sort(List<T> list){
			//第一步，转成数组
			Object[] arr = list.toArray();
			sort(arr);	//对数组排序
			//第二步，改变容器中对应的数组（将排好顺序的数组依此装填回容器）
			for(int i=0;i<arr.length;i++) {
				list.set(i, (T) arr[i]);	//强转为泛型
			}
		}
		

	/**
	 * 数组排序，使用泛型方法
	 * 类型 T 必须实现 Comparable 接口，并且这个接口的类型是 T。
	 * 只有这样，T 的实例之间才能相互比较大小。
	 * @param arr
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static<T extends Comparable<T>> void sort(T[] arr){
		int len = arr.length;
		for(int i=0;i<len-1;i++) {
			boolean sorted = true;
//			System.out.println("第"+(i+1)+"趟");
			for(int j=0;j<len-i-1;j++) {
//				System.out.print("第"+(j+1)+"次");
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
	 * 类似于多态实现不同类型的冒泡排序
	 * @param arr
	 */
	//实现字符串类型的数组冒泡排序
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
	//实现整数类型的冒泡排序
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
