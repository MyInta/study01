package test.http.servlet03;

import test.http.server03.Request;
import test.http.server03.Response;

public class RegisterServlet extends Servlet{

	@Override
	public void doGet(Response res, Request req) throws Exception {
		
	}

	@Override
	public void doPost(Response res, Request req) throws Exception {
		res.println("<html><head><title>����ע��</title>");
		res.println("</head><body>");
		res.println("����û���Ϊ��"+req.getParameter("uname"));
		res.println("</body></html>");
	}

}
