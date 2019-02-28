package test.jdbc;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * ����CLOB���ı��Ĳ���
 * @author ����
 *
 */
public class Demo08 {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			ps = conn.prepareStatement("insert into t_user(username,pwd,info) values (?,?,?)");
			ps.setString(1, "С��");
			ps.setInt(2, 64652);
			//�����ı� ����һ ����·�� ע��CLOB����read��ʽ
			//ps.setClob(3, new FileReader(new File("F:/��Ƶ��ѧ/JAVA��ѧ/ѧϰ�ƻ�.txt")));

			//������ ֱ�Ӳ����ַ����Ļ���ʹ���ֽ�ת��
			ps.setClob(3, new InputStreamReader(new ByteArrayInputStream("woshiyigezifuchuan".getBytes())));
			
			
			ps.executeUpdate();
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
