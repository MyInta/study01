package test.jdbc;
/**
 * JDBC����Ĺ��ܼ���
 * @author ����
 *
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCUtil {
//	static Properties pros= null;
//	//ֻ����JDBCUtil��ʼ����ʱ�����һ��
//	static {
//		try {
//			pros = new Properties();
//			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	public static Connection getMysqlConn() {
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void close(Connection conn,PreparedStatement ps,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(InputStream is,OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
