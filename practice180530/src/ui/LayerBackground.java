package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * ±³¾°°å¿é
 * @author ÒøÌÎ
 *
 */
public class LayerBackground extends Layer{
	
	public LayerBackground(int x,int y,int w,int h) {
		super(x,y,w,h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		int bgIdx = this.dto.getNowLevel()%Img.BG_LIST.size();
		g.drawImage(Img.BG_LIST.get(bgIdx), 0, 0,1200,700, null);
	}
	
}
