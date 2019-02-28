package ui.cfg;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.FrameConfig;
import config.GameConfig;
import config.LayerConfig;
import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import ui.Img;
import ui.Layer;

public class JPanelGame extends JPanel{
	
	private static final int BTN_SIZE_W = GameConfig.getFrameConfig().getButtonConfig().getButtonW();
	
	private static final int BTN_SIZE_H = GameConfig.getFrameConfig().getButtonConfig().getButtonH();
	
	private List<Layer> layers = null;
	
	private JButton btnStart;
	
	private JButton btnConfig;
	
	private GameControl gameControl =null;
	
	public JPanelGame(GameControl gameControl,GameDto dto) {
		//连接游戏控制器
		this.gameControl = gameControl;
		//设置布局管理器
		this.setLayout(null);
		//初始化组件
		this.initComponent();
		//初始化层
		this.initLayer(dto);
		//安装键盘监听器
		this.addKeyListener(new PlayerControl(gameControl));
	}

	/**
	 * 初始化组件
	 */
	private void initComponent() {
		//初始化开始按钮
		this.btnStart = new JButton(Img.BTN_START);
		//设置开始按钮位置
		this.btnStart.setBounds(
				GameConfig.getFrameConfig().getButtonConfig().getStartX(),
				GameConfig.getFrameConfig().getButtonConfig().getStartY(),
				BTN_SIZE_W,BTN_SIZE_H);
		//设置开始按钮事件监听
		this.btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameControl.start();
				//返回焦点
				requestFocus();
			}
		});
		//添加按钮到面板
		this.add(btnStart);
		//初始化设置按钮
		this.btnConfig = new JButton(Img.BTN_CONFIG);
		//设置设置按钮位置
		this.btnConfig.setBounds(
				GameConfig.getFrameConfig().getButtonConfig().getUserConfigX(),
				GameConfig.getFrameConfig().getButtonConfig().getUserConfigY(),
				BTN_SIZE_W, BTN_SIZE_H);
		//设置设置按钮事件监听
		this.btnConfig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameControl.showUserConfig();
			}
		});
		// 添加按钮到面板
		this.add(btnConfig);
	}
	
	/**
	 * 层初始化
	 */
	private void initLayer(GameDto dto) {
		try {
			//获得游戏配置
			FrameConfig fcf = GameConfig.getFrameConfig();
			//获得层配置
			List<LayerConfig> layersCfg = fcf.getLayerConfig();
			//创建游戏层数组
			layers = new  ArrayList<>(layersCfg.size());
			//创建所有层对象
			for(LayerConfig layerCfg:layersCfg) {
				//获得镜像对象
				Class<?> clz = Class.forName(layerCfg.getClassName());
				//获得构造器
				Constructor<?> construct = clz.getConstructor(int.class,int.class,int.class,int.class);
				//调用构造器创建对象
				Layer layer = (Layer) construct.newInstance(
						layerCfg.getX(),layerCfg.getY(),layerCfg.getW(),layerCfg.getH()
						);
				//设置游戏数据对象
				layer.setDto(dto);
				//将创建的Layer对象放入集合
				layers.add(layer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		lays = new Layer[] {
//				new LayerBackground(0,0,0,0),
//				new LayerDataBase(40,32,334,279),
//				new LayerDisk(40,343,334,279),
//				new LayerGame(414,32,334,590),
//				new LayerButton(788,32,334,124),
//				new LayerNext(788,188,176,148),
//				new LayerLevel(964,188,158,148),
//				new LayerPoint(788,368,334,200)
//		};
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//调用基类方法
		super.paintComponent(g);//SWING内部机制，不加图片显示可能会有问题
		//绘制游戏界面
		for(int i=0;i<layers.size();layers.get(i++).paint(g));
	}
	/**
	 * 控制按钮是否可点击
	 */
	public void buttonSwitch(boolean onOff) {
		this.btnConfig.setEnabled(onOff);
		this.btnStart.setEnabled(onOff);
	}
	
}
