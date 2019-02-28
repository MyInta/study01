package sorm.core;
/**
 * 负责java数据类型与数据库数据类型互相转换
 * @author 银涛
 *
 */
public interface TypeConvertor {
	
	/**
	 * 将数据库数据类型转换成java数据库 数据类型
	 * @param columnType	数据库的数据类型
	 * @return	java的数据类型
	 */
	public String databaseType2JavaType(String columnType);

	/**
	 * 将java数据类型转换成数据库数据类型
	 * @param javaDataType	java数据类型
	 * @return	数据库类型
	 */
	public String javaType2DatabaseType(String javaDataType);
}
