package sorm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import po.Emp;
import sorm.bean.ColumnInfo;
import sorm.bean.TableInfo;
import sorm.utils.JDBCUtils;
import sorm.utils.ReflectUtils;
import vo.EmpVO;

/**
 * 负责针对MySQL数据库的查询
 * @author 银涛
 *
 */
public class MySqlQuery extends Query{

	public static void testDML() {
		Emp e = new Emp();
		e.setId(7);
		e.setEmpname("test07");
		e.setSalary(40000.00);
		e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
		
		new MySqlQuery().update(e,new String[] {"empname","salary"});
//		new MySqlQuery().delete(e);
//		new MySqlQuery().insert(e);
	}
	
	public static void testQueryRows() {
		List<Emp> list = new MySqlQuery().queryRows("select id,empname,age,salary from emp where age>? and salary>?",
				Emp.class, new Object[] {10,15000.00});
		for(Emp e:list) {
			System.out.println(e.getEmpname()+"--"+e.getAge()+"--"+e.getSalary());
		}
		
		String sql2 = "select e.id,e.empname,e.salary+e.bonus 'xinzi',e.age,d.dname 'deptName',d.address 'deptAddr' from emp e " + 
				"join dept d on e.deptId=d.id";
		List<EmpVO> list2 = new MySqlQuery().queryRows(sql2,EmpVO.class, null);
		
		for(EmpVO e:list2) {
			System.out.println(e.getEmpname()+"-"+e.getDeptAddr()+"-"+e.getDeptName());
		}
	}

	public static void main(String[] args) {
//		Object obj = new MySqlQuery().queryValue("select count(*) from emp where salary>?", new Object[] {10000});
//		Number num = new MySqlQuery().queryNumber("select count(*) from emp where salary>?", new Object[] {10000});
//		System.out.println(num);
//		System.out.println(obj);
//		testQueryRows();
	}

	
	@Override
	public Object queryPagenate(int pageNum, int size) {
		return null;
	}
	
}