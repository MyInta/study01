package sorm.core;
/**
 * ����java�������������ݿ��������ͻ���ת��
 * @author ����
 *
 */
public interface TypeConvertor {
	
	/**
	 * �����ݿ���������ת����java���ݿ� ��������
	 * @param columnType	���ݿ����������
	 * @return	java����������
	 */
	public String databaseType2JavaType(String columnType);

	/**
	 * ��java��������ת�������ݿ���������
	 * @param javaDataType	java��������
	 * @return	���ݿ�����
	 */
	public String javaType2DatabaseType(String javaDataType);
}
