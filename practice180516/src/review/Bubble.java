package review;


import java.util.Arrays;

/**
 * �����Ż�ð������ʵ���˳�ѧʱ���һ������ɣ�����count��System.out��Ϊ������
 * @author ����
 *
 */
public class Bubble {
	/**
	 * ��򵥵�һ��ð������
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
		System.out.println("����1��"+count);
		System.out.println(Arrays.toString(obj));
		return obj;
	}
	
	/**
	 * ���貼��ֵ�����ٿ��ܴ��ڵĺ��漸�ֶ��������
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
				break;	//����һ�ַ���û�н���������ѭ��
			}
		}
		System.out.println("����2��"+count);
		System.out.println(Arrays.toString(obj));
		return obj;
	}
	
	/**
	 * ��¼���һ�ν���λ�ã��Ż�����
	 * @param obj
	 * @return
	 */
	public static int[] test03(int[] obj) {
		int count=0;
		int markPoint = obj.length-1;	//���������Զһ�ν���������
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
		System.out.println("����3��"+count);
		System.out.println(Arrays.toString(obj));
		return obj;
	}
	
	/**
	 * ���ӳ̶�δ������µģ����ʽ�Ż�����
	 * �������飬��¼���һ�ν����Ͳ����ж������ʽ������׸�ģ�����
	 * ��������Ҫ�Ӳ�������¼�����൱���Դ������ж��ˣ���
	 * @param obj
	 * @return
	 */
	public static int[] test04(int[] obj) {
		int count=0;
		int markPoint = obj.length-1;	//���������Զһ�ν���������
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
		System.out.println("����4��"+count);
		System.out.println(Arrays.toString(obj));
		return obj;
	}
	
	/**
	 * ˫��ѡ��ӽ�ȡ���򷨣����Լ����ʱ�临�Ӷȡ�
	 * @param obj
	 * @return
	 */
	public static int[] test05(int[] obj) {
		int count=0;
		int low,up,index;
		low = 0;
		up = obj.length-1;
		//index�൱��ָ�룬һ����λ�ñ�����ȥ��ֱ��ѭ��������ȷ�������յ�λ���ٷ������趨��low or up��
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
			//�ҵ�����һ�ֺ�����Ҳ��Կ�����Ҫ������Ԫ������
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
		System.out.println("����5��"+count);
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
