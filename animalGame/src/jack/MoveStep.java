package jack;

import java.awt.Point;
import java.util.Random;

	/**
	 * 走步类
	 * @author 银涛
	 *
	 */
	  public class MoveStep implements java.io.Serializable {
	  public Point pStart, pEnd;
	
	  public MoveStep(Point p1, Point p2) {
	  	pStart = p1;
	  	pEnd = p2;
	  }
	  /**
	   * 随机排列数组元素的方法
	   * @param arr
	   * @return
	   */
	  public static ChessPiece[] randomPiece(ChessPiece[] arr) {
		  ChessPiece [] arr2 = new ChessPiece[arr.length];
		  int count = arr.length;
		  int randCount = 0;//索引
		  int position = 0;//位置
		  int k = 0;
		  do {
			  Random rand = new Random();
			  int r = count-randCount;
			  position = rand.nextInt(r);
			  arr2[k++] = arr[position];
			  randCount++;
			  arr[position] = arr[r-1];
		  }while(randCount<count);
		  return arr2;
	  }
	  }
