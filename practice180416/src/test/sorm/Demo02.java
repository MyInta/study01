package test.sorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 使用Map封装一组数据
 * 
 * @author 银涛
 *
 */
public class Demo02 {
	/*
	 * 使用map封装一条信息
	 */
	public static void test01() {
		Connection conn = JDBCUtil2.getMysqlConn();
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		Map<String,Object> map = new HashMap<>();
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id=?");
			ps.setInt(1, 1);
			rs = ps.executeQuery();

			while(rs.next()) {
				map.put("empname", rs.getObject(1));
				map.put("salary", rs.getObject(2));
				map.put("age", rs.getObject(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.close(conn, ps, rs);
		}
		//System.out.println(map.get("empname")+"--"+map.get("salary")+"--"+map.get("age"));
		//遍历map
		for(String key:map.keySet()) {
			System.out.println(key+"--"+map.get(key));
		}
	}
	
	/*
	 * 使用List封装多条信息
	 */
	public static void test02() {
		Connection conn = JDBCUtil2.getMysqlConn();
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		List<Map<String,Object>> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Map<String,Object> map = new HashMap<>();
				map.put("empname", rs.getObject(1));
				map.put("salary", rs.getObject(2));
				map.put("age", rs.getObject(3));
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.close(conn, ps, rs);
		}
		//遍历List再遍历Map
		for(Map<String,Object> temp:list) {

			for(String key:temp.keySet()) {
				System.out.print(key+"--"+temp.get(key)+"\t");
			}
			System.out.println();
		}
	}
	
	/*
	 * 使用Map封装map的多条信息
	 */
	public static void test03() {
		Connection conn = JDBCUtil2.getMysqlConn();
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		Map<Integer,Map<String,Object>> maps = new HashMap<>();
		try {
			ps = conn.prepareStatement("select empname,salary,age,id from emp where id>?");
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Map<String,Object> row = new HashMap<>();
				row.put("empname", rs.getObject(1));
				row.put("salary", rs.getObject(2));
				row.put("age", rs.getObject(3));
				
				maps.put(rs.getInt(4), row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.close(conn, ps, rs);
		}
		for(Integer id:maps.keySet()) {
				for(String key:maps.get(id).keySet()) {
					System.out.print(key+"--"+maps.get(id).get(key)+"\t");
				}
				System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {
		test03();
	}
}
