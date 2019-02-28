package practice01;
/**
 * 测试下ArrayList的重写
 * @author 银涛
 *
 */
public class MyArrayList {
	 /**
     * The value is used for Object storage.
     */
    private Object[] value;
    /**
     * The size is the number of Object used.
     */
    private int size;
    public MyArrayList() {
    	//value = new Object[16];
    	this(16);
    }
	public MyArrayList(int size) {
		value = new Object[size];
	}
    public void add(Object obj) {
    	value[size] = obj;
    	size++;
    	if(size>=value.length) {
    		//需要扩容
    		int newCapacity = value.length*2+2;
    		Object[] newList = new Object[newCapacity];
    		//又不能失去原有数据，也可用
    		//System.arraycopy(value, 0, newList, 0, value.length);
    		for(int i=0;i<value.length;i++) {
    			newList[i] = value[i]; 
    		}
    		value = newList;
    	}
    }
    public Object get(int index) {
    	if(index<0||index>size-1) {
    		try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	return value[index];
    }
    public int size(){
    	return size;
    }
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(2);
		list.add("inta01");
		list.add("inta02");
		list.add("inta03");
		list.add(new HelloWorld("inta is getting into the New World~"));
		HelloWorld h = (HelloWorld)(list.get(3));
		
		list.add("inta04");
		list.add("inta05");
		list.add("inta06");
		System.out.println(h.getName());
		System.out.println("**************");
		
		for(int i=0;i<list.size;i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.size);
	}
}
