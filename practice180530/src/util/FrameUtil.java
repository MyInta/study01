package util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * ���߷���
 * @author ����
 *
 */
public class FrameUtil {
	
	/**
	 * ���ô��ھ���
	 * @param jf
	 */
	public static void setFrameCenter(JFrame jf) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//���Ե������ʾ��Ļ�ĳߴ�
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width-jf.getWidth())>>1;
		int y = ((screen.height-jf.getHeight())>>1)-32;//ע��>>1������ŵüӣ���������λ�ƴ��򿿺�
		jf.setLocation(x, y);
	}
}
