package util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 工具方法
 * @author 银涛
 *
 */
public class FrameUtil {
	
	/**
	 * 设置窗口居中
	 * @param jf
	 */
	public static void setFrameCenter(JFrame jf) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//电脑等外端显示屏幕的尺寸
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width-jf.getWidth())>>1;
		int y = ((screen.height-jf.getHeight())>>1)-32;//注意>>1后的括号得加，四则运算位移次序靠后
		jf.setLocation(x, y);
	}
}
