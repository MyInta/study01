package test.bridge;
/**
 * Ʒ��
 * @author ����
 *
 */
public interface Brand {
	void sale();
}
class Lenovo implements Brand{

	@Override
	public void sale() {
		System.out.println("��������Ʒ�Ƶ���");
	}
	
}
class Dell implements Brand{
	
	@Override
	public void sale() {
		System.out.println("���۴���Ʒ�Ƶ���");
	}
	
}
