package test.jdbc;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * 测试CLOB大文本的插入
 * @author 银涛
 *
 */
public class Demo08 {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			ps = conn.prepareStatement("insert into t_user(username,pwd,info) values (?,?,?)");
			ps.setString(1, "小红");
			ps.setInt(2, 64652);
			//插入文本 方法一 插入路径 注意CLOB后是read格式
			//ps.setClob(3, new FileReader(new File("F:/视频教学/JAVA教学/学习计划.txt")));

			//方法二 直接插入字符串的话，使用字节转化
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
