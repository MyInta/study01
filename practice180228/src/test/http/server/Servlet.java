package test.http.server;

public class Servlet {
	public void service(Response res,Request req) {
		res.println("<html><head><title>HTTP响应示例</title>");
		res.println("</head><body>");
		res.println("欢迎：").println(req.getParameter("uname")).println("回来");
		res.println("</body></html>");
	}
}
