package review;

public class TestMyArrayList {
	public static void main(String[] args) {
		MyArrayList mal = new MyArrayList(3);
//		mal.add(new Human("Inta"));
		mal.add("a");
		mal.add('b');
		mal.add('c');
		mal.add(2);
		mal.add(8);
		mal.add(9);
		mal.remove(3);
		mal.add(6, 'd');
		System.out.println(mal.getSize());
		for(int i=0;i<mal.getSize();i++) {
			System.out.print(mal.get(i)+"\t");
		}
//		Human h = (Human) mal.get(0);
//		System.out.println(h.getName());
	}
}
