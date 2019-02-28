package sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * �洢��ṹ����Ϣ
 * @author ����
 *
 */
public class TableInfo {
	
	/**
	 * ����
	 */
	private String tname;
	
	/**
	 * �����ֶ���Ϣ
	 */
	private Map<String,ColumnInfo> columns;
	
	/**
	 * Ψһ������Ŀǰ����ֻ�����������ֻ��һ�������������
	 */
	private ColumnInfo onlyPrikey;
	
	/**
	 * ����������������洢
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
