package test.http.servlet03;

import test.http.server03.Request;
import test.http.server03.Response;

/**
 * 抽象为一个父类
 * @author 银涛
 *
 */
public abstract class Servlet {
	public void service(Response res,Request req) throws Exception {
		this.doGet(res, req);
		this.doPost(res, req);
	}
	public abstract void doGet(Response res,Request req) throws Exception;
	public abstract void doPost(Response res,Request req) throws Exception;
}
