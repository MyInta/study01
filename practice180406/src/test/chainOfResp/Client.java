package test.chainOfResp;

public class Client {
	public static void main(String[] args) {
		Leader a = new Director("张三");
		Leader b = new Manager("李四");
		Leader c = new GeneralManager("王五");
		
		//组织责任链对象关系
		a.setNextLeader(b);
		b.setNextLeader(c);
		
		//开始请假操作
		LeaveRequest request = new LeaveRequest("陈文", 12, "去赣州看妹子");
		//b.handleRequest(request);
		a.handleRequest(request);
	}
}
