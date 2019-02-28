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
	 * ȷ���� 
	 */
	private JButton btnOk = null;
	
	private JLabel lbPoint=null;
	
	private JTextField txName=null;
	
	private JLabel errMsg=null;
	
	private GameControl gameControl=null;
	
	public JFrameSavePoint(GameControl gameControl) {
		this.gameControl = gameControl;
		//���ñ���
		this.setTitle("�����¼");
		//���ô��ڳߴ�
		this.setSize(256, 128);
		//���ô���λ�þ�����ʾ
		FrameUtil.setFrameCenter(this);
		//���ô���Ϊ��������״̬
		this.setResizable(false);
		//���ñ߽粼��
		this.setLayout(new BorderLayout());
		//��ʼ���������ؼ�
		this.createCom();
		//���������ռ����Ӽ���
		this.createAction();
	}
	/**
	 * ��ʾ����
	 */
	public void showPoint(int point) {
		this.lbPoint.setText("���ĵ÷��ǣ�"+point);
		this.setVisible(true);
	}
	/**
	 * �����¼�����
	 */
	private void createAction() {
		//��ȷ����ť�����¼�����
		this.btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO ��������������������
				//��ȡ������Ϣ������
				String name = txName.getText();
				//���������Ϣ�ĸ�ʽ�Ƿ�ƥ������
				if(name.length()>16||name.trim().equals("")) {
					errMsg.setText("������16λ�ڵ���Ч����");
				}else {
					setVisible(false);
					gameControl.savePoint(name);
				}
			}
		});
	}
	/**
	 * ��ʼ���ؼ�
	 */
	private void createCom() {
		//��ʽ���֣�����ǩ��������忿��
		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//����������ǩ
		this.lbPoint = new JLabel();
		//��������ӷ�����ť
		north.add(lbPoint);
		//����������Ϣ�ؼ�
		this.errMsg =new JLabel();
		this.errMsg.setForeground(Color.red);
		//��������Ӵ�����Ϣ
		north.add(this.errMsg);
		//����ť�����õ����ڣ������ֵ����ߣ����棩
		this.add(north, BorderLayout.NORTH);
		//��ʽ���֣�����ǩ��������忿��
		JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//���������ı���
		this.txName = new JTextField(10);
		//������������ֱ�ǩ
		center.add(new JLabel("��������"));
		//���������ֵ��ı���
		center.add(this.txName);
		//����ť�����õ����ڣ������ֵ����ߣ����棩
		this.add(center, BorderLayout.CENTER);
		//��ʽ���֣�����ť�����ڰ�ť�������
		JPanel  south =new JPanel(new FlowLayout(FlowLayout.CENTER));
		//����ȷ����ť
		this.btnOk = new JButton("ȷ��");
		//���������ȷ����ť
		south.add(btnOk);
		//����ť�����õ����ڣ������ֵ��ϱߣ����棩
		this.add(south,BorderLayout.SOUTH);
	}
}
