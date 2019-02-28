package programTest01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 自定义ProStudent类，属性含name姓名 no班级号 score成绩
 * 将ProStudent对象放入List里面，计算对应的每个班级总分和平均成绩
 * 思路：
 * 面向对象+分拣存储
 * 
 * @author 银涛
 *
 */
public class ProMap001 {
	public static void main(String[] args) {
		//1、考试
		List<ProStudent> stuList = exam();
		//2、分析成绩
		Map<String,ProClassRoom> map = count(stuList);
		//3、查看成绩
		view(map);
	}
	/**
	 * 查看每个班的总分和平均分
	 */
	public static void view(Map<String,ProClassRoom> map) { 
		Set<String> keys = map.keySet();
		Iterator<String> keysIter = keys.iterator();
		while(keysIter.hasNext()) {
			String no = keysIter.next();
			ProClassRoom room = map.get(no);
			//查看总分，计算平均分
			double total = room.getTotal();
			double ave = total/room.getStuList().size();
			System.out.println(no+"-->"+total+"-->"+ave);
		}
	}
	/**
	 *统计分析 学生列表，分门别列将学生信息归到对应班级，返回班级map
	 *1、面向对象
	 *2、分拣存储
	 */
	public static Map<String,ProClassRoom> count(List<ProStudent> list){
		Map<String,ProClassRoom> map = new HashMap<String,ProClassRoom>();
		//1、遍历考试班级内的学生列表
		for(ProStudent stu:list) {
			String no = stu.getNo();	//班级编号
			double score = stu.getScore();	//成绩
			//2、分拣，是否存在该编号班级
			//不存在，创建班级
			ProClassRoom room = map.get(no);
			if(null==room) {
				room = new ProClassRoom();
				map.put(no, room);
			}
			//存在，放入学生
			room.getStuList().add(stu);	//放入学生
			room.setTotal(room.getTotal()+score);	//计算总分
		}
		return map;
	}
	
	/**
	 * 模拟考试 测试数据放置于List中
	 * 如果结合数据库JDBC的知识，应该可以实现大规模数据的处理
	 */
	public static List<ProStudent> exam(){
		List<ProStudent> list = new ArrayList<ProStudent>();
		//存放学生成绩等信息
		list.add(new ProStudent("张楚馨","a",80));
		list.add(new ProStudent("王思聪","b",99));
		list.add(new ProStudent("潘敏霞","a",77));
		list.add(new ProStudent("王珂","a",88));
		list.add(new ProStudent("刘雷璐","c",97));
		list.add(new ProStudent("陈文","b",66));
		list.add(new ProStudent("牛琦","c",78));
		return list;
	}
}
