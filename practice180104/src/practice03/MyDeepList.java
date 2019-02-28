package practice03;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 迭代器深入 -->一个窗口可以实现多个迭代对象
 * 
 * @author 银涛
 *
 */
public class MyDeepList {
	private String[] elem = new String[5];
	private int size=0;
	public int size() {
		return this.size;
	}
	public void add(String str) {
		if(size==elem.length) {		//容量不够，扩容，程序的健壮性
			elem = Arrays.copyOf(elem, elem.length+5);
		}
		elem[size++] = str;
	}
	//方法1 【
	public Iterator iterator() {
		return new MyIter();
	}
	
	private class MyIter implements Iterator{
			//如果指针不放置于内部类（譬如放到外面），会导致iterator二次使用的失效	
			private int coursor=-1;		
			public String next() {
				coursor++;
				return elem[coursor];
			}
			public boolean hasNext() {
				return (coursor + 1) < size;
			}
			public void remove() {
				System.arraycopy(elem, coursor + 1, elem, coursor, 
					/* MyDeepList.this. */size - (coursor + 1));
				/* MyDeepList.this. */size--;
				coursor--;
			}
	  }
	//】方法1
	//方法2 内部类形式
	public Iterator iterator2(){
		class MyIter implements Iterator{
			//如果指针不放置于内部类（譬如放到外面），会导致iterator二次使用的失效
			private int coursor=-1;		
			public String next() {
				coursor++;
				return elem[coursor];
			}
			public boolean hasNext() {
				return (coursor + 1) < size;
			}
			public void remove() {
				System.arraycopy(elem, coursor + 1, elem, coursor, 
					/* MyDeepList.this. */size - (coursor + 1));
				/* MyDeepList.this. */size--;
				coursor--;
			}
	  }
		return new MyIter();
	}
	
	//匿名类方法
	public Iterator iterator3() {
		return new Iterator(){
			//如果指针不放置于内部类（譬如放到外面），会导致iterator二次使用的失效
			private int coursor=-1;		
			public String next() {
				coursor++;
				return elem[coursor];
			}
			public boolean hasNext() {
				return (coursor + 1) < size;
			}
			public void remove() {
				System.arraycopy(elem, coursor + 1, elem, coursor, 
					/* MyDeepList.this. */size - (coursor + 1));
				/* MyDeepList.this. */size--;
				coursor--;
			}
	  };
	
	}

	public static void main(String[] args) {
		MyDeepList list = new MyDeepList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("C1");
		list.add("C2");
		list.add("C3");
//		Iterator it = list.iterator();
		Iterator it = list.iterator3();
		while(it.hasNext()) {
			System.out.println(it.next());
//			it.remove();
		}
		System.out.println("####");
//		it = list.iterator();
		it = list.iterator3();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
		
}
