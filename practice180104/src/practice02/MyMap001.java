package practice02;
/**
 * ����Map�еļ�ֵ��
 * ���������ơ�Ч�ʽϵ�
 * @author ����
 *
 */
public class MyMap001 {
	MyEntry[] arr = new MyEntry[66];
	int size=0;
	
	public void put(Object key,Object value) {
		MyEntry me = new MyEntry(key, value);
		//�����ֵ�Գ�ͻ����
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
		map01.put("ţ��", new Wife("����"));
		map01.put("ţ��", new Wife("�ų�ܰ"));
		map01.put("����", new Wife("��Ů"));
		Wife w = (Wife) map01.get("����");
		Wife w2 = (Wife) map01.get("ţ��");
		System.out.println(w.name);
		System.out.println(w2.name);
		System.out.println(map01.containsKey("ţ��"));
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