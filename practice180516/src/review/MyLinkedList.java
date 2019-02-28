package review;

public class MyLinkedList {
	private Node first;
	private Node last;
	private int size;
	
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
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 查找对应索引的节点
	 * @param index 索引
	 * @return
	 */
	public Node getNode(int index) {
		Node n = null;
		rangeCheck(index);
		/**
		 * 使用二分法快速查找
		 */
		if(null!=first) {
			if(index<(size>>1)) {
				n=first;
				for(int i=0;i<index;i++) {
					n = n.getNext();
				}
			}else {
				n=last;
				for(int i=size-1;i>index;i--) {
					n = n.getPrevious();
				}
			}
		}
		return n;
	}
	
	/**
	 * 获得对应索引的节点对象的Object内容
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		rangeCheck(index);
		Node n = getNode(index);
		Object obj = null;
		if(null!=n) {
			obj =n.getObj();
		}
		return obj;
	}
	
	/**
	 * 增加一个对象
	 * @param obj
	 */
	public void add(Object obj) {
		Node n = new Node();
		n.setObj(obj);
		if(null==first) {
			n.setPrevious(null);
			n.setNext(null);
			first = n;
			last = n;
		}else {
			n.setPrevious(last);
			n.setNext(null);
			last.setNext(n);
			last=n;
		}
		size++;
	}
	
	/**
	 * 对应索引增加一个对象节点
	 * @param index
	 * @param obj
	 */
	public void add(int index,Object obj) {
		rangeCheck(index);
		Node n = getNode(index);
		Node up = n.getPrevious();
		Node newNode = new Node();
		newNode.setObj(obj);
		if(n!=first) {
			n.setPrevious(newNode);
			newNode.setNext(n);
			
			up.setNext(newNode);
			newNode.setPrevious(up);
		}else {
			newNode.setPrevious(null);
			newNode.setNext(first);
			first.setPrevious(newNode);
			first = newNode;
		}
		size++;
		
	}
	
	public void remove(int index) {
		rangeCheck(index);
		Node n = getNode(index);
		if(n!=first) {
			n.getNext().setPrevious(n.getPrevious());
			n.getPrevious().setNext(n.getNext());
		}else {
			n.getNext().setPrevious(null);
			first = n.getNext();
		}
		size--;
	}
	
	public static void main(String[] args) {
		MyLinkedList mll = new MyLinkedList();
		mll.add("aaa");
		mll.add("bbb");
		mll.add("ccc");
		mll.add("ddd");
		mll.add("eee");
//		mll.add(0, "xxx");
		mll.remove(0);
		System.out.println(mll.getSize());
		System.out.println(mll.get(0));
	}
	
}

/**
 * 节点类
 * @author 银涛
 *
 */
class Node{
	private Node previous;
	private Object obj;
	private Node next;
	public Node() {
	}
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