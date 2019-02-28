package service;

import java.awt.Point;
import java.util.Map;
import java.util.Random;

import config.GameConfig;
import dto.GameDto;
import entity.GameAct;

/**
 * ҵ���߼�
 * 
 * @author ����
 *
 */
public class GameService implements IGameService {

	/**
	 * ��Ϸ���ݶ���
	 */
	private GameDto dto;

	/**
	 * ���������
	 */
	private Random random = new Random();

	/**
	 * ������������
	 */
	private static final int MAX_TYPE = GameConfig.getSystemConfig().getTypeConfig().size();
	/**
	 * ��������
	 */
	private static final int LEVEL_UP = GameConfig.getSystemConfig().getLevelUp();
	/**
	 * �������з�������
	 */
	private static final Map<Integer, Integer> PLUS_POINT = GameConfig.getSystemConfig().getPlusPoint();

	public GameService(GameDto dto) {
		this.dto =dto;
	}

	/**
	 * ���鷽������
	 */
	public boolean keyUp() {
		//��ͣ״̬
		if(this.dto.isPause()) {
			return false;
		}
		//�߳�������ֹ���������������ͻ�������ɹ�����״������
		synchronized(this.dto) {
			// ��ת
			this.dto.getGameAct().round(this.dto.getGameMap());
		}
		return true;
	}
	/**
	 * ���鷽������
	 */
	public boolean keyLeft() {
		//��ͣ״̬
		if (this.dto.isPause()) {
			return false;
		}
		synchronized(this.dto) {
			this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
		}
		return true;
	}
	/**
	 * ���鷽������
	 */
	public boolean keyRight() {
		//��ͣ״̬
		if (this.dto.isPause()) {
			return false;
		}
		synchronized(this.dto) {
			this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
		}
		return true;
	}
	/**
	 * ���鷽������
	 */
	public boolean keyDown() {
		//��ͣ״̬
		if (this.dto.isPause()) {
			return false;
		}
		synchronized(this.dto) {
		// ���������ƶ����ж��Ƿ��ƶ��ɹ�
		if (this.dto.getGameAct().move(0, 1, this.dto.getGameMap())) {
			return false;
		}
		// �����Ϸ��ͼ����
		boolean[][] map = this.dto.getGameMap();
		// ��÷������
		Point[] act = this.dto.getGameAct().getActPoints();
		// ������ѻ�����ͼ������
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		// �ж����У������㾭��ֵ
		int plusExp = this.plusExp();
		// �����������
		if (plusExp > 0) {
			// �Ӿ����ж�����������������������
			this.plusPoint(plusExp);
		}
		//ˢ���µķ���
		this.dto.getGameAct().init(this.dto.getNext());
		// ���������һ������
		this.dto.setNext(random.nextInt(MAX_TYPE));
		//�����Ϸ�Ƿ�ʧ��
		if(this.isLose()) {
			//������Ϸ
			this.dto.setStart(false);
		}
		}
		return true;
	}

	/**
	 * �����Ϸ�Ƿ��ܽ���
	 */
	private boolean isLose() {
		//������ڵķ���
		Point[] actPoints = this.dto.getGameAct().getActPoints();
		//������ڵ���Ϸ��ͼ
		boolean[][] map = this.dto.getGameMap();
		for(int i=0;i<actPoints.length;i++) {
			if(map[actPoints[i].x][actPoints[i].y]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �ӷ���������
	 * 
	 * @param plusExp ����������
	 */
	private void plusPoint(int plusExp) {
		int lv = this.dto.getNowLevel();
		int rmLine = this.dto.getNowRemoveLine();
		int point = this.dto.getNowPoint();
		if ((rmLine % LEVEL_UP + plusExp) >= LEVEL_UP) {
			this.dto.setNowLevel(++lv);
		}
		this.dto.setNowRemoveLine(rmLine + plusExp);
		this.dto.setNowPoint(point + PLUS_POINT.get(plusExp));
	}

	/**
	 * ���в���
	 */
	private int plusExp() {
		// �����Ϸ��ͼ
		boolean[][] map = this.dto.getGameMap();
		int exp = 0;
		// ɨ����Ϸ��ͼ���鿴�Ƿ��п�����
		for (int y = 0; y < GameDto.GAMEONE_H; y++) {
			// �ж��Ƿ������
			if (canRemoveLine(y, map)) {
				// ����
				this.removeLine(y, map);
				// ���Ӿ���ֵ
				exp++;
			}
		}
		return exp;
	}
	/**
	 * ���д���
	 * 
	 * @param y �б���
	 * @param map �ж�Ӧ��ά��������
	 */
	private void removeLine(int rowNumber, boolean[][] map) {
		for (int x = 0; x < GameDto.GAMEONE_W; x++) {
			for (int y = rowNumber; y > 0; y--) {
				map[x][y] = map[x][y - 1];
			}
			map[x][0] = false;
		}
	}

	/**
	 * �ж�Īһ���Ƿ����
	 * 
	 * @param y ���б���
	 * @param map �����ڵķ��������ά����
	 * @return
	 */
	private boolean canRemoveLine(int y, boolean[][] map) {
		// �����ڶ�ÿһ����Ԫ�����ɨ��
		for (int x = 0; x < GameDto.GAMEONE_W; x++) {
			if (!map[x][y]) {
				// �����һ����Ϊfalseֱ��������һ��
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean keyFunRight() {
		if(this.dto.isStart()) {
			this.dto.changePause();
		}
		return true;
	}

	@Override
	public boolean keyFunUp() {
		//������ף��ж���������״̬
		this.dto.setCheat(true);
		//���׼ӷ�����
		this.plusPoint(4);
		return true;
	}

	@Override
	public boolean keyFunLeft() {
		//��Ӱ����
		this.dto.changeShowShadow();
		return true;
	}

	@Override
	public boolean keyFunDown() {
		//��ͣ״̬
		if (this.dto.isPause()) {
			return false;
		}
		// ˲������ ʹ��whileһֱ�жϣ�ֱ�������½��˳�ѭ��
		while(!keyDown()) {}
		return true;
	}
	/**
	 * δ������Ϸ��ʱ�򣬲��������ʾ���飬�ʽ���һ�����dtoinit�ֳ������ֳ�ʼ��
	 */
	@Override
	public void startGame() {
		//��һ������next�ĳ�ʼ��
		this.dto.setNext(random.nextInt(MAX_TYPE));
		//����������ڷ���
		this.dto.setGameAct(new GameAct(random.nextInt(MAX_TYPE)));
		//����Ϸ״̬��Ϊ��ʼ
		this.dto.setStart(true);
		//dto��ʼ��
		this.dto.dtoInit();
	}

	@Override
	public void mainAction() {
		this.keyDown();
	}

	// /**
	// * ��������
	// * @param moveX
	// * @param moveY
	// * @return
	// */
	// private boolean canMove(int moveX,int moveY) {
	// Point[] nowPoints = this.dto.getGameAct().getActPoints();
	// for(int i=1;i<nowPoints.length;i++) {
	// int newX= nowPoints[i].x+moveX;
	// int newY= nowPoints[i].y+moveY;
	// if(newX<0||newX>9||newY<0||newY>17) {
	// return false;
	// }
	// }
	//
	// return true;
	// }
}
