package test.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.jdbc.Connection;

/**
 * 测试java.sql.Date,Time,Timestamp的基本用法
 * @author 银涛
 *
 */
public class Demo06 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			ps = conn.prepareStatement("insert into t_user(username,pwd,regTime) values (?,?,?)");
			ps.setObject(1, "Aaron");
			ps.setObject(2, "66588");
			//java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			//ps.setDate(3, date);
			//使用Timestamp可以显示到时分秒，而前面的Date则只会显示到日期日，剩余时间被默认为零。
			Timestamp ts = new Timestamp(System.currentTimeMillis()+200000000);
			ps.setTimestamp(3, ts);
			ps.execute();
			System.out.println("插入成功一个数据");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
