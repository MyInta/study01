package test.practice;

public class test01 {
	@SuppressWarnings("unused")
	private void test02() {
		for(int x=0;x<4;x++) {
			for(int y=4;y>2;y--) {
				System.out.println(x+" "+y);
			}
			if(x==1) {
				x++;
			}
		}
	}
	public static void main(String[] args) {
		int x =0;
		int y = 30;
		for(int outer = 0;outer<3;outer++) {
			for(int inner =4;inner>1;inner--) {
				x+=0;
				y-=2;
				if(x==6) {
					break;
				}
				x+=3;
			}
			y-=2;
		}
		System.out.println(x+" "+y);
	}
}
