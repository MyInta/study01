package review_test02_server;

import java.util.HashMap;
import java.util.Map;

/**
 * ������
 * servlet����
 * 
 * @author ����
 *
 */
public class ServletContext {
	//��װservlet��ǩ�ڵ���Ϣ
	public Map<String,String> servlet;
	//��װmapping��ǩ�ڵ���Ϣ
	public Map<String,String> mapping;
	/**
	 * ��������ʼ��
	 */
	public ServletContext() {
		servlet = new HashMap<>();
		mapping = new HashMap<>();
	}
	public Map<String, String> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
	
	
}
