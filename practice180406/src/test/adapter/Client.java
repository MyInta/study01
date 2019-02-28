package test.adapter;
/**
 * 相当于笔记本,只有USB接口
 * @author 银涛
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
