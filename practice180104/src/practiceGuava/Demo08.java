package practiceGuava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

/**
 * 双键的Map-->Table-->rowKey +columnKey+value
 * 1、方法 		形式：【学生-课程-成绩】
 * 所有行数据：cellSet()
 * 所有的学生：rowKeySet()
 * 所有课程：columKeySet()
 * 所有的成绩：values()
 * 学生对应课程：rowMap()+get(学生)
 * 					row(学生)
 * 课程对应的学生：columnMap+get(课程)
 * 					column(课程)
 * @author 银涛
 *
 */
public class Demo08 {

	public static void main(String[] args) {
		Table<String,String,Integer> tables = HashBasedTable.create();
		//测试数据
		tables.put("inta", "javase", 98);
		tables.put("陈文", "化学", 99);
		tables.put("牛琦", "化学", 99);
		tables.put("杨伟峰", "javase", 60);
		tables.put("杨伟峰", "化学", 60);
		//所有数据
		Set<Cell<String,String,Integer>> cells = tables.cellSet();
		for(Cell<String,String,Integer> temp:cells) {
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
		System.out.println("=====按学生查看成绩========");//展示 【学生 课程名称】
		System.out.print("学生\t");
		Set<String> course = tables.columnKeySet();
		for(String strStu:course) {
			System.out.print(strStu+"\t");
		}
		System.out.println();
		//所有的学生
		Set<String> stu = tables.rowKeySet();
		for(String strStu:stu) {
			System.out.print(strStu+"\t");
			Map<String,Integer> scores= tables.row(strStu);//不用担心重复V，因为该Map存储的是特定学生下，课程K与课程成绩V
			//遍历课程得到对应成绩
			for(String str:course) {
				System.out.print(scores.get(str)+"\t");
			}
			System.out.println();
		}
		
		System.out.println("=====按课程查看学生成绩========");//展示 【学生 课程名称】
		System.out.print("课程\t");
		Set<String> stu2 = tables.rowKeySet();
		for(String cours:stu2) {
			System.out.print(cours+"\t");
		}
		System.out.println();
		//所有的课程
		Set<String> cours = tables.columnKeySet();
		for(String strCours:cours) {
			System.out.print(strCours+"\t");
			Map<String,Integer> scores= tables.column(strCours);
			//遍历学生得到对应成绩
			for(String str:stu2) {
				System.out.print(scores.get(str)+"\t");
			}
			System.out.println();
		}
		System.out.println("===========转换row和column顺序===========");
		Table<String,String,Integer> tables2 = Tables.transpose(tables);
		Set<Cell<String,String,Integer>> cells2 = tables2.cellSet();
		for(Cell<String,String,Integer> temp:cells2) {
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
	}

}
