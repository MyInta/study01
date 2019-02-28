package ui;

import java.awt.Color;
import java.awt.Graphics;

import config.GameConfig;

public class LayerPoint extends Layer{
	/**
	 * 分数最大位数
	 */
	private static final int POINT_BIT=5;
	/**
	 * 升级行数
	 */
	private static final int LEVEL_UP=GameConfig.getSystemConfig().getLevelUp();
	/**
	 * 共同的X坐标
	 */
	private final int comX;
	/**
	 * 标题分数的位置Y
	 */
	private final int pointY;
	/**
	 * 标题消行的位置Y
	 */
	private final int rmLineY;
	/**
	 * 经验值exp的Y坐标
	 */
	private final int expY;
	
	public LayerPoint(int x,int y,int w,int h) {
		super(x,y,w,h);
		//初始化共同的X坐标
		this.comX = this.w-IMG_NUMBER_W*POINT_BIT-PADDING;
		//初始化分数显示的Y坐标
		this.pointY = PADDING;
		//初始化消行显示的Y坐标
		this.rmLineY = this.pointY+Img.POINT.getHeight(null)+PADDING;
		//初始化经验值的Y坐标
		this.expY =this.rmLineY+Img.REMOVELINE.getHeight(null)+PADDING;
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		//窗口标题(分数)
		g.drawImage(Img.POINT, this.x+PADDING, this.y+PADDING, null);
		this.drawNumberLeftPad(comX,PADDING,this.dto.getNowPoint(),POINT_BIT,g);	//因为数字图片上有空白距离，所以参数二为0
		//窗口标题(消行)
		g.drawImage(Img.REMOVELINE, this.x+PADDING, this.y+rmLineY, null);
		//显示消行
		this.drawNumberLeftPad(comX,rmLineY,this.dto.getNowRemoveLine(),POINT_BIT,g);
		//绘制值槽
		int rmLine = this.dto.getNowRemoveLine();
		this.drawRect(expY,"下一级",null,(double)(rmLine%LEVEL_UP)/(double)LEVEL_UP,g);
	}
	
	
	
	/**
	 * 代码实现的血槽颜色变化（一般用图片，所以会被废弃）
	 * @param hp 血槽从左往右增加的条长度
	 * @param maxHp 血槽总长度
	 * @return Color 返回新建的颜色
	 * @deprecated 颜色太单调，缺乏立体感
	 */
	private Color getNowColor(double hp,double maxHp){
		int colorR=0;
		int colorG=255;
		int colorB=0;
		double hpHalf = maxHp/2;
		if(hp>hpHalf) {
			colorR =255-(int)((hp-hpHalf)/(maxHp/2)*255);
			colorG =255;
		}else {
			colorR=255;
			colorG=(int)(hp/(maxHp/2)*255);
		}
		return new Color(colorR,colorG,colorB);
	}
}
