package review_622;

import java.util.LinkedList;

public class TestMyMap {
	LinkedList<TestEntry>[] arr =null;
	LinkedList<TestEntry> list = null;
	/**
	 * ��������ʼ��
	 * Ĭ��һ��ʼ������Ϊ10
	 */
	@SuppressWarnings("unchecked")
	public TestMyMap() {
		arr = new LinkedList[10];
	}
	/**
	 * ���k/v
	 * @param key
	 * @param value
	 */
	public void put(String key,String value) {
		//��������ʼ��
		TestEntry e = new TestEntry(key,value);
		int hash = key.hashCode();
		hash=hash<0?-hash:hash;
		int idx = hash%arr.length;
		if(null==arr[idx]) {
			list = new LinkedList<>();
			arr[idx]=list;
			list.add(e);
		}else {
			//���Ѿ������������ԭ������
			list = arr[idx];
			//�����鿴����key�ظ����ظ��򸲸ǵ�
			TestEntry e2 = null;
			for(int i=0;i<list.size();i++) {
				e2 = list.get(i);
				if(key==e2.getKey()) {
					e2.setValue(value);
					return;
				}
			}
			list.add(e);
		}
	}
	/**
	 * ��ȡ��Ӧkey��valueֵ
	 * @param key
	 */
	public String getValue(String key) {
		//��ö�Ӧkey������ֵ
		int hash = key.hashCode();
		hash=hash<0?-hash:hash;
		int idx = hash%arr.length;
		//��ö�Ӧ�����µ�����
		list = arr[idx];
		//����������Ԫ�أ������Ҫ�ķ���valueֵ
		TestEntry e3 = null;
		for(int i=0;i<list.size();i++) {
			e3 = list.get(i);
			if(key==e3.getKey()) {
				return e3.getValue();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		TestMyMap t = new TestMyMap();
		t.put("a", "Inta");
		t.put("b", "Intab");
		t.put("c", "Intac");
		t.put("c", "Intaccccc");
		t.put("d", "Intadd");
		String str = t.getValue("c");
		System.out.println(str);
	}
}

/**
 * Map���� ��װ�õ��ⲿ��
 * @author ����
 *
 */
class TestEntry{
	private String key;
	private String value;
	public TestEntry() {
	}
	public TestEntry(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}