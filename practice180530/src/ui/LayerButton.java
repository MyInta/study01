package ui;

import java.awt.Graphics;
/**
 * ��ť���
 * @author ����
 *
 */
public class LayerButton extends Layer{
	public LayerButton(int x,int y,int w,int h) {
		super(x,y,w,h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
	}
}
