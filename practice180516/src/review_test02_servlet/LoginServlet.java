package review_test02_servlet;

import review_test02_server.Request;
import review_test02_server.Response;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Request req, Response resp) throws Exception {
		resp.println("<html><head><title>��ӭ����</title>");
		resp.println("</head><body>");
		resp.println("��ӭ��").println(req.getParameterValue("uname")).println("����");
		resp.println("</body></html>");
		String name = req.getParameterValue("uname");
		String pwd = req.getParameterValue("pwd");
		if(login(name,pwd)) {
			resp.println("��½�ɹ�");
		}else {
			resp.println("��½ʧ��");
		}
	}
	
	public boolean login(String name,String pwd) {
		return name.equals("Inta")&&pwd.equals("654321");
	}
	@Override
	public void doPost(Request req, Response resp) throws Exception {
		
	}

}
