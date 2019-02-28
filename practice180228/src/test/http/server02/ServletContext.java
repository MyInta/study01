package test.http.server02;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 * @author 银涛
 *
 */
public class ServletContext {
	//为每个servlet取个别名
	//Login -->LonginServlet
	private Map<String,String> servlet;
	//url-->login
	private Map<String,String> mapping;
	public ServletContext() {
		servlet = new HashMap<String,String>();
		mapping = new HashMap<String,String>();
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
