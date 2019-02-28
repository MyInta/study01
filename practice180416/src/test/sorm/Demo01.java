package test.sorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 使用Object[]封装一组数据
 * 使用List<Object[]>存储多组数据	
 * @author 银涛
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Connection conn = JDBCUtil2.getMysqlConn();
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<Object[]>list = new ArrayList<>();
		try {
//			ps = conn.prepareStatement("select empname,salary,age from emp where id=?");
			ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
			ps.setInt(1, 1);
			rs = ps.executeQuery();

			while(rs.next()) {
				Object[] objs = new Object[3];	//一个Object数组就封装了一条记录
				//System.out.println(rs.getString(1)+"--"+rs.getString(2)+"---"+rs.getString(3));
				objs[0] = rs.getString(1);
				objs[1] = rs.getString(2);
				objs[2] = rs.getString(3);
				
				list.add(objs);
			}
			//使用遍历
//			for(Object temp:objs) {
//				System.out.print(temp+"\t");
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil2.close(conn, ps, rs);
		}
		//System.out.println(objs[0]+"--"+objs[1]+"--"+objs[2]);
		for(Object[] objs:list) {
			System.out.println(objs[0]+"--"+objs[1]+"--"+objs[2]);
		}
	}
}
