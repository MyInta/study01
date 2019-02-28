package practice01;

public class TestWhile {
	public static void main(String[] args) {
		int a=1,b =0;
		while(a<=1000) {
			if(a%5==0) {
				b++;
				if(b%4!=0) {
					System.out.print(a+"\t");
				}else {
					System.out.println();
				}
			}
			a++;
		}
		System.out.println("**********************");
		
		int c =0;
		for(int i=1;i<=1000;i++) {
			if(i%5==0) {
				c++;
				if(c%4!=0) {
					System.out.print(i+"\t");
				}else {
					System.out.println();
				}
			}
		}
		
	}
}
