package test.practice;

public class test04 extends StaticSuper{
	static int rand;
	static {
		rand = (int)(Math.random()*6);
		System.out.println("static block "+rand);
	}
	test04(){
		System.out.println("constructor");
	}
	public static void main(String[] args) {
		System.out.println("in main");
		test04 t4 = new test04();
	}
}
class StaticSuper{
	static {
		System.out.println("super static block");
	}
	StaticSuper(){
		System.out.println(
				"super constructor"
				);
	}
}
