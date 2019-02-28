package test.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * 测试PreparedStatement的基本用法
 * @author 银涛
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			
			String sql = "insert into t_user (username,pwd,regTime) values (?,?,?)";	//占位符
			ps = conn.prepareStatement(sql);
			//可以使用setObject方法处理参数
			ps.setString(1, "李四");
			ps.setString(2, "5555");
			ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			
			System.out.println("插入一行记录");
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
