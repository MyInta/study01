package ui;

import java.awt.Color;
import java.awt.Graphics;

import config.GameConfig;

public class LayerPoint extends Layer{
	/**
	 * �������λ��
	 */
	private static final int POINT_BIT=5;
	/**
	 * ��������
	 */
	private static final int LEVEL_UP=GameConfig.getSystemConfig().getLevelUp();
	/**
	 * ��ͬ��X����
	 */
	private final int comX;
	/**
	 * ���������λ��Y
	 */
	private final int pointY;
	/**
	 * �������е�λ��Y
	 */
	private final int rmLineY;
	/**
	 * ����ֵexp��Y����
	 */
	private final int expY;
	
	public LayerPoint(int x,int y,int w,int h) {
		super(x,y,w,h);
		//��ʼ����ͬ��X����
		this.comX = this.w-IMG_NUMBER_W*POINT_BIT-PADDING;
		//��ʼ��������ʾ��Y����
		this.pointY = PADDING;
		//��ʼ��������ʾ��Y����
		this.rmLineY = this.pointY+Img.POINT.getHeight(null)+PADDING;
		//��ʼ������ֵ��Y����
		this.expY =this.rmLineY+Img.REMOVELINE.getHeight(null)+PADDING;
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		//���ڱ���(����)
		g.drawImage(Img.POINT, this.x+PADDING, this.y+PADDING, null);
		this.drawNumberLeftPad(comX,PADDING,this.dto.getNowPoint(),POINT_BIT,g);	//��Ϊ����ͼƬ���пհ׾��룬���Բ�����Ϊ0
		//���ڱ���(����)
		g.drawImage(Img.REMOVELINE, this.x+PADDING, this.y+rmLineY, null);
		//��ʾ����
		this.drawNumberLeftPad(comX,rmLineY,this.dto.getNowRemoveLine(),POINT_BIT,g);
		//����ֵ��
		int rmLine = this.dto.getNowRemoveLine();
		this.drawRect(expY,"��һ��",null,(double)(rmLine%LEVEL_UP)/(double)LEVEL_UP,g);
	}
	
	
	
	/**
	 * ����ʵ�ֵ�Ѫ����ɫ�仯��һ����ͼƬ�����Իᱻ������
	 * @param hp Ѫ�۴����������ӵ�������
	 * @param maxHp Ѫ���ܳ���
	 * @return Color �����½�����ɫ
	 * @deprecated ��ɫ̫������ȱ�������
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
