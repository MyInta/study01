package ui;

import java.awt.Graphics;
import java.awt.Point;

import config.GameConfig;
import entity.GameAct;

public class LayerGame extends Layer{
	
	/**
	 * 左位移偏移量 左移乘2的n次
	 */
	private static final int ACT_SIZE_ROL=GameConfig.getFrameConfig().getSizeRol();
	
	//TODO 硬编码 左边距
	private static final int LEFT_SIDE = 0;
	/**
	 * 右边距
	 */
	private static final int RIGHT_SIDE = GameConfig.getSystemConfig().getMaxX();
	/**
	 * 失败后的方块编码
	 */
	private static final int LOSE_IDX = GameConfig.getFrameConfig().getLoseIdx();
	
	public LayerGame(int x,int y,int w,int h) {
		super(x,y,w,h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		// 获得方块数组集合
		GameAct act = this.dto.getGameAct();
		if(null!=act) {
			Point[] points = act.getActPoints();
			// 绘制方块阴影
			this.drawShadow(points, g);
			// 绘制活动方块
			this.drawMainAct(points, g);	
		}
		//绘制游戏地图
		this.drawMap(g);
		//暂停
		if(this.dto.isPause()) {
			this.drawImagAtCenter(Img.PAUSE, g);
		}
	}
	/**
	 * 绘制活动方块
	 * @param g
	 */
	private void drawMainAct(Point[] points,Graphics g) {
		//获得方块类型编号0~6
		int typeCode = this.dto.getGameAct().getTypeCode();
		//绘制方块
		for(int i=0;i<points.length;i++) {
			drawActByPoint(points[i].x,points[i].y,typeCode+1,g);
//			g.drawImage(ACT, 
//					this.x+(points[i].x<<ACT_SIZE_ROL)+7, 
//					this.y+(points[i].y<<ACT_SIZE_ROL)+7, 
//					//this.x+points[i].x*32+32+7;
//					this.x+(points[i].x+1<<ACT_SIZE_ROL)+7, //注意四则中是先加减再位移该行先+1总值再位移（乘32）
//					this.y+(points[i].y+1<<ACT_SIZE_ROL)+7, 
//					(typeCode+1)<<ACT_SIZE_ROL, 0, (typeCode+2)<<ACT_SIZE_ROL, 1<<ACT_SIZE_ROL, null);
		}
	}
	/**
	 * 绘制地图
	 * @param g
	 */
	private void drawMap(Graphics g) {
		boolean[][] map = this.dto.getGameMap();
		//计算当前堆积颜色
		int lv = this.dto.getNowLevel();
		int imgIdx = lv==0?0:(lv-1)%7+1;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j]) {
					drawActByPoint(i,j,imgIdx,g);//如果输了，就显示颜色8 imgIdx=8;
//					g.drawImage(ACT, 
//							this.x+(i<<ACT_SIZE_ROL)+7, 
//							this.y+(j<<ACT_SIZE_ROL)+7, 
//							this.x+(i+1<<ACT_SIZE_ROL)+7, 
//							this.y+(j+1<<ACT_SIZE_ROL)+7, 
//							0, 0, 1<<ACT_SIZE_ROL,1<<ACT_SIZE_ROL, null);
				}
			}
		}
	}
	/**
	 * 绘制阴影
	 * @param points
	 * @param b
	 */
	private void drawShadow(Point[] points,Graphics g) {
		// 阴影关闭
		if(!this.dto.isShowShadow()) {
			return;
		}
		int leftX = RIGHT_SIDE;
		int rightX = LEFT_SIDE;
		for(Point p:points) {
			leftX=p.x<leftX?p.x:leftX;
			rightX=p.x>rightX?p.x:rightX;
		}
		g.drawImage(Img.SHADOW,
				this.x+SIZE+(leftX<<ACT_SIZE_ROL),//左移5位相当于乘32
				this.y+SIZE, 
				(rightX-leftX+1)<<ACT_SIZE_ROL,
				this.h-(SIZE<<1),
				null);
	}

	/**
	 * 绘制正方形块
	 * @param x 方块x坐标
	 * @param y 方块y坐标
	 * @param imgIdx 方块序号
	 * @param g 画笔
	 */
	private void drawActByPoint(int x,int y,int imgIdx,Graphics g) {
		imgIdx = this.dto.isStart()?imgIdx:LOSE_IDX;
		g.drawImage(Img.ACT, 
				this.x+(x<<ACT_SIZE_ROL)+SIZE, 
				this.y+(y<<ACT_SIZE_ROL)+SIZE, 
				this.x+(x+1<<ACT_SIZE_ROL)+SIZE, //注意四则中是先加减再位移该行先+1总值再位移（乘32）
				this.y+(y+1<<ACT_SIZE_ROL)+SIZE, 
				imgIdx<<ACT_SIZE_ROL, 0, (imgIdx+1)<<ACT_SIZE_ROL, 1<<ACT_SIZE_ROL, null);
	}
}
