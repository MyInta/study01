package practice01;

import practice01.Face.Nose;

/**
 * 测试外部类、内部普通类、内部静态类、外部静态类之间的关系
 * @author 银涛
 *
 */
public class TestOuter {
	public static void main(String[] args) {
//		Face.Nose n = new Face().new Nose();
		Face f = new Face();
		Nose n = f.new Nose();
  		n.breath();		//如果使用System.out.println(n.breath());则会出现错误
  		Face.Ear e = new Face.Ear();	//调用内部静态类的方式
  		e.listen();
	}
}
class Face{
	int type;
	
	class Nose{
		String type;
		
		void breath() {
			System.out.println(Face.this.type);	//调用外部类的type，如果没有Face.this.则相当于this.type为内部类的type
			System.out.println("呼吸~");
		}
	}
	
	static class Ear{
		void listen() {
			System.out.println("听~");
		}
	}
}

