package dao;

import java.util.List;

import dto.Player;

/**
 * 数据持久层接口
 * @author 银涛
 *
 */
public interface Data {
	
	/**
	 * 获得数据
	 * @return
	 */
	List<Player> loadData();
	
	/**
	 * 存储数据
	 * @param player
	 */
	void saveData(Player player);
}
