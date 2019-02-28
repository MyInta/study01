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
	
	//���ش���·��
	private final String filePath;
	//��ϲ���������
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
		//��ȡ������
		List<Player> players = this.loadData();
		//��׷�Ӽ�¼
		players.add(pla);
		//�ж��Ƿ񳬹�������¼������������ȥ��������͵ġ�Ϊ�˷�ֹ����Խ��Խ����
		if(players.size()>=6) {
			Collections.sort(players);
			players.remove(players.size()-1);
		}
		//����д��
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
	 	//�����Բ鿴���ش����ڵ�������Ϣ��
		DataDisk test = new DataDisk();
		//��ȡ������
		List<Player> players = test.loadData();
		for(Player temp:players) {
			System.out.println(temp.getName()+"----"+temp.getPoint());
		}
		//�������޸ı��ش��������ݡ�
//		List<Player> players = new ArrayList<>();
//		//��׷�Ӽ�¼
//		players.add(new Player("�˺�01",100));
//		players.add(new Player("�˺�02",80));
//		players.add(new Player("�˺�03",60));
//		//�ж��Ƿ񳬹�������¼������������ȥ��������͵ġ�Ϊ�˷�ֹ����Խ��Խ����
//		if(players.size()>=6) {
//			Collections.sort(players);
//			players.remove(players.size()-1);
//		}
//		//����д��
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

