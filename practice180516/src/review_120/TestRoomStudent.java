package review_120;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ����ǰ���ѧ����ͽ����࣬�Լ���Ӧ�༶ѧ���ܳɼ���ƽ����
 * @author ����
 *
 */
public class TestRoomStudent {
	public static void main(String[] args) {
		TestRoomStudent trs = new TestRoomStudent();
		//1������
		List<Student> stuList = trs.exam();
		// 2�������ɼ�
		Map<String, MyRoom> map = trs.count(stuList);
		// 3���鿴�ɼ����ܷ֡�ƽ���֣�
		trs.view(map);
	}
	
	/**
	 * ��Ի�ȡ���İ༶��Ϣ����Ӧ���Ժ��ѧ�������������ѧ���ܳɼ��Լ�ƽ���ɼ�
	 */
	public void view(Map<String,MyRoom> map) {
		//��ȡmap�����key�ļ���
		Set<String> keySet = map.keySet();
		//����set������Ҫ�õ�������
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			MyRoom room = map.get(key);
			System.out.println(key+"�༶��ѧ���ܳɼ�Ϊ:"+room.getTolScore());
			System.out.println(key+"�༶��ѧ��ƽ���ɼ�Ϊ:"+room.getTolScore()/(room.getStuList().size()));
		}
	}
	
	/**
	 * ��ȡ������Ϣ�󣬽���Ϣ�����ѧ���������԰༶
	 * @param stuList
	 * @return
	 */
	public Map<String,MyRoom> count(List<Student> stuList){
		Map<String,MyRoom> map = new HashMap<>();
		for(Student stu:stuList) {
			String no = stu.getNo();
			double score = stu.getScore();
			MyRoom room = map.get(no);
			if(null==room) {
				//�������Ϊ�գ��򴴽�һ���½���,������map��
				room = new MyRoom(no);
				map.put(no, room);
			}
			//������ڣ������������ѧ��Ԫ���Լ������ܳɼ�
			room.getStuList().add(stu);
			room.setTolScore(room.getTolScore()+score);
		}
		return map;
	}
	
	/**
	 * ��ȡ����ʱ��õ���ѧ���б�
	 * @return
	 */
	public List<Student> exam() {
		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student("���а�","Inta",100));
		stuList.add(new Student("��־��","Lucy",80));
		stuList.add(new Student("���а�","Honey",90));
		stuList.add(new Student("���а�","Kimmy",70));
		stuList.add(new Student("��־��","Tom",85));
		return stuList;
	}
}
