package test.jdbc;
/**
 * 一个典型的使用封装后的JDBC
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;


public class Demo11 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = (Connection) JDBCUtil.getMysqlConn();
			
//			ps = conn.prepareStatement("select * from t_user where id=22009");
//			rs = ps.executeQuery();//读取 返回数据集
			ps = conn.prepareStatement("insert into t_user(username,pwd) values('陈文',?)");
			ps.setInt(1, 514514);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, ps, rs);
		}
	}
}
