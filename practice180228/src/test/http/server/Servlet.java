package test.http.server;

public class Servlet {
	public void service(Response res,Request req) {
		res.println("<html><head><title>HTTP��Ӧʾ��</title>");
		res.println("</head><body>");
		res.println("��ӭ��").println(req.getParameter("uname")).println("����");
		res.println("</body></html>");
	}
}
