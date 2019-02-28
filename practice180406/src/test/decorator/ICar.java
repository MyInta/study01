package test.decorator;

public interface ICar {
	void move();
}
//真实角色
class Car implements ICar{

	@Override
	public void move() {
		System.out.println("能在陆地上跑的车");
	}
}
//装饰角色
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
//CocreteDecorator具体装饰角色
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
		System.out.println("这车TM能飞起来！");
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
		System.out.println("这车可以作潜艇游海底~");
	}
}