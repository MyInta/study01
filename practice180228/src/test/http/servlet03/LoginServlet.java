package test.http.servlet03;

import test.http.server03.Request;
import test.http.server03.Response;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Response res,Request req) throws Exception {
//		res.println("<html><head><title>��ӭ����</title>");
//		res.println("</head><body>");
//		res.println("��ӭ��").println(req.getParameter("uname")).println("����");
//		res.println("</body></html>");
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if(login(name,pwd)) {
			res.println("��½�ɹ�");
		}else {
			res.println("��½ʧ��");
		}
	}
	
	public boolean login(String name,String pwd) {
		return name.equals("Inta")&&pwd.equals("654321");
	}
	@Override
	public void doPost(Response res,Request req) throws Exception {
		
	}
	
}
