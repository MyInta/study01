package test.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * ���Ը����ݿ�����
 * @author ����
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			
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
