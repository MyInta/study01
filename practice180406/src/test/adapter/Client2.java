package test.adapter;
/**
 * �൱�ڱʼǱ�,ֻ��USB�ӿ�
 * @author ����
 *
 */
public class Client2 {
	public void test01(Target t) {
		t.handleReq();
	}
	public static void main(String[] args) {
		Client2 c = new Client2();
		//Target a = new Adapter();
		Adaptee adaptee = new Adaptee();
		Target a = new Adapter2(adaptee);
		
		c.test01(a);
	}
}
