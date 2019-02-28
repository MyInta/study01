package review_test02_servlet;

import review_test02_server.Request;
import review_test02_server.Response;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Request req, Response resp) throws Exception {
		resp.println("<html><head><title>»¶Ó­»ØÀ´</title>");
		resp.println("</head><body>");
		resp.println("»¶Ó­£º").println(req.getParameterValue("uname")).println("»ØÀ´");
		resp.println("</body></html>");
		String name = req.getParameterValue("uname");
		String pwd = req.getParameterValue("pwd");
		if(login(name,pwd)) {
			resp.println("µÇÂ½³É¹¦");
		}else {
			resp.println("µÇÂ½Ê§°Ü");
		}
	}
	
	public boolean login(String name,String pwd) {
		return name.equals("Inta")&&pwd.equals("654321");
	}
	@Override
	public void doPost(Request req, Response resp) throws Exception {
		
	}

}
