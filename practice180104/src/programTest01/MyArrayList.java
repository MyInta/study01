package programTest01;


/**
 * 测试新建的ArrayList来熟悉使用环境
 * @author 银涛
 *
 */
public class MyArrayList {
	//类似于新建ArrayList的子类
//	ArrayList<Object> MyArrayList = new ArrayList<>();
	//元素容器
	private Object[] elementDate;
	//容器大小
	private int size;
	//构造器初始化，初始大小为3
	public MyArrayList() {
		this.elementDate = new Object[3];
	}
	//带参构造，初始化大小
	public MyArrayList(int initialCapcity) {
		//健壮性，容器大小为负抛异常
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
	 * add添加元素的方法
	 * @param obj
	 */
	public void add(Object obj) {
		//如果容器内元素实际量达到设定容器最大值，则扩容
		if(size==elementDate.length) {
			Object[] newArrayList = new Object[size*2+1];
			//扩容后，将原先的容器拷贝进新的容器
			System.arraycopy(elementDate, 0, newArrayList, 0, elementDate.length);
			//并重新定义变量引用地址-->到新容器的地址
			elementDate = newArrayList;
		}
		elementDate[size++] =  obj;
	}
	/**
	 * get方法，输入索引返回对应索引位置的对象
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		//健壮性，如果索引越界则抛异常
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
		list.add(new Dog("阿拉斯加"));
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
		Dog d = (Dog) list.get(1);			//想要调出Dog类的属性，首先得给一个Dog类（外部类）
		System.out.println(d.name);
		MyArrayList tryList = (MyArrayList) list.get(4);	//同理，list[4]已经是一个MyA...属性，所以要调其中属性要先建类
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
