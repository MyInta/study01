package review_test02_servlet;

import review_test02_server.Request;
import review_test02_server.Response;

/**
 * Servlet�����࣬Ҳ����ҳ����ʾ�ĸ���
 * @author ����
 *
 */
public abstract class Servlet {

	public  void service(Request req,Response resp) throws Exception {
		this.doGet(req,resp);
		this.doPost(req,resp);
	}
	
	//������󷽷�
	public abstract void doGet(Request req,Response resp) throws Exception;
	public abstract void doPost(Request req,Response resp) throws Exception;
}
