package sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * 存储表结构的信息
 * @author 银涛
 *
 */
public class TableInfo {
	
	/**
	 * 表名
	 */
	private String tname;
	
	/**
	 * 所有字段信息
	 */
	private Map<String,ColumnInfo> columns;
	
	/**
	 * 唯一主键（目前我们只处理表中有且只有一个主键的情况）
	 */
	private ColumnInfo onlyPrikey;
	
	/**
	 * 联合主键，在这里存储
	 */
	private List<ColumnInfo> priKeys;

	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPrikey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPrikey = onlyPrikey;
	}

	public TableInfo(String tname,  List<ColumnInfo> priKeys,Map<String, ColumnInfo> columns) {
		super();
		this.tname = tname;
		this.priKeys = priKeys;
		this.columns = columns;
	}





	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPrikey() {
		return onlyPrikey;
	}

	public void setOnlyPrikey(ColumnInfo onlyPrikey) {
		this.onlyPrikey = onlyPrikey;
	}
	
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}


	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}


	public TableInfo() {
	}
}
