package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mysql.jdbc.Connection;

import dto.Player;

public class DataBase implements Data{
	
	private final String driver;

	private final String dbUrl;
	
	private final String dbUser;
	
	private final String dbPwd;
	
	private static String LOAD_SQL="SELECT user_name,point FROM user_point "
			+ "WHERE type_id=1 ORDER BY point DESC LIMIT 5;";
	
	private static String SAVE_SQL="INSERT INTO user_point(user_name,point,type_id) VALUES(?,?,?);";
	
	public DataBase(HashMap<String,String> param) {
		this.driver = param.get("driver");
		this.dbUrl = param.get("dbUrl");
		this.dbUser = param.get("dbUser");
		this.dbPwd = param.get("dbPwd");
//		try {
//			Class.forName(param.get("driver"));
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	
	@Override
	public List<Player> loadData() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Player> players = new ArrayList<>();
		try {
			conn = (Connection) JDBCUtil.getMysqlConn(driver, dbUrl, dbUser, dbPwd);
			stmt = conn.prepareStatement(LOAD_SQL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				players.add(new Player(rs.getString(1),rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return players;
	}

	@Override
	public void saveData(Player player) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = (Connection) JDBCUtil.getMysqlConn(driver, dbUrl, dbUser, dbPwd);
			stmt = conn.prepareStatement(SAVE_SQL);
			stmt.setObject(1, player.getName());
			stmt.setObject(2, player.getPoint());
			stmt.setObject(3, 1);	//±Ì–Ú
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, stmt);
		}
	}
}
