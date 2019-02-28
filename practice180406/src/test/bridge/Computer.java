package test.bridge;

public interface Computer {
	void sale();
}
class Desktop implements Computer{

	@Override
	public void sale() {
		System.out.println("销售台式机！");
	}
}
class Leptop implements Computer{
	
	@Override
	public void sale() {
		System.out.println("销售笔记本！");
	}
}
class Pad implements Computer{
	
	@Override
	public void sale() {
		System.out.println("销售平板电脑！");
	}
}
class LenovoDesktop extends Desktop{
	@Override
	public void sale() {
		System.out.println("销售联想台式机！");
	}
}
class LenovoLeptop extends Leptop{
	@Override
	public void sale() {
		System.out.println("销售联系笔记本！");
	}
}
class LenovoPad extends Pad{
	@Override
	public void sale() {
		System.out.println("销售联想平板！");
	}
}