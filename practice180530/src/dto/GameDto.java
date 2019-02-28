package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import config.GameConfig;
import entity.GameAct;
import util.GameFunction;

public class GameDto {
	
	/**
	 * ��Ϸ���
	 */
	public static final int GAMEONE_W = GameConfig.getSystemConfig().getMaxX()+1;
	/**
	 * ��Ϸ�߶�
	 */
	public static final int GAMEONE_H= GameConfig.getSystemConfig().getMaxY()+1;
	/**
	 * ���ݿ��¼
	 */
	private List<Player> dbRecord;
	/**
	 * ���ؼ�¼
	 */
	private List<Player> diskRecord;
	/**
	 * ��Ϸ��ͼ
	 */
	private boolean[][] gameMap;
	/**
	 * ���䷽��
	 */
	private GameAct gameAct;
	/**
	 * ��һ������
	 */
	private int next;
	/**
	 * �ȼ�
	 */
	private int nowLevel;
	/**
	 * Ŀǰ�÷�
	 */
	private int nowPoint;
	/**
	 * ��������
	 */
	private int nowRemoveLine;
	/**
	 * ��Ϸ�Ƿ�ʼ״̬
	 */
	private boolean start;
	/**
	 * ��Ӱ�Ƿ��
	 */
	private boolean showShadow;
	/**
	 * ��ͣ
	 */
	private boolean pause;
	/**
	 * ����
	 */
	private boolean cheat;
	/**
	 * ˯��ʱ�䣨���ٶȣ�
	 */
	private long sleepTime;
	/**
	 * ���캯��
	 */
	public GameDto() {
		dtoInit();
	}
	
	/**
	 * dto��ʼ��
	 */
	public void dtoInit() {
		//��Ϸ��ͼ���»���
		this.gameMap = new boolean[GAMEONE_W][GAMEONE_H];
		// ��ʼ��������Ϸ����
		//��ʼ���ȼ�
		this.nowLevel=0;
		//��ʼ������
		this.nowPoint=0;
		//��ʼ����ɾ������
		this.nowRemoveLine=0;
		//��ʼ���Ƿ�Ϊ��ͣ״̬
		this.pause=false;
		//��ʼ���Ƿ�����״̬
		this.cheat=false;
		//��ʼ���߳�˯��ʱ�䣨���ٶȣ�
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
	 * ���������ݣ���ȱ������գ����ҽ���������Щ����
	 * @param players
	 * @return
	 */
	private List<Player> setFillRecord(List<Player> players) {
		//�������Ϊ�գ��򴴽�
		if(null==players) {
			players = new ArrayList<>();
		}
		//�����¼С��5���ͼӵ�5��Ϊֹ
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
		//���ݵȼ�����˯��ʱ��
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
