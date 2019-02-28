package test.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.jdbc.Connection;

/**
 * ����java.sql.Date,Time,Timestamp�Ļ����÷�
 * @author ����
 *
 */
public class Demo06 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			ps = conn.prepareStatement("insert into t_user(username,pwd,regTime) values (?,?,?)");
			ps.setObject(1, "Aaron");
			ps.setObject(2, "66588");
			//java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			//ps.setDate(3, date);
			//ʹ��Timestamp������ʾ��ʱ���룬��ǰ���Date��ֻ����ʾ�������գ�ʣ��ʱ�䱻Ĭ��Ϊ�㡣
			Timestamp ts = new Timestamp(System.currentTimeMillis()+200000000);
			ps.setTimestamp(3, ts);
			ps.execute();
			System.out.println("����ɹ�һ������");
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
