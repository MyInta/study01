package test.adapter;
/**
 * ��������������ϵķ�ʽ��
 * @author ����
 *
 */
public class Adapter2 implements Target{
	Adaptee adaptee;
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void handleReq() {
		this.adaptee.request();
	}

}
