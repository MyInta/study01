package sorm.core;

/**
 * ����Query����Ĺ�����
 * @author ����
 *
 */
public class QueryFactory {
	
	private static Query protypeObj;
	static {
		//����ָ����query��
		
		try {
			Class c = Class.forName(DBManager.getConf().getQueryClass());
			protypeObj = (Query) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private QueryFactory() {	//˽�й�����
	}
	
	public static Query createQuery() {
		try {
			return (Query) protypeObj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
