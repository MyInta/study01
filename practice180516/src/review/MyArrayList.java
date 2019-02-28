package review;

/**
 * 测试写出自己的ArrayList类
 * @author 银涛
 *
 */
public class MyArrayList {
	private int size;
	private Object[] object;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


	/**
	 * 数组初始化
	 */
	public MyArrayList() {
		this(16);
	}
	
	/**
	 * 自定义可以设置的数组长度
	 */
	public MyArrayList(int index) {
		if(index>0) {
			object = new Object[index];
		}else {
			try {
				throw new Exception("索引错误");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 确保数组的长度在范围以内。若超出则将长度乘二。
	 * @param obj
	 * @return
	 */
	public Object[] ensureCapcity(int len) {
		if(object.length<=len) {
			Object[] newObj = new Object[len*2];
			for(int i=0;i<object.length;i++) {
				newObj[i]=object[i];
			}
			object=newObj;
		}
		return object;
	}
	
	/**
	 * 索引范围检测，若超出则报异常
	 * @param index
	 */
	private void rangeCheck(int index) {
		if(index<0||index>size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void add(Object obj) {
		object[size] = obj;
		size++;
		ensureCapcity(size);
	}
	
	public Object add(int index,Object obj) {
		rangeCheck(index);
		Object oldValue = object[index];
		ensureCapcity(++size);
		int moveNum = size-index;
		//将索引所在及之后的元素拷到原有位置考后一位处。
		System.arraycopy(object, index, object, index+1, moveNum);
		object[index] = obj;
		return oldValue;
	}
	
	/**
	 * 移除索引所在元素
	 * @param index 索引
	 * @return 返回所移除的元素值
	 */
	public int remove(int index) {
		rangeCheck(index);
		int oldValue = (int) object[index];
		//注意这里的移动长度和add方法中移动的区别
		int moveLength = size-index-1;
		System.arraycopy(object, index+1, object, index, moveLength);
		//将末端元素置空（拷贝的时候没影响到其值变化）,并且尺寸减一
		object[--size] = null;
		return oldValue;
	}
	
	/**
	 * 将对应索引位置元素更改
	 * @param index 索引
	 * @param obj 新值
	 * @return 返回索引原先元素值
	 */
	public Object set(int index,Object obj) {
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
	
}
