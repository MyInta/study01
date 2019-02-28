package review_all;

/**
 * ArrayList底层是数组
 * @author 银涛
 *
 */
public class MyArrayList {
	//Array数组实际长度
	private int size;
	//Array数组容器
	private Object[] object;
	//set get 方法
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * 空构造器
	 */
	public MyArrayList() {
		//调用带参构造，初始化数组长度
		this(16);
	}
	/**
	 * 带参构造，指定构造数组的长度
	 * @param index
	 */
	public MyArrayList(int index) {
		if(index>0){
			//容器长度调整为指定长度
			object = new Object[size];
		}else{
			try {
				throw new Exception("设置的长度不合法！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 确保构建的数组长度合理
	 * @param len
	 */
	public Object[] ensureCapcity(int len) {
		//如果所要确保的长度超过数组容器长度，扩容x2
		if(len>=object.length) {
			//创建新的数组
			Object[] newObj = new Object[len*2];
			//将旧数据拷贝到新数组上去
			System.arraycopy(object, 0, newObj, 0, object.length);
			//覆盖掉旧数组
			object = newObj;
		}
		//将得到的扩容后的数组返回
		return object;
	}
	/**
	 * 检查索引有无越界（不要超过数组长度）
	 * @param index
	 */
	public void checkRange(int index) {
		//如果索引小于0或者大于数组实际长度（非数组容器长度）下
		if(index<0||index>size-1) {
			try {
				throw new Exception("索引越界");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 在数组末端添加元素
	 * @param obj 新元素
	 */
	public void add(Object obj) {
		//确保添加元素的时候数组长度够用
		ensureCapcity(++size);
		//在数组实际长度末端添加元素
		object[size-1] = obj;
		//或者object[size] = obj;size++;ensureCapcity(size);
	}
	/**
	 * 通过索引指定位置添加元素
	 * @param index 指定的索引
	 * @param obj 添加的元素
	 */
	public void add(int index,Object obj) {
		//检查索引是否越界
		checkRange(index);
		//确保添加元素的时候数组长度够用
		ensureCapcity(++size);
		//需要求移动元素的个数,譬如长度5索引3(实际元素4)位置，需要移动5-3个元素
		int moveLen = size-index;
		//将老数据移动到新数据位置
		System.arraycopy(object, index, object, index+1, moveLen);
		//将索引位置的地方填上新元素
		object[index] = obj;
	}
	/**
	 * 指定索引位置移除元素
	 * @param index 索引
	 * @return 所移除的元素值
	 */
	public Object remove(int index) {
		//检查索引是否越界
		checkRange(index);
		//获得原先的元素值
		Object oldObj = object[index];
		//需要求移动元素的个数,譬如长度5索引3(实际元素4)位置，需要移动5-3-1个元素
		int removeLen = size-index-1;
		//将旧元素移动到新元素位置
		System.arraycopy(object, index+1, object, index, removeLen);
		//数组实际长度减一,并且让末端元素值为空
		object[--size]=null;
		//返回所被移除的元素值
		return oldObj;
	}
	/**
	 * 将对应索引位置元素更改
	 * @param index 索引
	 * @param obj 新值
	 * @return 返回索引原先元素值
	 */
	public Object set(int index,Object obj) {
		//检查索引是否越界
		checkRange(index);
		Object OldValue = object[index];
		object[index] = obj;
		return OldValue;
	}
	
	public Object get(int index) {
		if(index>=0&&index<size) {
			return object[index];
		}else {
			//这里没有用索引范围检索方法，自定义越界返回值-1
			return -1;
		}
	}
	public static void main(String[] args) {
		MyArrayList mal = new MyArrayList(3);
//		mal.add(new Human("Inta"));
		mal.add("a");
		mal.add('b');
		mal.add('c');
		mal.add(2);
		mal.add(8);
		mal.add(9);
		mal.remove(3);
		mal.add(4, 'd');
		System.out.println(mal.getSize());
		for(int i=0;i<mal.getSize();i++) {
			System.out.print(mal.get(i)+"\t");
		}
//		Human h = (Human) mal.get(0);
//		System.out.println(h.getName());
	}
}
