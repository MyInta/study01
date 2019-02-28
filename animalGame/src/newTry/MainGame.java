package newTry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 鼠吃象控制台版游戏
 * @author 银涛
 *
 */
public class MainGame {
	
	//棋盘内棋子布局类
	private ChessInit start;
	//get方法
	public ChessInit getStart() {
		return start;
	}
	//创建装填棋子的数组
	private ArrayList<Chess> newChess=new ArrayList<>(16);
	
	public ArrayList<Chess> getNewChess() {
		return newChess;
	}

	public MainGame() {
		start = new ChessInit();
		//初始化棋盘上的棋子
		init(start);
	}

	  /**
	   * 设置棋盘初始棋子
	   * @param start
	   */
	  private void init(ChessInit start) {
		//初始化棋盘都是X。  
		for(int i=0;i<16;i++) {
			start.addChess("X", 0, 1);
		}
		//将棋子放置到棋盘同时设定了棋子坐标信息
		start.putOnBoard();
	  }
	
	  /**
	   * 打印所有棋子元素方法
	   */
	  public void print() {
		  //获得所有棋子
			Chess[][] all = start.getChess();
//			int a = CompareChess.compare(all[0][0],all[0][1]);
			for(int i=0;i<all.length;i++) {
				for(int j=0;j<all[i].length;j++) {
					System.out.print("["+all[i][j].getName()+"]"+"\t");
				}
				System.out.println("\r\n");
			}
	  }
	  
	  /**
	   * 添加真实玩的棋子
	   */
	  public void realChess() {
		  newChess.add(ChessUtil.createChess("象", 1, 8,1,1));
		  newChess.add(ChessUtil.createChess("狮", 1, 7,1,2));
		  newChess.add(ChessUtil.createChess("虎", 1, 6,1,3));
		  newChess.add(ChessUtil.createChess("豹", 1, 5,1,4));
		  newChess.add(ChessUtil.createChess("狼", 1, 4,2,1));
		  newChess.add(ChessUtil.createChess("狗", 1, 3,2,2));
		  newChess.add(ChessUtil.createChess("猫", 1, 2,2,3));
		  newChess.add(ChessUtil.createChess("鼠", 1, 1,2,4));
	
		  newChess.add(ChessUtil.createChess("象'", 2, 8,3,1));
		  newChess.add(ChessUtil.createChess("狮'", 2, 7,3,2));
		  newChess.add(ChessUtil.createChess("虎'", 2, 6,3,3));
		  newChess.add(ChessUtil.createChess("豹'", 2, 5,3,4));
		  newChess.add(ChessUtil.createChess("狼'", 2, 4,4,1));
		  newChess.add(ChessUtil.createChess("狗'", 2, 3,4,2));
		  newChess.add(ChessUtil.createChess("猫'", 2, 2,4,3));
		  newChess.add(ChessUtil.createChess("鼠'", 2, 1,4,4));
		  
		  Collections.shuffle(newChess);

	  }
	  
	public static void main(String[] args) {
		
		//创建游戏
		MainGame core = new MainGame();
		//打印棋盘
		core.print();
		Scanner scan = new Scanner(System.in);
		//填入棋子元素
		core.realChess();
		while(true) {
			System.out.println("请输入目标x坐标+空格+y坐标+空格+方向+回车");
			String msg = scan.nextLine();
			//分割后获得坐标和方向信息
			int[] msgs = ChessUtil.splitMsg(msg);
			Chess[][] c = core.getStart().getChess();
			//将获得坐标位置的棋盘点设置为对应棋子
			c[msgs[0]-1][msgs[1]-1] = core.getNewChess().get(msgs[0]+(msgs[1]-1)*4-1);
			//重新打印
			core.print();
		}
	}
	
}
