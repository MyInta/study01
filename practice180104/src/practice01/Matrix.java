package practice01;
/**
 * ��װ�˾����㷨
 * ���Ծ���
 * @author ����
 *
 */
public class Matrix {
	public static int[][] add(int n[][],int m[][]) {
		int z[][] = new int[n.length][];	//�����˶�ά����Ķ��巽ʽ��ʵ�ַǳ������ļӷ�
		for(int i=0;i<n.length;i++) {
			z[i]= new int[n[i].length];		//n[x].length����Ӧ���е�����
		}
		for(int i=0;i<z.length;i++) {
			for(int j=0;j<z[i].length;j++) {
				z[i][j] = n[i][j]+m[i][j];
			}
		}
		return z;
	}
	
	public static void print01(int[][] z) {
		for(int i=0;i<z.length;i++) {
			for(int j=0;j<z[i].length;j++) {
				System.out.print(z[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int n[][] = {
					{3,4,5},
					{5,6,6,6},
					{7,8,9}
					};
		
		int m[][] = {
					{1,2,3},
					{3,4,4,5},
					{3,4,4}
					};
		int[][] z = add(n,m);
		print01(z);
	
		//��ͳ�Ķ�ά���鶨��ģʽ�����ķǱ������Ŀհױ���
//		System.out.println("*************");
//		int [][]a = new int[3][];
//		a[0] = new int[2];
//		a[1] = new int[4];
//		a[2] = new int[3];
//		a[0][0] = 3;
//		a[0][1] = 4;
//		a[1][0] = 1;
//		a[1][1] = 2;
//		a[1][2] = 8;
//		a[1][3] = 9;
//		a[2][0] = 5;
//		a[2][1] = 6;
//		a[2][2] = 7;
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				System.out.print(a[i][j]+"\t");
//			}
//			System.out.println();
//		}
	}
}
