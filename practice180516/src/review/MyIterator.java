package review;

/**
 * 有很多种方式。可参考180104 practice03 MyDeepList
 * 三种分别为 普通形式	内部类形式 以及匿名内部类
 */
import java.util.Arrays;
import java.util.Iterator;

public class MyIterator {
	private String[] elem = new String[5];
	
	private int size;
	public int size() {
		return this.size;
	}
	
	/**
	 * 增加元素
	 * @param str
	 */
	public void add(String str) {
		if(elem.length==size) { //如果增加的时候数组已经饱和了，扩容！
			elem= Arrays.copyOf(elem, elem.length+5);
		}
		elem[size++] = str;
	}
	
	/**
	 * 方法一，继承Iterator接口的MyIter迭代器
	 * @return
	 */
	public Iterator iterator() {
		return new MyIter();
	}
	
	private class MyIter implements Iterator{
		int cursor = -1;
		
		
		@Override
		public boolean hasNext() {
			return (cursor+1)<size;
		}

		@Override
		public Object next() {
			cursor++;
			return elem[cursor];
		}
		
		public void remove() {
			System.arraycopy(elem, cursor+1,elem,cursor,size-(cursor+1));
			//回退
			cursor--;
			//长度削去
			size--;
		}
		
	}
	
	public static void main(String[] args) {
		MyIterator mi = new MyIterator();
		mi.add("a");
		mi.add("b");
		mi.add("c");
		mi.add("d");
		mi.add("e");
		mi.add("f");
		Iterator it = mi.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
		System.out.println(mi.size());
	}
}
