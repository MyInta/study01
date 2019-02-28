package test.bridge;

public interface Computer {
	void sale();
}
class Desktop implements Computer{

	@Override
	public void sale() {
		System.out.println("����̨ʽ����");
	}
}
class Leptop implements Computer{
	
	@Override
	public void sale() {
		System.out.println("���۱ʼǱ���");
	}
}
class Pad implements Computer{
	
	@Override
	public void sale() {
		System.out.println("����ƽ����ԣ�");
	}
}
class LenovoDesktop extends Desktop{
	@Override
	public void sale() {
		System.out.println("��������̨ʽ����");
	}
}
class LenovoLeptop extends Leptop{
	@Override
	public void sale() {
		System.out.println("������ϵ�ʼǱ���");
	}
}
class LenovoPad extends Pad{
	@Override
	public void sale() {
		System.out.println("��������ƽ�壡");
	}
}