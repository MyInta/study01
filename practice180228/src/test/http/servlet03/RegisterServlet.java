package test.http.servlet03;

import test.http.server03.Request;
import test.http.server03.Response;

public class RegisterServlet extends Servlet{

	@Override
	public void doGet(Response res, Request req) throws Exception {
		
	}

	@Override
	public void doPost(Response res, Request req) throws Exception {
		res.println("<html><head><title>返回注册</title>");
		res.println("</head><body>");
		res.println("你的用户名为："+req.getParameter("uname"));
		res.println("</body></html>");
	}

}
