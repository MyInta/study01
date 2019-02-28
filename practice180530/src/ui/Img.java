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
	 * 图片路径
	 */
	private static final String GRAPHICS_PATH = "graphics/";
	/**
	 * 图片路径子文件夹
	 */
	private static final String DEFAULT_PATH = "default/";
	/**
	 * 个人签名
	 */
	public static Image SIGN =null;
	/**
	 * 窗口图片
	 */
	public static Image WINDOW = null;
	/**
	 * 数字图片 260 36
	 */
	public static Image NUMBER =null;
	/**
	 * 矩形值槽
	 */
	public static Image RECT =null;
	/**
	 * 数据库窗口标题图片
	 */
	public static Image DB =null;
	/**
	 * 本地记录标题
	 */
	public static Image DISK = null;
	/**
	 * 游戏方块图片
	 */
	public static Image ACT = null;
	/**
	 * 等级标题图片
	 */
	public static Image LEVEL = null;
	/**
	 * 分数窗口标题（分数）
	 */
	public static Image POINT = null;
	/**
	 * 分数窗口标题（消行）
	 */
	public static Image REMOVELINE = null;
	/**
	 * 阴影
	 */
	public static Image SHADOW = null;
	/**
	 * 暂停
	 */
	public static Image PAUSE = null;
	/**
	 * 开始按钮
	 */
	public static ImageIcon BTN_START = null;
	/**
	 * 设置按钮
	 */
	public static ImageIcon BTN_CONFIG = null;
	/**
	 * 下一个图片的数组
	 */
	public static Image[] NEXT_ACT=null;
	/**
	 * 背景图片表
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
		// 下一个方块
		NEXT_ACT = new Image[GameConfig.getSystemConfig().getTypeConfig().size()];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			// 取得对应的下一个图片
			NEXT_ACT[i] = new ImageIcon(skinPath+"game/" + i + ".png").getImage();
		}
		// 遍历背景图片数组
		File dir = new File(skinPath+"background");
		// 获取子目录
		File[] files = dir.listFiles();
		BG_LIST = new ArrayList<>();
		for (File file : files) {
			// 为了获得非文件夹的背景图片
			if (!file.isDirectory()) {
				BG_LIST.add(new ImageIcon(file.getPath()).getImage());
			}
		}
	}
}
