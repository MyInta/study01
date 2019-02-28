package test.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

/**
 * 测试Batch(批处理)的基本用法
 * @author 银涛
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			
			conn.setAutoCommit(false);//设置为手动提交
			long startTime = System.currentTimeMillis();
			stmt = conn.createStatement();
			for(int i=0;i<2000;i++) {
				stmt.addBatch("insert into t_user(username,pwd,regTime) values ('Inta"+i+"',456789,now())");
			}
			stmt.executeBatch();
			conn.commit();//提交
			long endTime = System.currentTimeMillis();
			System.out.println("插入表格信息，花费时间："+(startTime-endTime)/1000+"秒");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
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
