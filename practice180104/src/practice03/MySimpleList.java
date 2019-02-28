package practice03;

import java.util.Arrays;

/**
 * ��������ʹ��ԭ������������
 * 
 * @author ����
 *
 */
public class MySimpleList {
	private String[] elem = new String[5];
	private int size = 0;
	private int coursor = -1;

	public int size() {
		return this.size;
	}
	
	public void add(String str) {
		if (size == elem.length) {//����Ԫ��ǰ����ߴ磬�������鳤��һ��ʱ����
			elem = Arrays.copyOf(elem, elem.length + 5);
		}
		elem[size++] = str;
	}

	public String Next() {
		coursor++;
		return elem[coursor];
	}

	public boolean hasNext() {
		return (coursor + 1) < size;
	}

	public void remove() {
		System.arraycopy(elem, coursor + 1, elem, coursor, size - (coursor + 1));
		coursor--;//ָ����ɾ���������ػ�-1����ǰԪ������-1ֵ������nextʱ��+1�ҵ���ǰԪ�أ�
		size--;
	}
	public static void main(String[] args) {
		MySimpleList list = new MySimpleList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		if(list.hasNext()) {
			System.out.println(list.Next());
		}
		if(list.hasNext()) {
			System.out.println(list.Next());
		}
		if(list.hasNext()) {
			System.out.println(list.Next());
		}
		if(list.hasNext()) {
			System.out.println(list.Next());
		}
		System.out.println(list.size());
		
	}
		
}
