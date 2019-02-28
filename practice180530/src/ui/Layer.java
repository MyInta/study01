package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import config.FrameConfig;
import config.GameConfig;
import dto.GameDto;

/**
 * ���ƴ���
 * @author ����
 *
 */
public class Layer {
	
	/**
	 * �ڱ߾�
	 */
	protected static final int PADDING;
	/**
	 * �߿���
	 */
	protected static final int SIZE;
	static {
		// �����Ϸ����
		FrameConfig fcf = GameConfig.getFrameConfig();
		PADDING = fcf.getPadding();
		SIZE =fcf.getBorder();
	}
	
	private static int WINDOW_W = Img.WINDOW.getWidth(null);
	private static int WINDOW_H = Img.WINDOW.getHeight(null);
	
	/**
	 * Ĭ�������С
	 */
	private static final Font DEF_FONT=new Font("����",Font.BOLD,20);
	
	/**
	 * ������Ƭ�Ŀ��
	 */
	protected static final int IMG_NUMBER_W=Img.NUMBER.getWidth(null)/10;
	/**
	 * ������Ƭ�ĸ߶�
	 */
	private static final int IMG_NUMBER_H=Img.NUMBER.getHeight(null);
	/**
	 * ����ֵ�۱�������ȣ�
	 */
	private static final int IMG_RECT_W = Img.RECT.getWidth(null);
	/**
	 * ����ֵ�۱������߶ȣ�
	 */
	protected static final int IMG_RECT_H = Img.RECT.getHeight(null);
	/**
	 * ����ֵ�ۣ���ȣ�
	 */
	private final int rectW ;
	
	/**
	 * �������Ͻ�x����
	 */
	protected final int x;
	/**
	 * �������Ͻ�y����
	 */
	protected final int y;
	/**
	 * ���ڿ��w
	 */
	protected final int w;
	/**
	 * ���ڸ߶�h
	 */
	protected final int h;

	/**
	 * ��Ϸ����
	 */
	protected GameDto dto=null;
	
	protected Layer(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rectW = this.w-(PADDING<<1);
	}

	/**
	 * ���ƴ���
	 * 
	 * @author ����
	 * @param g ����
	 */
	protected void createWindow(Graphics g) {
		// ����
		g.drawImage(Img.WINDOW, x, y, x + SIZE, y + SIZE, 0, 0, SIZE, SIZE, null);
		// ����
		g.drawImage(Img.WINDOW, x + SIZE, y, x + w - SIZE, y + SIZE, SIZE, 0, WINDOW_W - SIZE, SIZE, null);
		// ����
		g.drawImage(Img.WINDOW, x + w - SIZE, y, x + w, y + SIZE, WINDOW_W - SIZE, 0, WINDOW_W, SIZE, null);
		// ����
		g.drawImage(Img.WINDOW, x, y + SIZE, x + SIZE, y + h - SIZE, 0, SIZE, SIZE, WINDOW_H - SIZE, null);
		// ��
		g.drawImage(Img.WINDOW, x + SIZE, y + SIZE, x + w - SIZE, y + h - SIZE, SIZE, SIZE, WINDOW_W - SIZE,
				WINDOW_H - SIZE, null);
		// ����
		g.drawImage(Img.WINDOW, x + w - SIZE, y + SIZE, x + w, y + h - SIZE, WINDOW_W - SIZE, SIZE, WINDOW_W,
				WINDOW_H - SIZE, null);
		// ����
		g.drawImage(Img.WINDOW, x, y + h - SIZE, x + SIZE, y + h, 0, WINDOW_H - SIZE, SIZE, WINDOW_H, null);
		// ����
		g.drawImage(Img.WINDOW, x + SIZE, y + h - SIZE, x + w - SIZE, y + h, SIZE, WINDOW_H - SIZE, WINDOW_W - SIZE,
				WINDOW_H, null);
		// ����
		g.drawImage(Img.WINDOW, x + w - SIZE, y + h - SIZE, x + w, y + h, WINDOW_W - SIZE, WINDOW_H - SIZE, WINDOW_W,
				WINDOW_H, null);
	}

