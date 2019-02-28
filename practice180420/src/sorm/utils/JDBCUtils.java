package sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装了JDBC查询常用的操作
 * @author 银涛
 *
 */
public class JDBCUtils {
	
	/**
	 * 给sql设参
	 * @param ps	预编译sql语句对象
	 * @param params	参数
	 */
	public static void handleParams(PreparedStatement ps,Object[] params) {
		
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				try {
					ps.setObject(1+i, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}	//注意因为ps.setObject的第一个参数指第几个，以1开始计
			}
		}
	}
}
