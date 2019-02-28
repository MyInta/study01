package ui.cfg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.GameControl;
import util.FrameUtil;

public class JFrameSavePoint extends JFrame{
	
	/**
	 * 确定键 
	 */
	private JButton btnOk = null;
	
	private JLabel lbPoint=null;
	
	private JTextField txName=null;
	
	private JLabel errMsg=null;
	
	private GameControl gameControl=null;
	
	public JFrameSavePoint(GameControl gameControl) {
		this.gameControl = gameControl;
		//设置标题
		this.setTitle("保存记录");
		//设置窗口尺寸
		this.setSize(256, 128);
		//设置窗口位置居中显示
		FrameUtil.setFrameCenter(this);
		//设置窗口为不可拉伸状态
		this.setResizable(false);
		//设置边界布局
		this.setLayout(new BorderLayout());
		//初始化保存界面控件
		this.createCom();
		//给保存界面空间增加监听
		this.createAction();
	}
	/**
	 * 显示窗口
	 */
	public void showPoint(int point) {
		this.lbPoint.setText("您的得分是："+point);
		this.setVisible(true);
	}
	/**
	 * 创建事件监听
	 */
	private void createAction() {
		//给确定按钮增加事件监听
		this.btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO 还可以有其他文字限制
				//获取错误信息的内容
				String name = txName.getText();
				//检验错误信息的格式是否匹配需求
				if(name.length()>16||name.trim().equals("")) {
					errMsg.setText("请输入16位内的有效名称");
				}else {
					setVisible(false);
					gameControl.savePoint(name);
				}
			}
		});
	}
	/**
	 * 初始化控件
	 */
	private void createCom() {
		//流式布局，将标签放置在面板靠左
		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//创建分数标签
		this.lbPoint = new JLabel();
		//面板上增加分数按钮
		north.add(lbPoint);
		//创建错误信息控件
		this.errMsg =new JLabel();
		this.errMsg.setForeground(Color.red);
		//面板上增加错误信息
		north.add(this.errMsg);
		//将按钮面板放置到窗口，并布局到北边（上面）
		this.add(north, BorderLayout.NORTH);
		//流式布局，将标签放置在面板靠左
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//创建名字文本域
		this.txName = new JTextField(10);
		//面板上增加名字标签
		center.add(new JLabel("您的名字"));
		//并加上名字的文本域
		center.add(this.txName);
		//将按钮面板放置到窗口，并布局到北边（上面）
		this.add(center, BorderLayout.CENTER);
		//流式布局，将按钮放置在按钮面板中心
		JPanel  south =new JPanel(new FlowLayout(FlowLayout.CENTER));
		//创建确定按钮
		this.btnOk = new JButton("确定");
		//面板上增加确定按钮
		south.add(btnOk);
		//将按钮面板放置到窗口，并布局到南边（下面）
		this.add(south,BorderLayout.SOUTH);
	}
}
