package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	
	private static FrameConfig FRAME_CONFIG=null;

	private static DataConfig DATA_CONFIG=null;
	
	private static SystemConfig SYSTEM_CONFIG=null;
	
	private static boolean DEBUG=false;
	
	static {
		if(DEBUG) {
			try {
				//创建XML读取器
				SAXReader read = new SAXReader();
				// 读取XML文件
				Document doc = read.read("data/cfg.xml");
				// 获取文件的根节点 即XML配置里面的<game>
				Element game = doc.getRootElement();
				//创建界面配置对象 分别获取元素对象<frame><data><system>
				FRAME_CONFIG = new FrameConfig(game.element("frame"));
				//创建数据访问配置对象
				DATA_CONFIG = new DataConfig(game.element("data"));
				//创建系统配置对象
				SYSTEM_CONFIG = new SystemConfig(game.element("system"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("data/framcfg.dat"));
				//创建界面配置对象
				FRAME_CONFIG = (FrameConfig) ois.readObject();
				ois = new ObjectInputStream(new FileInputStream("data/datacfg.dat"));
				//创建数据访问配置对象
				DATA_CONFIG = (DataConfig) ois.readObject();
				ois = new ObjectInputStream(new FileInputStream("data/systemcfg.dat"));
				//创建系统配置对象
				SYSTEM_CONFIG=(SystemConfig) ois.readObject();
				
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
		
	}
	
	/**
	 * 构造器私有化
	 */
	private GameConfig() {}
	/**
	 * 获得窗口配置
	 * @return
	 */
	public static FrameConfig getFrameConfig() {
		return FRAME_CONFIG;
	}
	/**
	 * 获得数据访问配置
	 * @return
	 */
	public static DataConfig getDataConfig() {
		return DATA_CONFIG;
	}
	/**
	 * 获得系统配置
	 * @return
	 */
	public static SystemConfig getSystemConfig() {
		return SYSTEM_CONFIG;
	}
//	public static void main(String[] args) throws Exception{
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/framcfg.dat"));
//		oos.writeObject(getFrameConfig());
//		oos = new ObjectOutputStream(new FileOutputStream("data/systemcfg.dat"));
//		oos.writeObject(getSystemConfig());
//		oos = new ObjectOutputStream(new FileOutputStream("data/datacfg.dat"));
//		oos.writeObject(getDataConfig());
//		oos.close();
//	}
}
