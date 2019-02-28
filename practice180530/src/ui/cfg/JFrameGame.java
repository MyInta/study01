package ui.cfg;

import javax.swing.JFrame;

import config.FrameConfig;
import config.GameConfig;
import util.FrameUtil;

public class JFrameGame extends JFrame{
	
	public JFrameGame(JPanelGame panelGame) {
		//获得游戏配置
		FrameConfig fcf = GameConfig.getFrameConfig();
		//设置标题
		this.setTitle(fcf.getTitle());
		//设置默认关闭(程序关闭)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小
		this.setSize(fcf.getWidth(), fcf.getHeight());
		//不允许用户改变窗口大小
		this.setResizable(false);
		//设置居中 先获得镜像对象(后改为用FrameUtil封装了方法)
		FrameUtil.setFrameCenter(this);
		//设置默认panel
		this.setContentPane(panelGame);
		//默认窗口显示
		this.setVisible(true);
	}
	
}
