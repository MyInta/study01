package test.chainOfResp;

public class Client {
	public static void main(String[] args) {
		Leader a = new Director("����");
		Leader b = new Manager("����");
		Leader c = new GeneralManager("����");
		
		//��֯�����������ϵ
		a.setNextLeader(b);
		b.setNextLeader(c);
		
		//��ʼ��ٲ���
		LeaveRequest request = new LeaveRequest("����", 12, "ȥ���ݿ�����");
		//b.handleRequest(request);
		a.handleRequest(request);
	}
}
