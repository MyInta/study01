package test.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * ����PreparedStatement�Ļ����÷�
 * @author ����
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			
			String sql = "insert into t_user (username,pwd,regTime) values (?,?,?)";	//ռλ��
			ps = conn.prepareStatement(sql);
			//����ʹ��setObject�����������
			ps.setString(1, "����");
			ps.setString(2, "5555");
			ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			
			System.out.println("����һ�м�¼");
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
