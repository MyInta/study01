package sorm.core;

/**
 * 创建Query对象的工厂类
 * @author 银涛
 *
 */
public class QueryFactory {
	
	private static Query protypeObj;
	static {
		//加载指定的query类
		
		try {
			Class c = Class.forName(DBManager.getConf().getQueryClass());
			protypeObj = (Query) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private QueryFactory() {	//私有构造器
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
