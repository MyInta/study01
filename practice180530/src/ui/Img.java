package ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import config.GameConfig;

public class Img {
	
	private Img() {}
	/**
	 * ͼƬ·��
	 */
	private static final String GRAPHICS_PATH = "graphics/";
	/**
	 * ͼƬ·�����ļ���
	 */
	private static final String DEFAULT_PATH = "default/";
	/**
	 * ����ǩ��
	 */
	public static Image SIGN =null;
	/**
	 * ����ͼƬ
	 */
	public static Image WINDOW = null;
	/**
	 * ����ͼƬ 260 36
	 */
	public static Image NUMBER =null;
	/**
	 * ����ֵ��
	 */
	public static Image RECT =null;
	/**
	 * ���ݿⴰ�ڱ���ͼƬ
	 */
	public static Image DB =null;
	/**
	 * ���ؼ�¼����
	 */
	public static Image DISK = null;
	/**
	 * ��Ϸ����ͼƬ
	 */
	public static Image ACT = null;
	/**
	 * �ȼ�����ͼƬ
	 */
	public static Image LEVEL = null;
	/**
	 * �������ڱ��⣨������
	 */
	public static Image POINT = null;
	/**
	 * �������ڱ��⣨���У�
	 */
	public static Image REMOVELINE = null;
	/**
	 * ��Ӱ
	 */
	public static Image SHADOW = null;
	/**
	 * ��ͣ
	 */
	public static Image PAUSE = null;
	/**
	 * ��ʼ��ť
	 */
	public static ImageIcon BTN_START = null;
	/**
	 * ���ð�ť
	 */
	public static ImageIcon BTN_CONFIG = null;
	/**
	 * ��һ��ͼƬ������
	 */
	public static Image[] NEXT_ACT=null;
	/**
	 * ����ͼƬ��
	 */
	public static List<Image> BG_LIST=null;
	
	static {
		setSkin(DEFAULT_PATH);
	}
	
	public static void setSkin(String path) {
		String skinPath = GRAPHICS_PATH+"/"+path;
		SIGN = new ImageIcon(skinPath+"string/sign3.png").getImage();
		WINDOW = new ImageIcon(skinPath+"window/Window.png").getImage();
		NUMBER = new ImageIcon(skinPath+"string/num.png").getImage();
		RECT = new ImageIcon(skinPath+"window/rect.png").getImage();
		DB = new ImageIcon(skinPath+"string/db.png").getImage();
		DISK = new ImageIcon(skinPath+"string/disk.png").getImage();
		ACT = new ImageIcon(skinPath+"game/rect.png").getImage();
		LEVEL = new ImageIcon(skinPath+"string/level.png").getImage();
		POINT = new ImageIcon(skinPath+"string/point.png").getImage();
		REMOVELINE = new ImageIcon(skinPath+"string/rmline.png").getImage();
		SHADOW = new ImageIcon(skinPath+"game/shadow.png").getImage();
		PAUSE = new ImageIcon(skinPath+"string/ItsOk.png").getImage();
		BTN_START = new ImageIcon(skinPath+"string/start.png");
		BTN_CONFIG = new ImageIcon(skinPath+"string/config.png");
		// ��һ������
		NEXT_ACT = new Image[GameConfig.getSystemConfig().getTypeConfig().size()];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			// ȡ�ö�Ӧ����һ��ͼƬ
			NEXT_ACT[i] = new ImageIcon(skinPath+"game/" + i + ".png").getImage();
		}
		// ��������ͼƬ����
		File dir = new File(skinPath+"background");
		// ��ȡ��Ŀ¼
		File[] files = dir.listFiles();
		BG_LIST = new ArrayList<>();
		for (File file : files) {
			// Ϊ�˻�÷��ļ��еı���ͼƬ
			if (!file.isDirectory()) {
				BG_LIST.add(new ImageIcon(file.getPath()).getImage());
			}
		}
	}
}
