package service;


public interface IGameService {
	
	/**
	 * �������
	 */
	public boolean keyRight();
	/**
	 * �������
	 */
	public boolean keyUp();
	/**
	 * �������
	 */
	public boolean keyLeft();
	/**
	 * �������
	 */
	public boolean keyDown();
	/**
	 * ԲȦ��
	 */
	public boolean keyFunRight();
	/**
	 * ���Ǽ�
	 */
	public boolean keyFunUp();
	/**
	 * �����
	 */
	public boolean keyFunLeft();
	/**
	 * ����
	 */
	public boolean keyFunDown();
	/**
	 * �������߳̿�ʼ��Ϸ
	 */
	public void startGame();
	/**
	 * ��Ϸ��Ҫ��Ϊ
	 */
	public void mainAction();
}
