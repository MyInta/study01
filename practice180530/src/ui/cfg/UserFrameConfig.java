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
	 * ȷ����ť
	 */
	private JButton btnOk = new JButton("ȷ��"); 
	/**
	 * ȡ����ť
	 */
	private JButton btnCancel = new JButton("ȡ��"); 
	/**
	 * Ӧ�ð�ť
	 */
	private JButton btnUsing = new JButton("Ӧ��"); 
	/**
	 * ��ť�����ı�����
	 */
	private TextCtrl[] keyTexts = new TextCtrl[8];
	/**
	 * ��������������ʾ�Ĵ�����Ϣ
	 */
	private JLabel errorMsg = new JLabel();
	/**
	 * Ƥ���б�
	 */
	private JList skinList = null;
	/**
	 * Ƥ��Ԥ�����
	 */
	private JPanel skinView = null;
	/**
	 * Ƥ������
	 */
	private DefaultListModel skinData = new DefaultListModel();
	/**
	 * ��Ϸ������
	 */
	private GameControl gameControl;
	/**
	 * ��������ı���ͼƬ
	 */
	private static final Image IMG_PSP = new ImageIcon("data/psp.jpg").getImage();
	/**
	 * ������������
	 */
	private static final String[] METHOD_NAMES = {
			"keyRight","keyUp","keyLeft","keyDown",
			"keyFunLeft","keyFunUp","keyFunRight","keyFunDown"
	};
	/**
	 * ���ݴ洢·��
	 */
	private static final String PATH="data/control.dat";
	/**
	 * ������
	 * @param gameControl ��Ϸ������
	 */
	public UserFrameConfig(GameControl gameControl) {
		//�����Ϸ����������
		this.gameControl = gameControl;
		//���ò��ֹ�����Ϊ���߽粼�֡�
		this.setLayout(new BorderLayout());
		//��ʼ�����������
		this.initKeyTexts();
		//��������
		this.add(createMainPanel(),BorderLayout.CENTER);
		//��Ӱ�ť���
		this.add(createButtonPanel(), BorderLayout.SOUTH);
		//���ò������촰�ڴ�С
		this.setResizable(false);
		//���ô��ڴ�С
		this.setSize(800,478);
		//����
		FrameUtil.setFrameCenter(this);
	}
	/**
	 * ��ʼ�����������
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
	 * ������ť���
	 * @return
	 */
	private JPanel createButtonPanel() {
		//������ť��壬����ʽ���֡�
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.errorMsg.setForeground(java.awt.Color.red);
		jp.add(this.errorMsg);
		//��ȷ����ť�����¼�����
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
		//��ȡ����ť���Ӽ����¼�
		this.btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				gameControl.setOver();
			}
		});
		jp.add(this.btnCancel);
		//��Ӧ�ð�ť���Ӽ����¼�
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
	 * ���������
	 * @return
	 */
	private JTabbedPane createMainPanel() {
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("��������", this.createControlPanel());
		jtp.addTab("Ƥ������", this.createSkinPanel());
		return jtp;
	}
	/**
	 * ���Ƥ�����
	 * @return
	 */
	private Component createSkinPanel() {
		JPanel skinJP = new JPanel(new BorderLayout());
		//TODO �������
		this.skinData.addElement("111");
		this.skinData.addElement("222");
		this.skinData.addElement("333");
		this.skinData.addElement("444");
		this.skinList = new JList(this.skinData);
		
		this.skinView = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				//TODO Ƥ��������Ҫ����
				g.drawImage(IMG_PSP,0,0,null);
			}
		};
		skinJP.add(new JScrollPane(this.skinList),BorderLayout.WEST);
		skinJP.add(this.skinView,BorderLayout.CENTER);
		
		return skinJP;
	}
	/**
	 * ��ҿ����������
	 * @return
	 */
	private JPanel createControlPanel() {
		JPanel ctrJP = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(IMG_PSP,0,0,null);
			}
		};
		//���ò��ֹ�����
		ctrJP.setLayout(null);
		for (int i = 0; i <8; i++) {
			ctrJP.add(keyTexts[i]);
		}
		return ctrJP;
	}
	
	/**
	 * д����Ϸ����
	 */
	private boolean writeConfig() {
		HashMap<Integer,String> keySet = new HashMap<Integer,String>();
		for (int i = 0; i < this.keyTexts.length; i++) {
			int keyCode = this.keyTexts[i].getKeyCode();
			if(0==keyCode) {
				this.errorMsg.setText("���󰴼�");
				return false;
			}
			keySet.put(keyCode, this.keyTexts[i].getMethodName());
		}
		//TODO Ӳ���� �����û�������ظ���������쳣
		if(8!=keySet.size()) {//��Ϊ�õ�HashMap�����ظ����ǣ��ܹ�8������һ�ظ���С��8
			this.errorMsg.setText("�ظ�����");
			return false;
		}
		ObjectOutputStream oos =null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(PATH));
			oos.writeObject(keySet);
//			System.out.println("д��ɹ�");
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
