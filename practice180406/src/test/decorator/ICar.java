package test.decorator;

public interface ICar {
	void move();
}
//��ʵ��ɫ
class Car implements ICar{

	@Override
	public void move() {
		System.out.println("����½�����ܵĳ�");
	}
}
//װ�ν�ɫ
class SuperCar implements ICar{
	protected ICar icar;
	public SuperCar(ICar icar) {
		super();
		this.icar = icar;
	}

	@Override
	public void move() {
		icar.move();
	}
}
//CocreteDecorator����װ�ν�ɫ
class FlyCar extends SuperCar{

	public FlyCar(ICar car) {
		super(car);
	}
	@Override
	public void move() {
		super.move();
		this.fly();
	}
	private void fly() {
		System.out.println("�⳵TM�ܷ�������");
	}
}
class WaterCar extends SuperCar{
	
	public WaterCar(ICar car) {
		super(car);
	}
	@Override
	public void move() {
		super.move();
		this.swim();
	}
	private void swim() {
		System.out.println("�⳵������Ǳͧ�κ���~");
	}
}