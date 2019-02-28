package review_test02_server;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 * servlet容器
 * 
 * @author 银涛
 *
 */
public class ServletContext {
	//填装servlet标签内的信息
	public Map<String,String> servlet;
	//填装mapping标签内的信息
	public Map<String,String> mapping;
	/**
	 * 构造器初始化
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
