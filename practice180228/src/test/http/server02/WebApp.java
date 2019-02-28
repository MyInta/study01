package test.http.server02;

import java.util.Map;

public class WebApp {
	private static ServletContext contxt;
	static {
		contxt = new ServletContext();
		Map<String,String> mapping = contxt.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		Map<String,String> servlet = contxt.getServlet();
		servlet.put("login", "test.http.server02.LoginServlet");
		servlet.put("register","test.http.server02.RegisterServlet");
	}
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(null==url||(url=url.trim()).equals("")) {
			return null;
		}
		//return contxt.getServlet().get(contxt.getMapping().get(url));	//?
		//根据字符串（完整路径） 创建对象
		String str = contxt.getServlet().get(contxt.getMapping().get(url));
		return (Servlet)Class.forName(str).newInstance();
	}
}
