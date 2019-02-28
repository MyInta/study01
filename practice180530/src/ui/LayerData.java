package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import config.GameConfig;
import dto.Player;
/**
 * 数据库模板，日后给数据库 本地磁盘等继承用，减少对layer的耦合
 * @author 银涛
 *
 */
public abstract class LayerData extends Layer{
	
	/**
	 * 最大数据行
	 */
	private static final int MAX_ROW=GameConfig.getDataConfig().getMaxRow();
	/**
	 * 起始Y坐标
	 */
	private static int START_Y=0;
	/**
	 * 值槽高度
	 */
	private static final int RECT_H= IMG_RECT_H+4;
	/**
	 * 间距
	 */
	private static int SPA=0;
	
	protected LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
		//计算绘制间距
		SPA = (this.h - RECT_H * 5 - (PADDING << 1) - Img.DB.getHeight(null)) / MAX_ROW;
		// 计算其实Y坐标
		START_Y = PADDING + Img.DB.getHeight(null) + SPA;
	}
	
	/**
	 * 绘制所有值槽
	 * @param imgTitle 标题图片
	 * @param players 数据源
	 * @param g 画笔
	 */
	public void showData(Image imgTitle,List<Player> players,Graphics g) {
		this.createWindow(g);
		//绘制标题
		g.drawImage(imgTitle, this.x+PADDING, this.y+PADDING, null);
		//获取现在分数
		int nowPoint = this.dto.getNowPoint();
		//循环绘制记录
		for(int i=0;i<MAX_ROW;i++) {
			//获得一条玩家记录
			Player pla = players.get(i);
			//获得该分数
			int recordPoint = pla.getPoint();
			//获得现在分数与记录分数的百分比
			double percent = (double)nowPoint/recordPoint;
			//如果已破记录，比值设定为100%
			percent = percent>1?1.0:percent;
			//绘制单条记录
			String strPoint = recordPoint==0?null:Integer.toString(recordPoint);
			this.drawRect(START_Y+i*(RECT_H+SPA),
					pla.getName(), strPoint,
					percent, g);
		}
	}

	@Override
	abstract public void paint(Graphics g);
	
}
