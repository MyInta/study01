package test.adapter;
/**
 * ������������������ʽ��
 * @author ����
 *
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void handleReq() {
		super.request();
	}

}
