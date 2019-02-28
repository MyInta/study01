package programTest01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * �Զ���ProStudent�࣬���Ժ�name���� no�༶�� score�ɼ�
 * ��ProStudent�������List���棬�����Ӧ��ÿ���༶�ֺܷ�ƽ���ɼ�
 * ˼·��
 * �������+�ּ�洢
 * 
 * @author ����
 *
 */
public class ProMap001 {
	public static void main(String[] args) {
		//1������
		List<ProStudent> stuList = exam();
		//2�������ɼ�
		Map<String,ProClassRoom> map = count(stuList);
		//3���鿴�ɼ�
		view(map);
	}
	/**
	 * �鿴ÿ������ֺܷ�ƽ����
	 */
	public static void view(Map<String,ProClassRoom> map) { 
		Set<String> keys = map.keySet();
		Iterator<String> keysIter = keys.iterator();
		while(keysIter.hasNext()) {
			String no = keysIter.next();
			ProClassRoom room = map.get(no);
			//�鿴�ܷ֣�����ƽ����
			double total = room.getTotal();
			double ave = total/room.getStuList().size();
			System.out.println(no+"-->"+total+"-->"+ave);
		}
	}
	/**
	 *ͳ�Ʒ��� ѧ���б����ű��н�ѧ����Ϣ�鵽��Ӧ�༶�����ذ༶map
	 *1���������
	 *2���ּ�洢
	 */
	public static Map<String,ProClassRoom> count(List<ProStudent> list){
		Map<String,ProClassRoom> map = new HashMap<String,ProClassRoom>();
		//1���������԰༶�ڵ�ѧ���б�
		for(ProStudent stu:list) {
			String no = stu.getNo();	//�༶���
			double score = stu.getScore();	//�ɼ�
			//2���ּ��Ƿ���ڸñ�Ű༶
			//�����ڣ������༶
			ProClassRoom room = map.get(no);
			if(null==room) {
				room = new ProClassRoom();
				map.put(no, room);
			}
			//���ڣ�����ѧ��
			room.getStuList().add(stu);	//����ѧ��
			room.setTotal(room.getTotal()+score);	//�����ܷ�
		}
		return map;
	}
	
	/**
	 * ģ�⿼�� �������ݷ�����List��
	 * ���������ݿ�JDBC��֪ʶ��Ӧ�ÿ���ʵ�ִ��ģ���ݵĴ���
	 */
	public static List<ProStudent> exam(){
		List<ProStudent> list = new ArrayList<ProStudent>();
		//���ѧ���ɼ�����Ϣ
		list.add(new ProStudent("�ų�ܰ","a",80));
		list.add(new ProStudent("��˼��","b",99));
		list.add(new ProStudent("����ϼ","a",77));
		list.add(new ProStudent("����","a",88));
		list.add(new ProStudent("�����","c",97));
		list.add(new ProStudent("����","b",66));
		list.add(new ProStudent("ţ��","c",78));
		return list;
	}
}
