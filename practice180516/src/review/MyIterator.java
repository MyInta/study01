package review;

/**
 * �кܶ��ַ�ʽ���ɲο�180104 practice03 MyDeepList
 * ���ֱַ�Ϊ ��ͨ��ʽ	�ڲ�����ʽ �Լ������ڲ���
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
	 * ����Ԫ��
	 * @param str
	 */
	public void add(String str) {
		if(elem.length==size) { //������ӵ�ʱ�������Ѿ������ˣ����ݣ�
			elem= Arrays.copyOf(elem, elem.length+5);
		}
		elem[size++] = str;
	}
	
	/**
	 * ����һ���̳�Iterator�ӿڵ�MyIter������
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
			//����
			cursor--;
			//������ȥ
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
