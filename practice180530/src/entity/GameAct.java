package entity;

import java.awt.Point;
import java.util.List;

import config.GameConfig;

public class GameAct {
	
	/**
	 * 方块数组
	 */
	private Point[] actPoints = null;
	
	/**
	 * 方块编号
	 */
	private int typeCode;
	
	private final static int MIN_X=GameConfig.getSystemConfig().getMinX();
	private final static int MAX_X=GameConfig.getSystemConfig().getMaxX();
	private final static int MIN_Y=GameConfig.getSystemConfig().getMinY();
	private final static int MAX_Y= GameConfig.getSystemConfig().getMaxY();
	
	private	final static List<Point[]> TYPE_CONFIG = GameConfig.getSystemConfig().getTypeConfig();
	private	final static List<Boolean> TYPE_ROUND= GameConfig.getSystemConfig().getTypeRound();
	
	public GameAct(int typeCode) {
		this.init(typeCode);
	}
	
	/**
	 * 初始化方块	
	 * @param actCode
	 */
	public void init(int typeCode) {
		this.typeCode = typeCode;
		//根据actCode的值刷新方块
		//使用数组映射来取代switch case这种low写法
		Point[] points = TYPE_CONFIG.get(typeCode);
		actPoints = new Point[points.length];
		//给新建的points数组内的元素附上取得数组元素的值，避免修改原有数据
		for(int i=0;i<actPoints.length;i++) {
			actPoints[i] = new Point(points[i].x,points[i].y);
		}
	}
	
	/**
	 * 方块移动
	 * @param moveX X轴偏移量 正右移
	 * @param moveY	Y轴偏移量 正下移
	 */
	public boolean move(int moveX,int moveY,boolean[][] gameMap) {
		//移动处理
		for(int i=0;i<actPoints.length;i++) {
			int newX = actPoints[i].x+moveX;
			int newY = actPoints[i].y+moveY;
			if(isOverZone(newX, newY,gameMap)) {
				return false;
			}
		}
		//之所以不可以将新的位置放到前面的for循环，是防止部分不合理的方块越界，故要先将全部方块检验完
		for(int i=0;i<actPoints.length;i++) {
			actPoints[i].x+=moveX;
			actPoints[i].y+=moveY;
		}
		return true;
	}
	
	/**
	 * 方块旋转
	 * 
	 * 顺时针 笛卡尔公式 零点(0.0) B->A变换
	 * A.x = 0.y+0.x-B.y;
	 * A.y = 0.y-0.x+B.x;	
	 */
	public void round(boolean[][] gameMap) {
		//如果是田字方块则不需要旋转操作
		if(!TYPE_ROUND.get(this.typeCode)) {	
			return;
		}
		//当初摆放各小方块坐标时候，将旋转点放在了首位，故“零点”为索引0的方块坐标
		for(int i=1;i<actPoints.length;i++) {
			int newX= actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY= actPoints[0].y-actPoints[0].x+actPoints[i].x;
			//判断能否再旋转
			if(this.isOverZone(newX,newY,gameMap)) {
				return;
			}
		}
		for(int i=1;i<actPoints.length;i++) {
			int newX= actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY= actPoints[0].y-actPoints[0].x+actPoints[i].x;
			actPoints[i].x =newX;
			actPoints[i].y =newY;
		}
	}
	
	/**
	 * 判断是否超出边界
	 * @return
	 */
	public boolean isOverZone(int x,int y,boolean[][] gameMap) {
		return x<MIN_X||x>MAX_X||y<MIN_Y||y>MAX_Y||gameMap[x][y];
	}
	/**
	 * 获得方块新位置数组
	 * @return
	 */
	public Point[] getActPoints() {
		return this.actPoints;
	}
	/**
	 * 获得方块类型编号用于NEXT框内显示等
	 * @return
	 */
	public int getTypeCode() {
		return typeCode;
	}
	
}
