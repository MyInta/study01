package practice01;

import practice01.Face.Nose;

/**
 * �����ⲿ�ࡢ�ڲ���ͨ�ࡢ�ڲ���̬�ࡢ�ⲿ��̬��֮��Ĺ�ϵ
 * @author ����
 *
 */
public class TestOuter {
	public static void main(String[] args) {
//		Face.Nose n = new Face().new Nose();
		Face f = new Face();
		Nose n = f.new Nose();
  		n.breath();		//���ʹ��System.out.println(n.breath());�����ִ���
  		Face.Ear e = new Face.Ear();	//�����ڲ���̬��ķ�ʽ
  		e.listen();
	}
}
class Face{
	int type;
	
	class Nose{
		String type;
		
		void breath() {
			System.out.println(Face.this.type);	//�����ⲿ���type�����û��Face.this.���൱��this.typeΪ�ڲ����type
			System.out.println("����~");
		}
	}
	
	static class Ear{
		void listen() {
			System.out.println("��~");
		}
	}
}

