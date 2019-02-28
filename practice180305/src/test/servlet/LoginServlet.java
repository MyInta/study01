package test.servlet;

import test.server.Request;
import test.server.Response;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Response res,Request req) throws Exception {
		res.println("<html><head><title>»¶Ó­»ØÀ´</title>");
		res.println("</head><body>");
		res.println("»¶Ó­£º").println(req.getParameter("uname")).println("»ØÀ´");
		res.println("</body></html>");
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if(login(name,pwd)) {
			res.println("µÇÂ½³É¹¦");
		}else {
			res.println("µÇÂ½Ê§°Ü");
		}
	}
	
	public boolean login(String name,String pwd) {
		return name.equals("Inta")&&pwd.equals("654321");
	}
	@Override
	public void doPost(Response res,Request req) throws Exception {
		
	}
	
}
