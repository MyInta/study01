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
 * 接受玩家键盘事件 控制画面 控制游戏
 * 
 * @author 银涛
 *
 */
public class GameControl {

	/**
	 * 数据访问接口A
	 */
	private Data dataA;
	/**
	 * 数据访问接口B
	 */
	private Data dataB;
	/**
	 * 游戏逻辑层
	 */
	private IGameService gameService;
	/**
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	/**
	 * 游戏控制窗口
	 */
	private UserFrameConfig frameConfig;
	/**
	 * 保存分数窗口
	 */
	private JFrameSavePoint frameSavePoint;
	/**
	 * 游戏行为控制
	 */
	private Map<Integer, Method> actionList;
	/**
	 * 游戏数据源
	 */
	private GameDto dto = null;
	/**
	 * 游戏线程
	 */
	private Thread gameThread = null;

	// JPanelGame panelGame, GameService gameService
	public GameControl() {
		// 创建数据源
		this.dto = new GameDto();
		// 创建游戏逻辑块（连接游戏数据）
		this.gameService = new GameService(dto);
		// 获得数据接口A对象
		dataA = createDataObject(GameConfig.getDataConfig().getDataA());
		// 设置数据库记录到游戏
		this.dto.setDbRecord(dataA.loadData());
		// 从数据接口B获得本地磁盘记录
		dataB = createDataObject(GameConfig.getDataConfig().getDataB());
		// 设置本地磁盘记录到游戏
		this.dto.setDiskRecord(dataB.loadData());
		// 创建游戏面板
		this.panelGame = new JPanelGame(this, dto);
		// 读取用户控制设置
		this.setControlConfig();
		// 初始化用户控制窗口
		this.frameConfig = new UserFrameConfig(this);
		// 初始化保存用户分数窗口
		this.frameSavePoint = new JFrameSavePoint(this);
		// 初始化游戏主窗口，安装游戏面板
		new JFrameGame(panelGame);
		// try {
		// actionList.put(37, this.gameService.getClass().getMethod("keyLeft"));// 左
		// actionList.put(38, this.gameService.getClass().getMethod("keyUp"));// 上
		// actionList.put(39, this.gameService.getClass().getMethod("keyRight"));// 右
		// actionList.put(40, this.gameService.getClass().getMethod("keyDown"));// 下
		// actionList.put(107, this.gameService.getClass().getMethod("testLevelUp"));//
		// 加号keycode107
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * 读取用户控制设置
	 */
	private void setControlConfig() {
		// 创建键盘码与方法名的映射数组
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
			// 获得类对象
			Class<?> cls = Class.forName(cfg.getClassName());
			// 获得构造器
			Constructor<?> ctr = cls.getConstructor(HashMap.class);
			// 创建对象
			return (Data) ctr.newInstance(cfg.getParam());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据玩家控制来决定上下左右行为
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
	 * 显示玩家控制窗口
	 */
	public void showUserConfig() {
		this.frameConfig.setVisible(true);
	}

	/**
	 * 子窗口关闭事件
	 */
	public void setOver() {
		// 重新聚焦回游戏板块
		this.panelGame.repaint();
		// 读取新的游戏按键配置
		this.setControlConfig();
	}

	/**
	 * 开始按钮事件
	 */
	public void start() {
		//面板按钮设置为不可点击
		this.panelGame.buttonSwitch(false);
		//关闭其他多余窗口，以防串流 分别关闭设置窗口和保存窗口
		this.frameConfig.setVisible(false);
		this.frameSavePoint.setVisible(false);
		//游戏数据初始化
		this.gameService.startGame();
		//创建线程对象
		this.gameThread= new MainThread();
		//启动线程
		this.gameThread.start();
		//刷新画面
		this.panelGame.repaint();
	}
	/**
	 * 保存分数操作
	 */
	public void savePoint(String name) {
		//创建一个新的玩家对象
		Player pla = new Player(name,this.dto.getNowPoint());
		//将玩家数据传入到数据库和本地磁盘
		this.dataA.saveData(pla);
		this.dataB.saveData(pla);
		//将数据库内信息记录到游戏中,(刷新游戏面板的数据库)
		this.dto.setDbRecord(dataA.loadData());
		this.dto.setDiskRecord(dataB.loadData());
		//刷新画面
		this.panelGame.repaint();
	}
	/**
	 * 游戏结束之后的处理 显示玩家分数登记窗口
	 */
	private void afterLose() {
		//显示保存得分窗口(先判断是否作弊了,默认false没作弊，只有没作弊的分数可以保存！)
		if(!this.dto.isCheat()) {
			this.frameSavePoint.showPoint(this.dto.getNowPoint());
		}
		//是按钮可以点击
		this.panelGame.buttonSwitch(true);
	}
	/**
	 * 游戏线程 内部类
	 * @author 银涛
	 *
	 */
	private class MainThread extends Thread{
		@Override
		public void run() {
			//判断是否为开启状态
			while (dto.isStart()) {
				try {
					// 线程睡眠
					Thread.sleep(dto.getSleepTime());
					// 如果暂停，那么不执行主行为
					if(dto.isPause()) {
						continue;
					}
					// 方块下落,游戏主行为
					gameService.mainAction();
					// 刷新画面
					panelGame.repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			afterLose();
		}
	}
}
