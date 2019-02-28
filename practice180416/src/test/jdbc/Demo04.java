package test.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * ����ResultSet�Ļ����÷�
 * @author ����
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			
			String sql = "select * from t_user where id>?";	//ռλ��
			ps = conn.prepareStatement(sql);
			//����ʹ��setObject�����������
			ps.setInt(1, 2);	//��id����2�Ķ���ʾ����
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"--->"+rs.getString(2)+"---->"+rs.getString(3));
			}
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