	/**
	 * ���ݿ�set����
	 * @param dto
	 */
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	
	/**
	 * �滭���ݿ�������λ�ÿ��Ҷ���
	 * @param x
	 * @param y
	 * @param g
	 */
	protected void drawLeft(String strNum,int x,int y,Graphics g) {
		//5��ʾ������ֵΪ��λ����
		for(int i=0;i<5;i++) {
			if((5-i)<=strNum.length()) {
				//����������ַ����е��±�
				int idx = strNum.length()+i-5;
				//������number�е�ÿһλȡ��
				String bit = Integer.toString(strNum.charAt(idx)-'0');//���������Ϊ����ʾΪ����int����
				//��������
				g.drawString(bit,x+i*10,y);	//10�ǵ������ֵĿ��
			}
		}
	}
	
	/**
	 * ��ʾ����
	 * @param x ���Ͻ�x����
	 * @param y ���Ͻ�y����
	 * @param num Ҫ��ʾ������
	 * @param maxBit ����λ��
	 * @param g ���ʶ���
	 */
	protected void drawNumberLeftPad(int x,int y,int num,int maxBit,Graphics g) {
		//��number�е�ÿһλ��ȡ�� ת���ַ���
		String strNum = Integer.toString(num);
		//ѭ�����������ҿ���
		for(int i=0;i<maxBit;i++) {
			//�ж��Ƿ������������
			if((maxBit-i)<=strNum.length()) {
				//����������ַ����е��±�
				int idx = strNum.length()+i-maxBit;
				//������number�е�ÿһλȡ��
				int bit = strNum.charAt(idx)-'0';	//���������Ϊ����ʾΪ����int����
				//��������
				g.drawImage(Img.NUMBER,
					this.x+x+IMG_NUMBER_W*i, this.y+y-PADDING, 	//����ͼƬ͸�����ϸ߶�հ�16����,����PADDING��
					this.x+x+IMG_NUMBER_W*(i+1),  this.y+y+IMG_NUMBER_H-PADDING,
					bit*IMG_NUMBER_W, 0,
					(bit+1)*IMG_NUMBER_W, IMG_NUMBER_H,
					null);
			}
			
		}
	}
	
	/**
	 * ����ֵ��
	 * @param y ����
	 * @param title ����
	 * @param number ��ֵ
	 * @param percent ֵռ��
	 * @param g ����
	 */
	protected void drawRect(int y,String title,String number,double percent,Graphics g) {
		//����ֵ��ʼ��
		int rect_x = this.x+PADDING;
		int rect_y = this.y+y;
		//���Ʊ���
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H+4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x+1, rect_y+1, this.rectW-2, IMG_RECT_H+2);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x+2, rect_y+2, this.rectW-4, IMG_RECT_H);
		//��̬����ֵ
		/*g.setColor(getNowColor((double)(rmLine%LEVEL_UP),(double)LEVEL_UP));
		g.fillRect(this.x+PADDING+2, this.y+expY+2, w, h-4);*/
		
		//������
		int w=(int)(percent*(this.rectW-4));
		//�����ɫ
		int subIdx = (int)(percent*IMG_RECT_W)-1;
		//����ֵ��
		g.drawImage(Img.RECT,
				rect_x+2, rect_y+2, 
				rect_x+2+w, rect_y+2+IMG_RECT_H,
				subIdx, 0, subIdx+1, IMG_RECT_H,
				null);
		g.setColor(Color.WHITE);
		g.setFont(DEF_FONT);
		g.drawString(title, rect_x+4, rect_y+22);
		if(null!=number) {
			//�Ҷ������ʾ����
			drawLeft(number,rect_x+248, rect_y+22,g);
//			g.drawString(number, rect_x+248, rect_y+22);
		}
	}
	/**
	 * ���л滭
	 * @param img ͼƬ
	 * @param g ����
	 */
	protected void drawImagAtCenter(Image img,Graphics g) {
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		int imgX = (this.w-imgW>>1)+this.x;
		int imgY = (this.h-imgH>>1)+this.y;
		g.drawImage(img, imgX, imgY, null);
	}
	
	/**
	 * ˢ����Ϸ��������
	 * 
	 * @author ����
	 * @param g ����
	 */
	public void paint(Graphics g) {

	}
}
