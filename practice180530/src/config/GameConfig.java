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
				//����XML��ȡ��
				SAXReader read = new SAXReader();
				// ��ȡXML�ļ�
				Document doc = read.read("data/cfg.xml");
				// ��ȡ�ļ��ĸ��ڵ� ��XML���������<game>
				Element game = doc.getRootElement();
				//�����������ö��� �ֱ��ȡԪ�ض���<frame><data><system>
				FRAME_CONFIG = new FrameConfig(game.element("frame"));
				//�������ݷ������ö���
				DATA_CONFIG = new DataConfig(game.element("data"));
				//����ϵͳ���ö���
				SYSTEM_CONFIG = new SystemConfig(game.element("system"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream("data/framcfg.dat"));
				//�����������ö���
				FRAME_CONFIG = (FrameConfig) ois.readObject();
				ois = new ObjectInputStream(new FileInputStream("data/datacfg.dat"));
				//�������ݷ������ö���
				DATA_CONFIG = (DataConfig) ois.readObject();
				ois = new ObjectInputStream(new FileInputStream("data/systemcfg.dat"));
				//����ϵͳ���ö���
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
	 * ������˽�л�
	 */
	private GameConfig() {}
	/**
	 * ��ô�������
	 * @return
	 */
	public static FrameConfig getFrameConfig() {
		return FRAME_CONFIG;
	}
	/**
	 * ������ݷ�������
	 * @return
	 */
	public static DataConfig getDataConfig() {
		return DATA_CONFIG;
	}
	/**
	 * ���ϵͳ����
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
