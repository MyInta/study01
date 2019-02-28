package newTry;

import java.util.ArrayList;
import java.util.Random;

/**
 * 棋子实用工具类
 * 2是撞死了
 * 1是可以吃过去
 * 0是两者抵消
 * -1是不许吃
 * -2是出现异常
 * @author 银涛
 *
 */
public class ChessUtil{

	/**
	 * 棋子比较方法
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	public static int compare(Chess arg0, Chess arg1) {
		//如果目标地址不存在棋子
		if(!arg1.isLive()) {
			return 1;
		}else if(arg0.getHome()==arg1.getHome()){//如果目的地上棋子是同伴
			return -1;
		}else if(arg0.getPower()>arg1.getPower()){//如果比目的地棋子大
			return 1;
		}else if(arg0.getPower()==arg1.getPower()) {//如果两者相同大
			return 0;
		}else if(arg0.getPower()<arg1.getPower()) {//如果后者比较大
			return 2;
		}
		return -2;
	}
	
	/**
	 * 分解信息获取坐标x y和方向int类型数据
	 * @param msg
	 * @return
	 */
	public static int[] splitMsg(String msg) {
		//按照格式x y int方向切割 中间有空格
		String[] msgStr = msg.split(" ");
		int[] msgs = new int[msgStr.length];
		int i = 0;
		for(String temp:msgStr) {
			msgs[i] = Integer.parseInt(temp);
			i++;
		}
		return msgs;
		
	}
	
	/**
	 * 添加棋子的方法
	 */
	public static Chess createChess(String name,int home,int power,int xCode,int yCode) {
		//新建一个棋子，并添加内部元素
		Chess c = new Chess(name,home,power);
		//设置其位置存在棋子
		c.setLive(true);
		c.setxCode(xCode);
		c.setyCode(yCode);
		return c;
	}
	  /**
	   * 随机排列数组元素的方法
	   * @param arr
	   * @return
	   */
	  public static Chess[] randomPiece(Chess[] arr) {
		  Chess [] arr2 = new Chess[arr.length];
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
