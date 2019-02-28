package review;

/**
 * ���Զ�ά������ӷ���
 * @author ����
 *
 */
public class TestMatrix {

	/**
	 * ��ά�������ӷ�
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
	 * ��ӡ��������������Ԫ��
	 * @param obj
	 */
	private void printMatrix(int[][] obj) {
		for(int i =0;i<obj.length;i++) {
			for(int j=0;j<obj[i].length;j++) {
				System.out.print(obj[i][j]+"\t");//��ӡÿһ���ڵ�Ԫ��
			}
			System.out.println();//����
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
