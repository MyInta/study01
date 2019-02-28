package review;

/**
 * 测试多维数组相加方法
 * @author 银涛
 *
 */
public class TestMatrix {

	/**
	 * 多维数组矩阵加法
	 */
	private int[][] add(int[][] a,int[][] b) {
		int[][] c = new int [a.length][];
		for(int i=0;i<a.length;i++) {
			c[i] = new int [a[i].length];
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				c[i][j] = a[i][j]+b[i][j];
			}
		}
		return c;
	}
	/**
	 * 打印出该数组内所有元素
	 * @param obj
	 */
	private void printMatrix(int[][] obj) {
		for(int i =0;i<obj.length;i++) {
			for(int j=0;j<obj[i].length;j++) {
				System.out.print(obj[i][j]+"\t");//打印每一行内的元素
			}
			System.out.println();//换行
		}
	}
	
	public static void main(String args[]) {
		TestMatrix t = new TestMatrix();
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
		int[][] z = t.add(n,m);
		t.printMatrix(z);
	}
}
