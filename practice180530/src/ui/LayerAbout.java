package ui;

import java.awt.Graphics;

/**
 * 签字面板
 * (调试阶段在游戏右下角)
 * @author 银涛
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
