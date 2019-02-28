package programTest01;


/**
 * �����½���ArrayList����Ϥʹ�û���
 * @author ����
 *
 */
public class MyArrayList {
	//�������½�ArrayList������
//	ArrayList<Object> MyArrayList = new ArrayList<>();
	//Ԫ������
	private Object[] elementDate;
	//������С
	private int size;
	//��������ʼ������ʼ��СΪ3
	public MyArrayList() {
		this.elementDate = new Object[3];
	}
	//���ι��죬��ʼ����С
	public MyArrayList(int initialCapcity) {
		//��׳�ԣ�������СΪ�����쳣
		if(initialCapcity<0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.elementDate  = new Object[initialCapcity];
	}
	/**
	 * add���Ԫ�صķ���
	 * @param obj
	 */
	public void add(Object obj) {
		//���������Ԫ��ʵ�����ﵽ�趨�������ֵ��������
		if(size==elementDate.length) {
			Object[] newArrayList = new Object[size*2+1];
			//���ݺ󣬽�ԭ�ȵ������������µ�����
			System.arraycopy(elementDate, 0, newArrayList, 0, elementDate.length);
			//�����¶���������õ�ַ-->���������ĵ�ַ
			elementDate = newArrayList;
		}
		elementDate[size++] =  obj;
	}
	/**
	 * get�����������������ض�Ӧ����λ�õĶ���
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		//��׳�ԣ��������Խ�������쳣
		if(index<0||index>=size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return elementDate[index];
	}
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		list.add("avd");
		list.add(new Dog("����˹��"));
		list.add(123);
		list.add("iaiej");
		System.out.println(list.size);
		System.out.println("#############");
		MyArrayList list2 = new MyArrayList();
		list2.add(456);
		list2.add("sdef");
		list.add(list2);
		System.out.println(list.size);
		System.out.println("#############");
		Dog d = (Dog) list.get(1);			//��Ҫ����Dog������ԣ����ȵø�һ��Dog�ࣨ�ⲿ�ࣩ
		System.out.println(d.name);
		MyArrayList tryList = (MyArrayList) list.get(4);	//ͬ��list[4]�Ѿ���һ��MyA...���ԣ�����Ҫ����������Ҫ�Ƚ���
		System.out.println(tryList.get(1));
	}
}
class Dog{
	String name;
	public Dog() {
	}
	public Dog(String name) {
		this.name = name;
	}
	
}
