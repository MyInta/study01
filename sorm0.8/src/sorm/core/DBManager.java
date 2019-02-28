package sorm.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import sorm.bean.Configuration;

/**
 * ����������Ϣ��ά�����Ӷ���Ĺ����������ӳع��ܣ�
 * @author ����
 *
 */
public class DBManager {
	private static Configuration conf;
	
	static {//��̬�����
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setUsingDB(pros.getProperty("usingDB"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
		
	}
	
	/**
	 * ����Configuration����
	 * @return
	 */
	public static Configuration getConf() {
		return conf;
	}
	
	/**
	 * ��ȡConnection����
	 * @return
	 */
	public static Connection getConn() {
		try {
			//����������
			Class.forName(conf.getDriver());
			//��������
			return (Connection) DriverManager.getConnection(conf.getUrl(),
					conf.getUser(),conf.getPwd());	//ֱ���������ӡ����������ӳش������Ч��
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	/**
	 * �����µ�Connection����
	 * @return
	 */
	public static Connection creatConn() {
		try {
			//����������
			Class.forName(conf.getDriver());
			//��������
			return (Connection) DriverManager.getConnection(conf.getUrl(),
					conf.getUser(),conf.getPwd());	//ֱ���������ӡ����������ӳش������Ч��
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	/**
	 * �رմ����Connection��PreparedStatement��ResultSet����
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement ps,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �رմ����Connection��PreparedStatement����
	 * @param conn
	 * @param ps
	 */
	public static void close(Connection conn,PreparedStatement ps) {
		
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �رմ����InputStream��OutputStream����
	 * @param is
	 * @param os
	 */
	public static void close(InputStream is,OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
