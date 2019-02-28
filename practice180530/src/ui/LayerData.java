package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import config.GameConfig;
import dto.Player;
/**
 * ���ݿ�ģ�壬�պ�����ݿ� ���ش��̵ȼ̳��ã����ٶ�layer�����
 * @author ����
 *
 */
public abstract class LayerData extends Layer{
	
	/**
	 * ���������
	 */
	private static final int MAX_ROW=GameConfig.getDataConfig().getMaxRow();
	/**
	 * ��ʼY����
	 */
	private static int START_Y=0;
	/**
	 * ֵ�۸߶�
	 */
	private static final int RECT_H= IMG_RECT_H+4;
	/**
	 * ���
	 */
	private static int SPA=0;
	
	protected LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
		//������Ƽ��
		SPA = (this.h - RECT_H * 5 - (PADDING << 1) - Img.DB.getHeight(null)) / MAX_ROW;
		// ������ʵY����
		START_Y = PADDING + Img.DB.getHeight(null) + SPA;
	}
	
	/**
	 * ��������ֵ��
	 * @param imgTitle ����ͼƬ
	 * @param players ����Դ
	 * @param g ����
	 */
	public void showData(Image imgTitle,List<Player> players,Graphics g) {
		this.createWindow(g);
		//���Ʊ���
		g.drawImage(imgTitle, this.x+PADDING, this.y+PADDING, null);
		//��ȡ���ڷ���
		int nowPoint = this.dto.getNowPoint();
		//ѭ�����Ƽ�¼
		for(int i=0;i<MAX_ROW;i++) {
			//���һ����Ҽ�¼
			Player pla = players.get(i);
			//��ø÷���
			int recordPoint = pla.getPoint();
			//������ڷ������¼�����İٷֱ�
			double percent = (double)nowPoint/recordPoint;
			//������Ƽ�¼����ֵ�趨Ϊ100%
			percent = percent>1?1.0:percent;
			//���Ƶ�����¼
			String strPoint = recordPoint==0?null:Integer.toString(recordPoint);
			this.drawRect(START_Y+i*(RECT_H+SPA),
					pla.getName(), strPoint,
					percent, g);
		}
	}

	@Override
	abstract public void paint(Graphics g);
	
}
