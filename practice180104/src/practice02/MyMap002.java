package practice02;

import java.util.LinkedList;

/**
 * 对Map001进行升级~
 * 提高查询效率的Map
 * @author 银涛
 *
 */
public class MyMap002 {
	@SuppressWarnings("unchecked")
	LinkedList<MyEntry>[] arr = new LinkedList[999];
	int size=0;
	public void put(Object key,Object value) {
		MyEntry e = new MyEntry(key, value);
		int a = key.hashCode()%arr.length;
		LinkedList<MyEntry> list =null;
		//该位置是否存在链表，不存在则创建一个
		if(arr[a]==null) {
			list = new LinkedList<>();
			arr[a] = list;
			list.add(e);
		}else {
			//存在则往链表里增改数据
			list = arr[a];
			//遍历链表判断有无key重复
			for(int i=0;i<list.size();i++) {
				MyEntry e2 = list.get(i);
				if(e2.key.equals(key)) {
					e2.value = value;
					return;
				}
			}
			arr[a].add(e);
		}
		
	}
	public Object get(Object key) {
		//优化hashCode以减少负数情况下的异常
		int hash = key.hashCode();
		hash = hash<0?-hash:hash;
		int a = hash%arr.length;
		if(arr[a]!=null) {
			//说明该位置已经有链表了
			LinkedList<MyEntry> list = arr[a];
			//那么遍历链表内元素MyEntry
			for(int i=0;i<list.size();i++) {
				MyEntry e = list.get(i);
				if(e.key.equals(key)) {
					return e.value;
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		MyMap002 map01 = new MyMap002();
		map01.put("牛琦", new Wife("李银"));
		map01.put("牛琦", new Wife("张楚馨"));
		map01.put("陈文", new Wife("仁女"));
		Wife w = (Wife) map01.get("陈文");
		Wife w2 = (Wife) map01.get("牛琦");
		System.out.println(w.name);
		System.out.println(w2.name);
	}
}
