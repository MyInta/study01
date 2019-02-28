package ui.cfg;

import javax.swing.JFrame;

import config.FrameConfig;
import config.GameConfig;
import util.FrameUtil;

public class JFrameGame extends JFrame{
	
	public JFrameGame(JPanelGame panelGame) {
		//�����Ϸ����
		FrameConfig fcf = GameConfig.getFrameConfig();
		//���ñ���
		this.setTitle(fcf.getTitle());
		//����Ĭ�Ϲر�(����ر�)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڴ�С
		this.setSize(fcf.getWidth(), fcf.getHeight());
		//�������û��ı䴰�ڴ�С
		this.setResizable(false);
		//���þ��� �Ȼ�þ������(���Ϊ��FrameUtil��װ�˷���)
		FrameUtil.setFrameCenter(this);
		//����Ĭ��panel
		this.setContentPane(panelGame);
		//Ĭ�ϴ�����ʾ
		this.setVisible(true);
	}
	
}
