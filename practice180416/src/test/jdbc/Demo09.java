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
 * 测试CLOB大文本的读取
 * @author 银涛
 *
 */
public class Demo09 {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reader r = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
			ps = conn.prepareStatement("select * from t_user where id=?");
			ps.setInt(1, 22007);
			rs = ps.executeQuery();//读取 返回数据集
			while(rs.next()) {	//迭代数据集
				Clob c = rs.getClob("info");
				r = c.getCharacterStream();	//将CLOB以流形式重新获得
				int temp =0;
				//使用类似IO流读取方法
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
