package review;

import java.util.LinkedList;


public class MyMap {
	@SuppressWarnings("unchecked")
	LinkedList<Entry>[] arr = new LinkedList[10];
	
	public void put(Object key,Object value) {
		Entry e = new Entry(key,value);
		LinkedList<Entry> list = null;
		int a = key.hashCode()%arr.length;
		if(null!=arr[a]) {
			list = arr[a];
			Entry e2 =null;
			for(int i=0;i<list.size();i++) {
				e2 = list.get(i);
				if(e2.getKey().equals(key)) {
					e2.setValue(value);
					return;
				}
			}
			arr[a].add(e);
		}else {
			list = new LinkedList<>();
			arr[a] = list;
			list.add(e);
		}
	}
	
	public Object getValue(Object key) {
		Object value = null;
		//优化hashCode以减少负数情况下的异常
		int hash = key.hashCode();
		hash = hash<0?-hash:hash;
		int a = hash%arr.length;
		LinkedList<Entry> list =null;
		if(arr[a]!=null) {
			list = arr[a];
			for(int i=0;i<list.size();i++) {
				Entry e = list.get(i);
				if(e.getKey().equals(key)) {
					return value = e.getValue();
				}
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
		MyMap mm = new MyMap();
		mm.put("a", "Inta");
		mm.put("b", "Lucy");
		mm.put("b", "Lucyaaaa");
		mm.put("c", "Aaron");
		mm.put("d", "Tom");
		String strValue = (String) mm.getValue("b");
		System.out.println(strValue);
	}
}



class Entry{
	private Object key;
	private Object value;

	public Entry() {
	}
	public Entry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}