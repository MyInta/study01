package test.adapter;
/**
 * �൱�ڱʼǱ�,ֻ��USB�ӿ�
 * @author ����
 *
 */
public class Client {
	public void test01(Target t) {
		t.handleReq();
	}
	public static void main(String[] args) {
		Client c = new Client();
		Target a = new Adapter();
		c.test01(a);
	}
}
