package review;


import java.util.Arrays;

/**
 * 各种优化冒泡排序，实现了初学时候的一个设想吧，其中count和System.out仅为测试用
 * @author 银涛
 *
 */
public class Bubble {
	/**
	 * 最简单的一种冒泡排序
	 * @param obj
	 * @return
	 */
	public static int[] test01(int[] obj) {
		int count=0;
		for(int i=0;i<obj.length-1;i++) {
			for(int j=0;j<obj.length-1-i;j++) {
				count++;
				if(obj[j]>obj[j+1]) {
					int temp = obj[j];
					obj[j]=obj[j+1];
					obj[j+1]=temp;
				}
			}
		}
		System.out.println("方法1："+count);
		System.out.println(Arrays.toString(obj));
		return obj;
	}
	
	/**
	 * 增设布尔值来减少可能存在的后面几轮多余的排序
	 * @param obj
	 * @return
	 */
	public static int[] test02(int[] obj) {
		int count=0;
		for(int j=0;j<obj.length-1;j++) {
			boolean flag=true;
			for(int i=0;i<obj.length-1-j;i++) {
				count++;
				if(obj[i]>obj[i+1]) {
					int temp = obj[i];
					obj[i] = obj[i+1];
					obj[i+1] = temp;
					flag = false;
				}
			}
			if(flag) {
				break;	//遍历一轮发现没有交换，跳出循环
			}
		}
		System.out.println("方法2："+count);
		System.out.println(Arrays.toString(obj));
		return obj;
	}
	
	/**
	 * 记录最后一次交换位置，优化排序
	 * @param obj
	 * @return
	 */
	public static int[] test03(int[] obj) {
		int count=0;
		int markPoint = obj.length-1;	//用来标记最远一次交换的索引
		for(int i=0;i<obj.length-1;i++) {
			int m = markPoint;
			for(int j=0;j<m;j++) {
				count++;
				if(obj[j]>obj[j+1]) {
					int temp = obj[j];
					obj[j] = obj[j+1];
					obj[j+1] = temp;
					markPoint = j;
				}
			}
		}
		System.out.println("方法3："+count);
		System.out.println(Arrays.toString(obj));
		return obj;
	}
	
	/**
	 * 复杂程度未变情况下的，组合式优化排序
	 * 【经检验，记录最后一次交换和布尔判断组合形式，是累赘的！！！
	 * 根本不需要加布尔，记录交换相当于自带布尔判断了！】
	 * @param obj
	 * @return
	 */
	public static int[] test04(int[] obj) {
		int count=0;
		int markPoint = obj.length-1;	//用来标记最远一次交换的索引
		for(int i=0;i<obj.length-1;i++) {
			boolean flag = false;
			int m = markPoint;
			for(int j=0;j<m;j++) {
				count++;
				if(obj[j]>obj[j+1]) {
					int temp = obj[j];
					obj[j] = obj[j+1];
					obj[j+1] = temp;
					markPoint = j;
					flag = true;
				}
			}
			if(!flag) {
				break;
			}
		}
		System.out.println("方法4："+count);
		System.out.println(Arrays.toString(obj));
		return obj;
	}
	
	/**
	 * 双向选择加截取排序法，可以减少最坏时间复杂度。
	 * @param obj
	 * @return
	 */
	public static int[] test05(int[] obj) {
		int count=0;
		int low,up,index;
		low = 0;
		up = obj.length-1;
		//index相当于指针，一个个位置遍历过去，直到循环结束后，确定的最终点位置再返还给设定的low or up。
		index=low;
		while(up>low) {
			for(int i=low;i<up;i++) {
				count++;
				if(obj[i]>obj[i+1]) {
					int temp = obj[i];
					obj[i] = obj[i+1];
					obj[i+1] = temp;
					index = i;
				}
			}
			//找到排序一轮后最靠近右侧仍可能需要交换的元素索引
			up=index;
			for(int j=up;j>low;j--) {
				count++;
				if(obj[j]<obj[j-1]) {
					int temp = obj[j];
					obj[j] = obj[j-1];
					obj[j-1] = temp;
					index= j;
				}
			}
			low = index;
		}
		System.out.println("方法5："+count);
		System.out.println(Arrays.toString(obj));
		return obj;
	}
	
	public static void main(String[] args) {
		int[] obj1 ={7,25,8,5,2,4,2,3,5,15,12,10,6,19,3,1,20,21,22};
		int[] obj2 ={7,25,8,5,2,4,2,3,5,15,12,10,6,19,3,1,20,21,22};
		int[] obj3 ={7,25,8,5,2,4,2,3,5,15,12,10,6,19,3,1,20,21,22};
		int[] obj4 ={7,25,8,5,2,4,2,3,5,15,12,10,6,19,3,1,20,21,22};
		int[] obj5 ={7,25,8,5,2,4,2,3,5,15,12,10,6,19,3,1,20,21,22};
		System.out.println("=======test01========");
		test01(obj1);
		System.out.println("=======test02========");
		test02(obj2);
		System.out.println("=======test03========");
		test03(obj3);
		System.out.println("=======test04========");
		test04(obj4);
		System.out.println("=======test05========");
		test05(obj5);
//		System.out.println(Arrays.toString(i));
	}
}
