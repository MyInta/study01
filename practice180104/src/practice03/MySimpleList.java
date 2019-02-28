package practice03;

import java.util.Arrays;

/**
 * 迭代器的使用原理，遍历迭代器
 * 
 * @author 银涛
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
		if (size == elem.length) {//加入元素前检验尺寸，当和数组长度一样时扩容
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
		coursor--;//指针在删掉操作后，重回-1（当前元素索引-1值，方便next时候+1找到当前元素）
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
