package ui;

import java.awt.Graphics;

/**
 * ǩ�����
 * (���Խ׶�����Ϸ���½�)
 * @author ����
 *
 */
public class LayerAbout extends Layer{
	
	public LayerAbout(int x,int y,int w,int h) {
		super(x,y,w,h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		this.drawImagAtCenter(Img.SIGN,g);
	}
}
