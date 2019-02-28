package test.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Connection;

/**
 * ���Խ�����ȡ����������ת��Ϊlong�������͵Ļ����÷� ��ʽ��yyyy-MM-dd hh:mm:ss��
 * @author ����
 *
 */
public class Demo07 {
	/*
	 * �����ڱ�ʾ���ַ���ת��Ϊlong��������
	 */
	public static long strDate(String dateStr) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			ps = conn.prepareStatement("select * from t_user where regTime>? and regTime<?");
			java.sql.Date start = new java.sql.Date(strDate("2018-04-19 00:21:00"));
			java.sql.Date end = new java.sql.Date(strDate("2018-04-21 00:20:00"));
			ps.setObject(1, start);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"---"+rs.getString("username")+"---"+rs.getTimestamp("regTime"));
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
