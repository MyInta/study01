package review_all;

/**
 * LinkedList底层是节点串联的对象
 * 与ArrayList底层实现不同，如其中ArrayList有初始化长度
 * @author 银涛
 *
 */
public class MyLinkedList {
	//最开始的节点
	private Node first;
	//最后一个节点
	private Node last;
	//链表的实际长度
	private int size;
	//get方法获得链表长度
	public int getSize() {
		return size;
	}
	/**
	 * 检查是否越界
	 * @param index
	 */
	private void rangeCheck(int index) {
		if(index<0||index>=size) {
			try {
				throw new Exception("索引越界");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 通过索引获得对应节点
	 * @param index 索引
	 * @return 返回查找到的节点
	 */
	public Node getNode(int index) {
		//查看索引是否越界
		rangeCheck(index);
		//设置一个新节点并初始化为空
		Node n = null;
		//如果第一个节点不为空，说明后续可以查找
		if(null!=first) {
			//使用二分法查找便捷些，当索引在链表长度一半之内
			if(index<(size>>1)){
				//先将节点放到第一个节点位置
				n = first;
				//开始遍历索引次数，以寻找到对应节点
				for(int i=0;i<index;i++) {
					n=n.getNext();
				}
			}else {	//否则的倒着寻找
				//先将节点放到最后位置
				n = last;
				//开始便利，倒着寻找对应索引节点
				for(int i=size-1;i>index;i--) {
					n = n.getPrevious();
				}
				
			}
		}
		return n;
	}
	/**
	 * 通过索引获得对应索引位置的元素
	 * @param index 索引
	 * @return 返回对应位置的元素
	 */
	public Object get(int index) {
		//索引检索
		rangeCheck(index);
		//先通过索引获得节点对象
		Node n = getNode(index);
		//再先设置一个默认为空的元素
		Object obj = null;
		//如果节点不为空，则将节点内的元素赋值给该对象
		if(null!=n) {
			//获得该索引节点的元素
			obj = n.getObj();
		}
		return obj;
	}
	/**
	 * 默认在节点之后添加一个元素
	 * @param obj 元素
	 */
	public void add(Object obj) {
		//先创建一个节点用以承载元素
		Node n = new Node();
		//将元素设进节点中
		n.setObj(obj);
		n.setNext(null);
		//如果开头的元素为空则
		if(null==first) {
			//补齐新建的节点
			n.setPrevious(null);
			//创建新的第一个和最后一个节点元素
			first = n;
			last = n;
		}else {
			//否则，说明已经存在节点，不需要新创建一号节点
			//相当于联通隧道，将旧last对应节点与新末端节点前后贯通
			n.setPrevious(last);
			last.setNext(n);
			//覆盖掉原先的last让新建的末端节点来代替
			last = n;
		}
		//不要忘记每次添加成功后链表长度增一
		size++;
	}
	/**
	 * 通过索引添加对应位置的元素
	 * @param index 对应索引
	 * @param obj 元素
	 */
	public void add(int index,Object obj) {
		//索引检索
		rangeCheck(index);
		//通过索引查找到节点
		Node n = getNode(index);
		//创建一个新的Node用于后续添加插入
		Node newNode = new Node();
		//将需要添加的元素添加到新建Node中
		newNode.setObj(obj);
		//查看对应索引是否为首个，否则影响节点前置的设置
		if(n==first) {
			//新建节点前节点为空
			newNode.setPrevious(null);
			//新建节点后节点设置为旧首个节点
			newNode.setNext(first);
			//旧首个节点前节点设为新建节点，将通道贯通
			first.setPrevious(newNode);
			//最后更新首个节点
			first = newNode;
		}else {
			//如果对应索引不是首个位置，则需要一个前置节点协助
			Node up = n.getPrevious();
			//将新建节点的前置节点设为协助节点
			newNode.setPrevious(up);
			//将前置协助节点的后置节点设为新建节点，前一通道打通
			up.setNext(newNode);
			//将新建节点的后置节点设为旧节点
			newNode.setNext(n);
			//将旧节点的前置节点设为新建节点,后一通道打通
			n.setPrevious(newNode);
		}
		//最后，长度增一
		size++;
	}
	/**
	 * 删除对应索引位置的节点
	 * @param index
	 */
	public void remove(int index) {
		//索引检索
		rangeCheck(index);
		//获得该索引位置的节点
		Node n = getNode(index);
		//不要忘记考虑是否是首个节点的问题
		if(n==first) {
			//如果索引位置是首个节点，则短路后后一节点的前一节点为空
			n.getNext().setPrevious(null);
			first = n.getNext();
		}else {
			//思路是将其短路掉
			n.getPrevious().setNext(n.getNext());
			//考虑到后置节点可能为空（n为last节点）
			if(null==n.getNext()) {
				//因为我们删除的节点为last，所以直接省去了贯通的一半过程（后连）
				last = n.getPrevious();
			}else {
				n.getNext().setPrevious(n.getPrevious());
			}
		}
		//最后链表长度减一
		size--;
	}
	
	//测试
	public static void main(String[] args) {
		MyLinkedList mll = new MyLinkedList();
		mll.add("aaa");
		mll.add("bbb");
		mll.add("ccc");
		mll.add("ddd");
		mll.add("eee");
//		mll.add(4, "xxx");
		mll.remove(4);
		System.out.println(mll.getSize());
		for(int i=0;i<mll.size;i++) {
			System.out.println(mll.get(i));
		}
	}
}
class Node{
	//节点前节点
	private Node previous;
	//节点当前对象
	private Object obj;
	//节点后一节点
	private Node next;
	//空构造器
	public Node() {
	}
	/**
	 * 带参构造
	 * @param previous 前节点
	 * @param obj 当前对象
	 * @param next 后一节点
	 */
	public Node(Node previous, Object obj, Node next) {
		super();
		this.previous = previous;
		this.obj = obj;
		this.next = next;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}