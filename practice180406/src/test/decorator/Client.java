package test.decorator;

public class Client {
	public static void main(String[] args) {
		Car car = new Car();
		System.out.println("=============");
		FlyCar fly = new FlyCar(car);
		fly.move();
		
		System.out.println("=============");
		WaterCar water = new WaterCar(car);
		water.move();
		
		System.out.println("=============");
		
		WaterCar car2 = new WaterCar(new FlyCar(car));
		car2.move();
	}
}
