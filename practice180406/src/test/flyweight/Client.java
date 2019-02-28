package test.flyweight;

public class Client {
	public static void main(String[] args) {
		ChessFlyWeight chess1 = new ChessFlyWeightFactory().getChess("��ɫ");
		ChessFlyWeight chess2 = new ChessFlyWeightFactory().getChess("��ɫ");
		System.out.println(chess1);
		System.out.println(chess2);
		
		System.out.println("========�����ⲿ״̬�Ĵ���=========");
		chess1.display(new Coordinate(10,10));
		chess2.display(new Coordinate(20,20));
		
	}
}