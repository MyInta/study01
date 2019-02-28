package review_test02_servlet;

import review_test02_server.Request;
import review_test02_server.Response;

/**
 * Servlet抽象类，也就是页面显示的父类
 * @author 银涛
 *
 */
public abstract class Servlet {

	public  void service(Request req,Response resp) throws Exception {
		this.doGet(req,resp);
		this.doPost(req,resp);
	}
	
	//定义抽象方法
	public abstract void doGet(Request req,Response resp) throws Exception;
	public abstract void doPost(Request req,Response resp) throws Exception;
}
