package dao;

import java.util.List;

import dto.Player;

/**
 * ���ݳ־ò�ӿ�
 * @author ����
 *
 */
public interface Data {
	
	/**
	 * �������
	 * @return
	 */
	List<Player> loadData();
	
	/**
	 * �洢����
	 * @param player
	 */
	void saveData(Player player);
}
