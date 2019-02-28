package practice01;
/**
 * 封装了矩阵算法
 * 测试矩阵
 * @author 银涛
 *
 */
public class Matrix {
	public static int[][] add(int n[][],int m[][]) {
		int z[][] = new int[n.length][];	//利用了多维数组的定义方式来实现非常规矩阵的加法
		for(int i=0;i<n.length;i++) {
			z[i]= new int[n[i].length];		//n[x].length即对应那行的列数
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
	
		//传统的多维数组定义模式，当心非编程问题的空白报错
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
