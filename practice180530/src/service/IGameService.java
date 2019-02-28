package service;


public interface IGameService {
	
	/**
	 * 方向键右
	 */
	public boolean keyRight();
	/**
	 * 方向键上
	 */
	public boolean keyUp();
	/**
	 * 方向键左
	 */
	public boolean keyLeft();
	/**
	 * 方向键下
	 */
	public boolean keyDown();
	/**
	 * 圆圈键
	 */
	public boolean keyFunRight();
	/**
	 * 三角键
	 */
	public boolean keyFunUp();
	/**
	 * 方块键
	 */
	public boolean keyFunLeft();
	/**
	 * 大叉键
	 */
	public boolean keyFunDown();
	/**
	 * 启动主线程开始游戏
	 */
	public void startGame();
	/**
	 * 游戏主要行为
	 */
	public void mainAction();
}
