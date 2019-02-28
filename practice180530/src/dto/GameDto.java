package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import config.GameConfig;
import entity.GameAct;
import util.GameFunction;

public class GameDto {
	
	/**
	 * 游戏宽度
	 */
	public static final int GAMEONE_W = GameConfig.getSystemConfig().getMaxX()+1;
	/**
	 * 游戏高度
	 */
	public static final int GAMEONE_H= GameConfig.getSystemConfig().getMaxY()+1;
	/**
	 * 数据库记录
	 */
	private List<Player> dbRecord;
	/**
	 * 本地记录
	 */
	private List<Player> diskRecord;
	/**
	 * 游戏地图
	 */
	private boolean[][] gameMap;
	/**
	 * 下落方块
	 */
	private GameAct gameAct;
	/**
	 * 下一个方块
	 */
	private int next;
	/**
	 * 等级
	 */
	private int nowLevel;
	/**
	 * 目前得分
	 */
	private int nowPoint;
	/**
	 * 消的行数
	 */
	private int nowRemoveLine;
	/**
	 * 游戏是否开始状态
	 */
	private boolean start;
	/**
	 * 阴影是否打开
	 */
	private boolean showShadow;
	/**
	 * 暂停
	 */
	private boolean pause;
	/**
	 * 作弊
	 */
	private boolean cheat;
	/**
	 * 睡眠时间（加速度）
	 */
	private long sleepTime;
	/**
	 * 构造函数
	 */
	public GameDto() {
		dtoInit();
	}
	
	/**
	 * dto初始化
	 */
	public void dtoInit() {
		//游戏地图重新绘制
		this.gameMap = new boolean[GAMEONE_W][GAMEONE_H];
		// 初始化所有游戏对象
		//初始化等级
		this.nowLevel=0;
		//初始化分数
		this.nowPoint=0;
		//初始化已删除行数
		this.nowRemoveLine=0;
		//初始化是否为暂停状态
		this.pause=false;
		//初始化是否作弊状态
		this.cheat=false;
		//初始化线程睡眠时间（加速度）
		this.sleepTime=GameFunction.getSleepTimeByLevel(nowLevel);
	}
	public List<Player> getDbRecord() {
		return dbRecord;
	}
	public void setDbRecord(List<Player> dbRecord) {
		this.dbRecord = setFillRecord(dbRecord);
	}
	public List<Player> getDiskRecord() {
		return diskRecord;
	}
	public void setDiskRecord(List<Player> diskRecord) {
		this.diskRecord = setFillRecord(diskRecord);
	}
	
	/**
	 * 添加玩家数据，若缺少则填空，并且降序排序这些数据
	 * @param players
	 * @return
	 */
	private List<Player> setFillRecord(List<Player> players) {
		//如果进来为空，则创建
		if(null==players) {
			players = new ArrayList<>();
		}
		//如果记录小于5，就加到5条为止
		while(players.size()<5) {
			players.add(new Player("NO DATA",0));
		}
		Collections.sort(players);
		return players;
	}
	
	public boolean[][] getGameMap() {
		return gameMap;
	}
	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}
	public GameAct getGameAct() {
		return gameAct;
	}
	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getNowLevel() {
		return nowLevel;
	}
	public void setNowLevel(int nowLevel) {
		this.nowLevel = nowLevel;
		//根据等级调整睡眠时间
		this.sleepTime = GameFunction.getSleepTimeByLevel(nowLevel);
	}
	public int getNowPoint() {
		return nowPoint;
	}
	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}
	public int getNowRemoveLine() {
		return nowRemoveLine;
	}
	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isShowShadow() {
		return showShadow;
	}

	public void changeShowShadow() {
		this.showShadow = !this.showShadow;
	}

	public boolean isPause() {
		return pause;
	}

	public void changePause() {
		this.pause = !this.pause;
	}

	public boolean isCheat() {
		return cheat;
	}

	public void setCheat(boolean cheat) {
		this.cheat = cheat;
	}

	public long getSleepTime() {
		return sleepTime;
	}
	
}
