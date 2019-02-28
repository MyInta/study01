package entity;

import java.awt.Point;
import java.util.List;

import config.GameConfig;

public class GameAct {
	
	/**
	 * ��������
	 */
	private Point[] actPoints = null;
	
	/**
	 * ������
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
	 * ��ʼ������	
	 * @param actCode
	 */
	public void init(int typeCode) {
		this.typeCode = typeCode;
		//����actCode��ֵˢ�·���
		//ʹ������ӳ����ȡ��switch case����lowд��
		Point[] points = TYPE_CONFIG.get(typeCode);
		actPoints = new Point[points.length];
		//���½���points�����ڵ�Ԫ�ظ���ȡ������Ԫ�ص�ֵ�������޸�ԭ������
		for(int i=0;i<actPoints.length;i++) {
			actPoints[i] = new Point(points[i].x,points[i].y);
		}
	}
	
	/**
	 * �����ƶ�
	 * @param moveX X��ƫ���� ������
	 * @param moveY	Y��ƫ���� ������
	 */
	public boolean move(int moveX,int moveY,boolean[][] gameMap) {
		//�ƶ�����
		for(int i=0;i<actPoints.length;i++) {
			int newX = actPoints[i].x+moveX;
			int newY = actPoints[i].y+moveY;
			if(isOverZone(newX, newY,gameMap)) {
				return false;
			}
		}
		//֮���Բ����Խ��µ�λ�÷ŵ�ǰ���forѭ�����Ƿ�ֹ���ֲ�����ķ���Խ�磬��Ҫ�Ƚ�ȫ�����������
		for(int i=0;i<actPoints.length;i++) {
			actPoints[i].x+=moveX;
			actPoints[i].y+=moveY;
		}
		return true;
	}
	
	/**
	 * ������ת
	 * 
	 * ˳ʱ�� �ѿ�����ʽ ���(0.0) B->A�任
	 * A.x = 0.y+0.x-B.y;
	 * A.y = 0.y-0.x+B.x;	
	 */
	public void round(boolean[][] gameMap) {
		//��������ַ�������Ҫ��ת����
		if(!TYPE_ROUND.get(this.typeCode)) {	
			return;
		}
		//�����ڷŸ�С��������ʱ�򣬽���ת���������λ���ʡ���㡱Ϊ����0�ķ�������
		for(int i=1;i<actPoints.length;i++) {
			int newX= actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY= actPoints[0].y-actPoints[0].x+actPoints[i].x;
			//�ж��ܷ�����ת
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
	 * �ж��Ƿ񳬳��߽�
	 * @return
	 */
	public boolean isOverZone(int x,int y,boolean[][] gameMap) {
		return x<MIN_X||x>MAX_X||y<MIN_Y||y>MAX_Y||gameMap[x][y];
	}
	/**
	 * ��÷�����λ������
	 * @return
	 */
	public Point[] getActPoints() {
		return this.actPoints;
	}
	/**
	 * ��÷������ͱ������NEXT������ʾ��
	 * @return
	 */
	public int getTypeCode() {
		return typeCode;
	}
	
}
