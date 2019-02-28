package ui.cfg;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import control.GameControl;
import util.FrameUtil;

public class UserFrameConfig extends JFrame{
	
	/**
	 * 确定按钮
	 */
	private JButton btnOk = new JButton("确定"); 
	/**
	 * 取消按钮
	 */
	private JButton btnCancel = new JButton("取消"); 
	/**
	 * 应用按钮
	 */
	private JButton btnUsing = new JButton("应用"); 
	/**
	 * 按钮名称文本数组
	 */
	private TextCtrl[] keyTexts = new TextCtrl[8];
	/**
	 * 名称输入错误后显示的错误信息
	 */
	private JLabel errorMsg = new JLabel();
	/**
	 * 皮肤列表
	 */
	private JList skinList = null;
	/**
	 * 皮肤预览面板
	 */
	private JPanel skinView = null;
	/**
	 * 皮肤数据
	 */
	private DefaultListModel skinData = new DefaultListModel();
	/**
	 * 游戏控制器
	 */
	private GameControl gameControl;
	/**
	 * 设置里面的背景图片
	 */
	private static final Image IMG_PSP = new ImageIcon("data/psp.jpg").getImage();
	/**
	 * 按键方法名称
	 */
	private static final String[] METHOD_NAMES = {
			"keyRight","keyUp","keyLeft","keyDown",
			"keyFunLeft","keyFunUp","keyFunRight","keyFunDown"
	};
	/**
	 * 数据存储路径
	 */
	private static final String PATH="data/control.dat";
	/**
	 * 构造器
	 * @param gameControl 游戏控制器
	 */
	public UserFrameConfig(GameControl gameControl) {
		//获得游戏控制器对象
		this.gameControl = gameControl;
		//设置布局管理器为“边界布局”
		this.setLayout(new BorderLayout());
		//初始化按键输入框
		this.initKeyTexts();
		//添加主面板
		this.add(createMainPanel(),BorderLayout.CENTER);
		//添加按钮面板
		this.add(createButtonPanel(), BorderLayout.SOUTH);
		//设置不能拉伸窗口大小
		this.setResizable(false);
		//设置窗口大小
		this.setSize(800,478);
		//居中
		FrameUtil.setFrameCenter(this);
	}
	/**
	 * 初始化按键输入框
	 */
	private void initKeyTexts() {
		int x = 20;
		int y = 100;
		int w = 64;
		int h = 20;
		for (int i = 0; i < 4; i++) {
			keyTexts[i] = new TextCtrl(x,y,w,h,METHOD_NAMES[i]);
			y+=32;
		}
		x = 700;
		y = 100;
		for (int i = 4; i < 8; i++) {
			keyTexts[i] = new TextCtrl(x,y,w,h,METHOD_NAMES[i]);
			y+=32;
		}
		ObjectInputStream ois =null;
		try {
			ois = new ObjectInputStream(new FileInputStream(PATH));
			HashMap<Integer,String> cfgSet = (HashMap<Integer, String>) ois.readObject();
			Iterator<Entry<Integer,String>> it = cfgSet.entrySet().iterator();
			Entry<Integer,String> entry =null;
			while(it.hasNext()) {
				entry = it.next();
				for(TextCtrl tc:keyTexts) {
					if(tc.getMethodName().equals(entry.getValue())) {
						tc.setKeyCode(entry.getKey());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(null!=ois) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 创建按钮面板
	 * @return
	 */
	private JPanel createButtonPanel() {
		//创建按钮面板，“流式布局”
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.errorMsg.setForeground(java.awt.Color.red);
		jp.add(this.errorMsg);
		//给确定按钮增加事件监听
		this.btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(writeConfig()) {
					setVisible(false);
					gameControl.setOver();
				}
			}
		});
		jp.add(this.btnOk);
		//给取消按钮增加监听事件
		this.btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				gameControl.setOver();
			}
		});
		jp.add(this.btnCancel);
		//给应用按钮增加监听事件
		this.btnUsing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				writeConfig();
			}
		});
		jp.add(this.btnUsing);
		return jp;
	}

	/**
	 * 创建主面板
	 * @return
	 */
	private JTabbedPane createMainPanel() {
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("控制设置", this.createControlPanel());
		jtp.addTab("皮肤设置", this.createSkinPanel());
		return jtp;
	}
	/**
	 * 玩家皮肤面板
	 * @return
	 */
	private Component createSkinPanel() {
		JPanel skinJP = new JPanel(new BorderLayout());
		//TODO 添加内容
		this.skinData.addElement("111");
		this.skinData.addElement("222");
		this.skinData.addElement("333");
		this.skinData.addElement("444");
		this.skinList = new JList(this.skinData);
		
		this.skinView = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				//TODO 皮肤设置需要更换
				g.drawImage(IMG_PSP,0,0,null);
			}
		};
		skinJP.add(new JScrollPane(this.skinList),BorderLayout.WEST);
		skinJP.add(this.skinView,BorderLayout.CENTER);
		
		return skinJP;
	}
	/**
	 * 玩家控制设置面板
	 * @return
	 */
	private JPanel createControlPanel() {
		JPanel ctrJP = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(IMG_PSP,0,0,null);
			}
		};
		//设置布局管理器
		ctrJP.setLayout(null);
		for (int i = 0; i <8; i++) {
			ctrJP.add(keyTexts[i]);
		}
		return ctrJP;
	}
	
	/**
	 * 写入游戏配置
	 */
	private boolean writeConfig() {
		HashMap<Integer,String> keySet = new HashMap<Integer,String>();
		for (int i = 0; i < this.keyTexts.length; i++) {
			int keyCode = this.keyTexts[i].getKeyCode();
			if(0==keyCode) {
				this.errorMsg.setText("错误按键");
				return false;
			}
			keySet.put(keyCode, this.keyTexts[i].getMethodName());
		}
		//TODO 硬编码 控制用户输入键重复的情况报异常
		if(8!=keySet.size()) {//因为用的HashMap当键重复覆盖，总共8个键，一重复就小于8
			this.errorMsg.setText("重复按键");
			return false;
		}
		ObjectOutputStream oos =null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(PATH));
			oos.writeObject(keySet);
//			System.out.println("写入成功");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(null!=oos) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		this.errorMsg.setText(null);
		return true;
	}
}
