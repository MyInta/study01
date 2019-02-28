package test.practice;

public class ClassAndObject {
	public static void main(String[] args) {
		Echo e1 = new Echo();
		Echo e2 = e1;
		int x =0;
		while(x<4) { //			x:0 e1:1 e2:1-->2 x:1 e1:2 e2:3-->5 x:2 e1
			e1.hello();
			e1.count+=1;//
			if(x>0) {
				e2.count = e2.count + 1;
			}
			if(x>1) {
				e2.count = e2.count + e1.count;	//e1:1 2 3 4
			}
			x+=1;
		}
		System.out.println(e2.count);
	}
}
class Echo {
	int count = 0;
	void hello() {
		System.out.println("helloooo...");
	}
}
