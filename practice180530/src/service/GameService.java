package service;

import java.awt.Point;
import java.util.Map;
import java.util.Random;

import config.GameConfig;
import dto.GameDto;
import entity.GameAct;

/**
 * 业务逻辑
 * 
 * @author 银涛
 *
 */
public class GameService implements IGameService {

	/**
	 * 游戏数据对象
	 */
	private GameDto dto;

	/**
	 * 随机生成器
	 */
	private Random random = new Random();

	/**
	 * 方块种类数量
	 */
	private static final int MAX_TYPE = GameConfig.getSystemConfig().getTypeConfig().size();
	/**
	 * 升级行数
	 */
	private static final int LEVEL_UP = GameConfig.getSystemConfig().getLevelUp();
	/**
	 * 连续消行分数递增
	 */
	private static final Map<Integer, Integer> PLUS_POINT = GameConfig.getSystemConfig().getPlusPoint();

	public GameService(GameDto dto) {
		this.dto =dto;
	}

	/**
	 * 方块方向向上
	 */
	public boolean keyUp() {
		//暂停状态
		if(this.dto.isPause()) {
			return false;
		}
		//线程锁，防止方块与下落操作冲突而崩溃成怪物形状。。。
		synchronized(this.dto) {
			// 旋转
			this.dto.getGameAct().round(this.dto.getGameMap());
		}
		return true;
	}
	/**
	 * 方块方向向左
	 */
	public boolean keyLeft() {
		//暂停状态
		if (this.dto.isPause()) {
			return false;
		}
		synchronized(this.dto) {
			this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
		}
		return true;
	}
	/**
	 * 方块方向向右
	 */
	public boolean keyRight() {
		//暂停状态
		if (this.dto.isPause()) {
			return false;
		}
		synchronized(this.dto) {
			this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
		}
		return true;
	}
	/**
	 * 方块方向向下
	 */
	public boolean keyDown() {
		//暂停状态
		if (this.dto.isPause()) {
			return false;
		}
		synchronized(this.dto) {
		// 方块向下移动，判断是否移动成功
		if (this.dto.getGameAct().move(0, 1, this.dto.getGameMap())) {
			return false;
		}
		// 获得游戏地图对象
		boolean[][] map = this.dto.getGameMap();
		// 获得方块对象
		Point[] act = this.dto.getGameAct().getActPoints();
		// 将方块堆积到地图数组中
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		// 判断消行，并计算经验值
		int plusExp = this.plusExp();
		// 如果发生消行
		if (plusExp > 0) {
			// 加经验判断升级，若升级则升级操作
			this.plusPoint(plusExp);
		}
		//刷新新的方块
		this.dto.getGameAct().init(this.dto.getNext());
		// 随机生成下一个方块
		this.dto.setNext(random.nextInt(MAX_TYPE));
		//检查游戏是否失败
		if(this.isLose()) {
			//结束游戏
			this.dto.setStart(false);
		}
		}
		return true;
	}

	/**
	 * 检查游戏是否还能进行
	 */
	private boolean isLose() {
		//获得现在的方块
		Point[] actPoints = this.dto.getGameAct().getActPoints();
		//获得现在的游戏地图
		boolean[][] map = this.dto.getGameMap();
		for(int i=0;i<actPoints.length;i++) {
			if(map[actPoints[i].x][actPoints[i].y]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 加分升级操作
	 * 
	 * @param plusExp 新增消行数
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
	 * 消行操作
	 */
	private int plusExp() {
		// 获得游戏地图
		boolean[][] map = this.dto.getGameMap();
		int exp = 0;
		// 扫描游戏地图，查看是否有可消行
		for (int y = 0; y < GameDto.GAMEONE_H; y++) {
			// 判断是否可消行
			if (canRemoveLine(y, map)) {
				// 消行
				this.removeLine(y, map);
				// 增加经验值
				exp++;
			}
		}
		return exp;
	}
	/**
	 * 消行处理
	 * 
	 * @param y 行编码
	 * @param map 行对应二维方块数组
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
	 * 判断莫一行是否可消
	 * 
	 * @param y 该行编码
	 * @param map 该行内的方块坐标二维数组
	 * @return
	 */
	private boolean canRemoveLine(int y, boolean[][] map) {
		// 单行内对每一个单元格进行扫描
		for (int x = 0; x < GameDto.GAMEONE_W; x++) {
			if (!map[x][y]) {
				// 如果有一方格为false直接跳到下一行
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
		//如果作弊，判定处于作弊状态
		this.dto.setCheat(true);
		//作弊加分升级
		this.plusPoint(4);
		return true;
	}

	@Override
	public boolean keyFunLeft() {
		//阴影开关
		this.dto.changeShowShadow();
		return true;
	}

	@Override
	public boolean keyFunDown() {
		//暂停状态
		if (this.dto.isPause()) {
			return false;
		}
		// 瞬间下落 使用while一直判断，直到不能下降退出循环
		while(!keyDown()) {}
		return true;
	}
	/**
	 * 未开启游戏的时候，不让面板显示方块，故将下一块等与dtoinit分成两部分初始化
	 */
	@Override
	public void startGame() {
		//下一个方块next的初始化
		this.dto.setNext(random.nextInt(MAX_TYPE));
		//随机生成现在方块
		this.dto.setGameAct(new GameAct(random.nextInt(MAX_TYPE)));
		//把游戏状态设为开始
		this.dto.setStart(true);
		//dto初始化
		this.dto.dtoInit();
	}

	@Override
	public void mainAction() {
		this.keyDown();
	}

	// /**
	// * 做界面检测
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
