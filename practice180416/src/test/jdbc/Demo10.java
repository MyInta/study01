package test.jdbc;

//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//import java.io.Reader;
import java.sql.Blob;
//import java.sql.Clob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * 测试BLOB大文本的读取与输出
 * @author 银涛
 *
 */
public class Demo10 {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01","root","13201230");
//			ps = conn.prepareStatement("insert into t_user(username,pwd,headImg) values (?,?,?)");
//			ps.setString(1, "图片1");
//			ps.setInt(2, 789465);
//			ps.setBlob(3, new FileInputStream("F:/图片/用途/JAVA相关/solar/星系01-1.jpg"));
//			ps.execute();
			
			ps = conn.prepareStatement("select * from t_user where id=22009");
			rs = ps.executeQuery();//读取 返回数据集
			while(rs.next()) {	//迭代数据集
				Blob c = rs.getBlob("headImg");
				is = c.getBinaryStream();	//将BLOB以输入流流形式重新获得
				os = new FileOutputStream("F:/图片/用途/JAVA相关/solar/星系JDBC01-1.jpg");
				byte[] temp = new byte[1024];
				int len = 0;
				//使用类似IO流读取方法
				while(-1!=(len = is.read(temp))) {
					os.write(temp,0,len);
				}
				os.flush();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(os!=null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			if(is!=null) {
					try {
						is.close();
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
