package newTry;

import java.util.ArrayList;
import java.util.Random;

/**
 * 棋盘初始化
 * 包括数组装填棋子
 * 打印出所有数组元素
 * @author 银涛
 *
 */
public class ChessInit {

	//创建装填棋子的数组
	private ArrayList<Chess> arrChess=new ArrayList<>(16);
	//棋盘数组 到时候要把棋子数组元素挨个装入其中
	private Chess[][] all = new Chess[4][4]; 
	//对外提供获取棋子数组的方法
	public Chess[][] getChess() {
		return all;
	}

	/**
	 * 添加棋子的方法
	 */
	public void addChess(String name,int home,int power) {
		//新建一个棋子，并添加内部元素
		Chess c = new Chess(name,home,power);
		
		if(name.equals("X")||name.equals("+")) {//如果输入名称为X则表示不是棋子
			c.setHome(0);//0表示立场为中立 还有1和2正反面
			c.setLive(false);
		}
		//设置其位置存在棋子
		c.setLive(true);
		//往棋子数组中添加棋子
		arrChess.add(c);
	}
	
	/**
	 * 修改数组中某索引的元素
	 * @param index
	 */
	public void setChess(int index,Chess chess) {
		//获得原有的棋子
		Chess c = arrChess.get(index);
		//设置原有棋子为新的棋子
		c.setName(chess.getName());
		c.setHome(chess.getHome());
		c.setLive(chess.isLive());
		c.setPower(chess.getPower());
		c.setxCode(chess.getxCode());
		c.setyCode(chess.getyCode());
	}
	
	/**
	 * 往棋盘数组添加棋子
	 * @param arrChess
	 * @return
	 */
	public Chess[][] putOnBoard() {
		
		int n=0;
		//遍历棋子
		for(int i=0;i<all.length;i++) {
			for(int j=0;j<all[i].length;j++) {
				//往对应棋盘位置添加棋子元素
				Chess c = arrChess.get(n);
				//添加棋子横坐标
				c.setxCode(i+1);
				//添加棋子y坐标
				c.setyCode(j+1);
				all[i][j] = c;
				
				n++;
				if(n>=16) {
					break;
				}
			}
		}
		
		return getChess();
	}
	
	  
}
