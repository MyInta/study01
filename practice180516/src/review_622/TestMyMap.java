package review_622;

import java.util.LinkedList;

public class TestMyMap {
	LinkedList<TestEntry>[] arr =null;
	LinkedList<TestEntry> list = null;
	/**
	 * 构造器初始化
	 * 默认一开始给长度为10
	 */
	@SuppressWarnings("unchecked")
	public TestMyMap() {
		arr = new LinkedList[10];
	}
	/**
	 * 添加k/v
	 * @param key
	 * @param value
	 */
	public void put(String key,String value) {
		//将容器初始化
		TestEntry e = new TestEntry(key,value);
		int hash = key.hashCode();
		hash=hash<0?-hash:hash;
		int idx = hash%arr.length;
		if(null==arr[idx]) {
			list = new LinkedList<>();
			arr[idx]=list;
			list.add(e);
		}else {
			//若已经有链表，则接受原有链表
			list = arr[idx];
			//遍历查看有无key重复，重复则覆盖掉
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
	 * 获取对应key的value值
	 * @param key
	 */
	public String getValue(String key) {
		//获得对应key的索引值
		int hash = key.hashCode();
		hash=hash<0?-hash:hash;
		int idx = hash%arr.length;
		//获得对应索引下的链表
		list = arr[idx];
		//遍历链表内元素，获得想要的返回value值
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
 * Map容器 封装好的外部类
 * @author 银涛
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