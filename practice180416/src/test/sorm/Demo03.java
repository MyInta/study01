package test.sorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * ʹ��class����ʵ��JDBC
 * 
 * @author ����
 *
 */
public class Demo03 {
	/*
	 * ʹ��Emp��װһ����Ϣ
	 */
	public static void test01() {
		Connection conn = JDBCUtil2.getMysqlConn();
		PreparedStatement ps =null;
		ResultSet rs = null;
		Emp emp = null;
		
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id=?");
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			while(rs.next()) {
				emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.close(conn, ps, rs);
		}
		System.out.println(emp.getEmpname()+"--"+emp.getSalary()+"--"+emp.getAge());
	}
	
	/*
	 * ʹ��List<Emp>��װ������Ϣ
	 */
	public static void test02() {
		Connection conn = JDBCUtil2.getMysqlConn();
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		List<Emp>list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Emp emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.close(conn, ps, rs);
		}
		//����List
		for(Emp temp:list) {
			System.out.println(temp.getEmpname()+"--"+temp.getSalary()+"--"+temp.getAge());
		}
	}
	
	
	public static void main(String[] args) {
		//test01();
		test02();
	}
}
