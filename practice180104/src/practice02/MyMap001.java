package practice02;
/**
 * 测试Map中的键值对
 * 还不够完善、效率较低
 * @author 银涛
 *
 */
public class MyMap001 {
	MyEntry[] arr = new MyEntry[66];
	int size=0;
	
	public void put(Object key,Object value) {
		MyEntry me = new MyEntry(key, value);
		//解决键值对冲突问题
		for(int i=0;i<size;i++) {
			if(arr[i].key.equals(key)) {
				arr[i].value = value;
				return;
			}
		}
		arr[size++] = me;
	}
	public Object get(Object key) {
		for(int i=0;i<size;i++) {
			if(arr[i].key.equals(key)) {
				return arr[i].value;
			}
		}
		return null;
	}
	public boolean containsKey(Object key) {
		for(int i=0;i<size;i++) {
			if(arr[i].key.equals(key)) {
				return true;
			}
		}
		return false;
	}
	public boolean containsValue(Object value) {
		for(int i=0;i<size;i++) {
			if(arr[i].value.equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyMap001 map01 = new MyMap001();
		map01.put("牛琦", new Wife("李银"));
		map01.put("牛琦", new Wife("张楚馨"));
		map01.put("陈文", new Wife("仁女"));
		Wife w = (Wife) map01.get("陈文");
		Wife w2 = (Wife) map01.get("牛琦");
		System.out.println(w.name);
		System.out.println(w2.name);
		System.out.println(map01.containsKey("牛琦"));
	}
}
class MyEntry{
	Object key;
	Object value;
	public MyEntry() {
	}
	public MyEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
}
class Wife{
	String name;
	public Wife(String name) {
		super();
		this.name = name;
	}
	
}