package review_test02_servlet;

import review_test02_server.Request;
import review_test02_server.Response;

public class RegisterServlet extends Servlet{

	@Override
	public void doGet(Request req, Response resp) throws Exception {
		
	}

	@Override
	public void doPost(Request req, Response resp) throws Exception {
		resp.println("<html><head><title>�ǼǱ�</title>");
		resp.println("</head><body>");
		resp.println("doPost�����û���Ϣ"+req.getParameterValue("uname"));
		resp.println("</body></html>");
	}

}
