package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import config.DataInterfaceConfig;
import config.GameConfig;
import dao.Data;
import dto.GameDto;
import dto.Player;
import service.GameService;
import service.IGameService;
import ui.cfg.JFrameGame;
import ui.cfg.JFrameSavePoint;
import ui.cfg.JPanelGame;
import ui.cfg.UserFrameConfig;

/**
 * ������Ҽ����¼� ���ƻ��� ������Ϸ
 * 
 * @author ����
 *
 */
public class GameControl {

	/**
	 * ���ݷ��ʽӿ�A
	 */
	private Data dataA;
	/**
	 * ���ݷ��ʽӿ�B
	 */
	private Data dataB;
	/**
	 * ��Ϸ�߼���
	 */
	private IGameService gameService;
	/**
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;
	/**
	 * ��Ϸ���ƴ���
	 */
	private UserFrameConfig frameConfig;
	/**
	 * �����������
	 */
	private JFrameSavePoint frameSavePoint;
	/**
	 * ��Ϸ��Ϊ����
	 */
	private Map<Integer, Method> actionList;
	/**
	 * ��Ϸ����Դ
	 */
	private GameDto dto = null;
	/**
	 * ��Ϸ�߳�
	 */
	private Thread gameThread = null;

	// JPanelGame panelGame, GameService gameService
	public GameControl() {
		// ��������Դ
		this.dto = new GameDto();
		// ������Ϸ�߼��飨������Ϸ���ݣ�
		this.gameService = new GameService(dto);
		// ������ݽӿ�A����
		dataA = createDataObject(GameConfig.getDataConfig().getDataA());
		// �������ݿ��¼����Ϸ
		this.dto.setDbRecord(dataA.loadData());
		// �����ݽӿ�B��ñ��ش��̼�¼
		dataB = createDataObject(GameConfig.getDataConfig().getDataB());
		// ���ñ��ش��̼�¼����Ϸ
		this.dto.setDiskRecord(dataB.loadData());
		// ������Ϸ���
		this.panelGame = new JPanelGame(this, dto);
		// ��ȡ�û���������
		this.setControlConfig();
		// ��ʼ���û����ƴ���
		this.frameConfig = new UserFrameConfig(this);
		// ��ʼ�������û���������
		this.frameSavePoint = new JFrameSavePoint(this);
		// ��ʼ����Ϸ�����ڣ���װ��Ϸ���
		new JFrameGame(panelGame);
		// try {
		// actionList.put(37, this.gameService.getClass().getMethod("keyLeft"));// ��
		// actionList.put(38, this.gameService.getClass().getMethod("keyUp"));// ��
		// actionList.put(39, this.gameService.getClass().getMethod("keyRight"));// ��
		// actionList.put(40, this.gameService.getClass().getMethod("keyDown"));// ��
		// actionList.put(107, this.gameService.getClass().getMethod("testLevelUp"));//
		// �Ӻ�keycode107
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * ��ȡ�û���������
	 */
	private void setControlConfig() {
		// �����������뷽������ӳ������
		this.actionList = new HashMap<Integer, Method>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data/control.dat"));
			HashMap<Integer, String> cfgSet = (HashMap<Integer, String>) ois.readObject();
			Iterator<Entry<Integer, String>> it = cfgSet.entrySet().iterator();
			Entry<Integer, String> entry = null;
			while (it.hasNext()) {
				entry = it.next();
				actionList.put(entry.getKey(), this.gameService.getClass().getMethod(entry.getValue(), null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != ois) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private Data createDataObject(DataInterfaceConfig cfg) {
		try {
			// ��������
			Class<?> cls = Class.forName(cfg.getClassName());
			// ��ù�����
			Constructor<?> ctr = cls.getConstructor(HashMap.class);
			// ��������
			return (Data) ctr.newInstance(cfg.getParam());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ������ҿ�������������������Ϊ
	 * 
	 * @param keyCode
	 */
	public void actionByKeyCode(int keyCode) {
		try {
			if (!actionList.containsKey(keyCode)) {
				return;
			}
			this.actionList.get(keyCode).invoke(this.gameService);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.panelGame.repaint();
	}

	/**
	 * ��ʾ��ҿ��ƴ���
	 */
	public void showUserConfig() {
		this.frameConfig.setVisible(true);
	}

	/**
	 * �Ӵ��ڹر��¼�
	 */
	public void setOver() {
		// ���¾۽�����Ϸ���
		this.panelGame.repaint();
		// ��ȡ�µ���Ϸ��������
		this.setControlConfig();
	}

	/**
	 * ��ʼ��ť�¼�
	 */
	public void start() {
		//��尴ť����Ϊ���ɵ��
		this.panelGame.buttonSwitch(false);
		//�ر��������ര�ڣ��Է����� �ֱ�ر����ô��ںͱ��洰��
		this.frameConfig.setVisible(false);
		this.frameSavePoint.setVisible(false);
		//��Ϸ���ݳ�ʼ��
		this.gameService.startGame();
		//�����̶߳���
		this.gameThread= new MainThread();
		//�����߳�
		this.gameThread.start();
		//ˢ�»���
		this.panelGame.repaint();
	}
	/**
	 * �����������
	 */
	public void savePoint(String name) {
		//����һ���µ���Ҷ���
		Player pla = new Player(name,this.dto.getNowPoint());
		//��������ݴ��뵽���ݿ�ͱ��ش���
		this.dataA.saveData(pla);
		this.dataB.saveData(pla);
		//�����ݿ�����Ϣ��¼����Ϸ��,(ˢ����Ϸ�������ݿ�)
		this.dto.setDbRecord(dataA.loadData());
		this.dto.setDiskRecord(dataB.loadData());
		//ˢ�»���
		this.panelGame.repaint();
	}
	/**
	 * ��Ϸ����֮��Ĵ��� ��ʾ��ҷ����ǼǴ���
	 */
	private void afterLose() {
		//��ʾ����÷ִ���(���ж��Ƿ�������,Ĭ��falseû���ף�ֻ��û���׵ķ������Ա��棡)
		if(!this.dto.isCheat()) {
			this.frameSavePoint.showPoint(this.dto.getNowPoint());
		}
		//�ǰ�ť���Ե��
		this.panelGame.buttonSwitch(true);
	}
	/**
	 * ��Ϸ�߳� �ڲ���
	 * @author ����
	 *
	 */
	private class MainThread extends Thread{
		@Override
		public void run() {
			//�ж��Ƿ�Ϊ����״̬
			while (dto.isStart()) {
				try {
					// �߳�˯��
					Thread.sleep(dto.getSleepTime());
					// �����ͣ����ô��ִ������Ϊ
					if(dto.isPause()) {
						continue;
					}
					// ��������,��Ϸ����Ϊ
					gameService.mainAction();
					// ˢ�»���
					panelGame.repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			afterLose();
		}
	}
}
