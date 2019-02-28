package practice02;

import java.util.LinkedList;

/**
 * ��Map001��������~
 * ��߲�ѯЧ�ʵ�Map
 * @author ����
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
		//��λ���Ƿ���������������򴴽�һ��
		if(arr[a]==null) {
			list = new LinkedList<>();
			arr[a] = list;
			list.add(e);
		}else {
			//����������������������
			list = arr[a];
			//���������ж�����key�ظ�
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
		//�Ż�hashCode�Լ��ٸ�������µ��쳣
		int hash = key.hashCode();
		hash = hash<0?-hash:hash;
		int a = hash%arr.length;
		if(arr[a]!=null) {
			//˵����λ���Ѿ���������
			LinkedList<MyEntry> list = arr[a];
			//��ô����������Ԫ��MyEntry
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
		map01.put("ţ��", new Wife("����"));
		map01.put("ţ��", new Wife("�ų�ܰ"));
		map01.put("����", new Wife("��Ů"));
		Wife w = (Wife) map01.get("����");
		Wife w2 = (Wife) map01.get("ţ��");
		System.out.println(w.name);
		System.out.println(w2.name);
	}
}
