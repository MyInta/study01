package ui;

import java.awt.Graphics;
import java.awt.Point;

import config.GameConfig;
import entity.GameAct;

public class LayerGame extends Layer{
	
	/**
	 * ��λ��ƫ���� ���Ƴ�2��n��
	 */
	private static final int ACT_SIZE_ROL=GameConfig.getFrameConfig().getSizeRol();
	
	//TODO Ӳ���� ��߾�
	private static final int LEFT_SIDE = 0;
	/**
	 * �ұ߾�
	 */
	private static final int RIGHT_SIDE = GameConfig.getSystemConfig().getMaxX();
	/**
	 * ʧ�ܺ�ķ������
	 */
	private static final int LOSE_IDX = GameConfig.getFrameConfig().getLoseIdx();
	
	public LayerGame(int x,int y,int w,int h) {
		super(x,y,w,h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		// ��÷������鼯��
		GameAct act = this.dto.getGameAct();
		if(null!=act) {
			Point[] points = act.getActPoints();
			// ���Ʒ�����Ӱ
			this.drawShadow(points, g);
			// ���ƻ����
			this.drawMainAct(points, g);	
		}
		//������Ϸ��ͼ
		this.drawMap(g);
		//��ͣ
		if(this.dto.isPause()) {
			this.drawImagAtCenter(Img.PAUSE, g);
		}
	}
	/**
	 * ���ƻ����
	 * @param g
	 */
	private void drawMainAct(Point[] points,Graphics g) {
		//��÷������ͱ��0~6
		int typeCode = this.dto.getGameAct().getTypeCode();
		//���Ʒ���
		for(int i=0;i<points.length;i++) {
			drawActByPoint(points[i].x,points[i].y,typeCode+1,g);
//			g.drawImage(ACT, 
//					this.x+(points[i].x<<ACT_SIZE_ROL)+7, 
//					this.y+(points[i].y<<ACT_SIZE_ROL)+7, 
//					//this.x+points[i].x*32+32+7;
//					this.x+(points[i].x+1<<ACT_SIZE_ROL)+7, //ע�����������ȼӼ���λ�Ƹ�����+1��ֵ��λ�ƣ���32��
//					this.y+(points[i].y+1<<ACT_SIZE_ROL)+7, 
//					(typeCode+1)<<ACT_SIZE_ROL, 0, (typeCode+2)<<ACT_SIZE_ROL, 1<<ACT_SIZE_ROL, null);
		}
	}
	/**
	 * ���Ƶ�ͼ
	 * @param g
	 */
	private void drawMap(Graphics g) {
		boolean[][] map = this.dto.getGameMap();
		//���㵱ǰ�ѻ���ɫ
		int lv = this.dto.getNowLevel();
		int imgIdx = lv==0?0:(lv-1)%7+1;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j]) {
					drawActByPoint(i,j,imgIdx,g);//������ˣ�����ʾ��ɫ8 imgIdx=8;
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
	 * ������Ӱ
	 * @param points
	 * @param b
	 */
	private void drawShadow(Point[] points,Graphics g) {
		// ��Ӱ�ر�
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
				this.x+SIZE+(leftX<<ACT_SIZE_ROL),//����5λ�൱�ڳ�32
				this.y+SIZE, 
				(rightX-leftX+1)<<ACT_SIZE_ROL,
				this.h-(SIZE<<1),
				null);
	}

	/**
	 * ���������ο�
	 * @param x ����x����
	 * @param y ����y����
	 * @param imgIdx �������
	 * @param g ����
	 */
	private void drawActByPoint(int x,int y,int imgIdx,Graphics g) {
		imgIdx = this.dto.isStart()?imgIdx:LOSE_IDX;
		g.drawImage(Img.ACT, 
				this.x+(x<<ACT_SIZE_ROL)+SIZE, 
				this.y+(y<<ACT_SIZE_ROL)+SIZE, 
				this.x+(x+1<<ACT_SIZE_ROL)+SIZE, //ע�����������ȼӼ���λ�Ƹ�����+1��ֵ��λ�ƣ���32��
				this.y+(y+1<<ACT_SIZE_ROL)+SIZE, 
				imgIdx<<ACT_SIZE_ROL, 0, (imgIdx+1)<<ACT_SIZE_ROL, 1<<ACT_SIZE_ROL, null);
	}
}
