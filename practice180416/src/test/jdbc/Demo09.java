package test.jdbc;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * ����CLOB���ı��Ķ�ȡ
 * @author ����
 *
 */
public class Demo09 {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reader r = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			ps = conn.prepareStatement("select * from t_user where id=?");
			ps.setInt(1, 22007);
			rs = ps.executeQuery();//��ȡ �������ݼ�
			while(rs.next()) {	//�������ݼ�
				Clob c = rs.getClob("info");
				r = c.getCharacterStream();	//��CLOB������ʽ���»��
				int temp =0;
				//ʹ������IO����ȡ����
				while((temp = r.read())!=-1) {
					System.out.print((char)temp);
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(r!=null) {
					try {
						r.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
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
