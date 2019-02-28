package review_120;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试前面的学生类和教室类，以及对应班级学生总成绩和平均分
 * @author 银涛
 *
 */
public class TestRoomStudent {
	public static void main(String[] args) {
		TestRoomStudent trs = new TestRoomStudent();
		//1、考试
		List<Student> stuList = trs.exam();
		// 2、分析成绩
		Map<String, MyRoom> map = trs.count(stuList);
		// 3、查看成绩（总分、平均分）
		trs.view(map);
	}
	
	/**
	 * 针对获取到的班级信息（对应考试后的学生情况）分析出学生总成绩以及平均成绩
	 */
	public void view(Map<String,MyRoom> map) {
		//获取map里面的key的集合
		Set<String> keySet = map.keySet();
		//遍历set数组需要用到迭代器
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			MyRoom room = map.get(key);
			System.out.println(key+"班级的学生总成绩为:"+room.getTolScore());
			System.out.println(key+"班级的学生平均成绩为:"+room.getTolScore()/(room.getStuList().size()));
		}
	}
	
	/**
	 * 获取测试信息后，将信息里面的学生整理到各自班级
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
				//如果教室为空，则创建一个新教室,并放入map中
				room = new MyRoom(no);
				map.put(no, room);
			}
			//如果存在，则继续，加入学生元素以及修正总成绩
			room.getStuList().add(stu);
			room.setTolScore(room.getTolScore()+score);
		}
		return map;
	}
	
	/**
	 * 获取考试时候得到的学生列表
	 * @return
	 */
	public List<Student> exam() {
		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student("科研班","Inta",100));
		stuList.add(new Student("励志班","Lucy",80));
		stuList.add(new Student("科研班","Honey",90));
		stuList.add(new Student("科研班","Kimmy",70));
		stuList.add(new Student("励志班","Tom",85));
		return stuList;
	}
}
