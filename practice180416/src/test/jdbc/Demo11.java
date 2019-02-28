package test.jdbc;
/**
 * һ�����͵�ʹ�÷�װ���JDBC
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
//			rs = ps.executeQuery();//��ȡ �������ݼ�
			ps = conn.prepareStatement("insert into t_user(username,pwd) values('����',?)");
			ps.setInt(1, 514514);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, ps, rs);
		}
	}
}
