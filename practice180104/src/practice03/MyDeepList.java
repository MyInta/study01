package practice03;

import java.util.Arrays;
import java.util.Iterator;

/**
 * ���������� -->һ�����ڿ���ʵ�ֶ����������
 * 
 * @author ����
 *
 */
public class MyDeepList {
	private String[] elem = new String[5];
	private int size=0;
	public int size() {
		return this.size;
	}
	public void add(String str) {
		if(size==elem.length) {		//�������������ݣ�����Ľ�׳��
			elem = Arrays.copyOf(elem, elem.length+5);
		}
		elem[size++] = str;
	}
	//����1 ��
	public Iterator iterator() {
		return new MyIter();
	}
	
	private class MyIter implements Iterator{
			//���ָ�벻�������ڲ��ࣨƩ��ŵ����棩���ᵼ��iterator����ʹ�õ�ʧЧ	
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
	//������1
	//����2 �ڲ�����ʽ
	public Iterator iterator2(){
		class MyIter implements Iterator{
			//���ָ�벻�������ڲ��ࣨƩ��ŵ����棩���ᵼ��iterator����ʹ�õ�ʧЧ
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
	
	//�����෽��
	public Iterator iterator3() {
		return new Iterator(){
			//���ָ�벻�������ڲ��ࣨƩ��ŵ����棩���ᵼ��iterator����ʹ�õ�ʧЧ
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
