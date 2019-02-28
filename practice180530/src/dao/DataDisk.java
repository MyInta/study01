package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import dto.Player;

public class DataDisk implements Data{
	
	//本地磁盘路径
	private final String filePath;
	//配合测试数据用
	/*public DataDisk() {
		filePath = "data/recode.dat";
	}*/
	public DataDisk(HashMap<String,String> param) {
		this.filePath = param.get("path");
	}
	
	@Override
	public List<Player> loadData() {
		List<Player> players = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filePath));
			players = (List<Player>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(ois);
		}
		return players;
	}

	@Override
	public void saveData(Player pla) {
		//先取出数据
		List<Player> players = this.loadData();
		//再追加记录
		players.add(pla);
		//判断是否超过六条记录，若超过，就去掉分数最低的。为了防止数据越来越大了
		if(players.size()>=6) {
			Collections.sort(players);
			players.remove(players.size()-1);
		}
		//重新写入
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filePath));
			oos.writeObject(players);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(oos);
		}
	}
	
	
	/*public static void main(String[] args) {
	 	//【测试查看本地磁盘内的数据信息】
		DataDisk test = new DataDisk();
		//先取出数据
		List<Player> players = test.loadData();
		for(Player temp:players) {
			System.out.println(temp.getName()+"----"+temp.getPoint());
		}
		//【测试修改本地磁盘内数据】
//		List<Player> players = new ArrayList<>();
//		//再追加记录
//		players.add(new Player("账号01",100));
//		players.add(new Player("账号02",80));
//		players.add(new Player("账号03",60));
//		//判断是否超过六条记录，若超过，就去掉分数最低的。为了防止数据越来越大了
//		if(players.size()>=6) {
//			Collections.sort(players);
//			players.remove(players.size()-1);
//		}
//		//重新写入
//		ObjectOutputStream oos = null;
//		try {
//			oos = new ObjectOutputStream(new FileOutputStream(test.filePath));
//			oos.writeObject(players);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(null!=oos) {
//				try {
//					oos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}*/
}

