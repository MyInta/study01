package practice02;
/**
 * 测试链表类的数组的重写
 * @author 银涛
 *
 */
public class MyLinkList {
	private Node first;
	private Node last;
	private int size;

	public int size() {
		return size;
	}
	//索引范围检测
	public void rangCheck(int index) {
		if(index<0||index>=size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//获得对应索引的节点信息
	public Node getNode(int index) {
		rangCheck(index);
		Node temp = null;
		if(first!=null) {
			//增加判断，加速筛选，原理上即二分法
			if(index<(size>>1)) {
				temp = first;
				for(int i=0;i<index;i++) {
					temp=temp.getNext();
				}
			}else {
				temp = last;
				for(int i=size-1;i>index;i--){
					temp=temp.getPrevious();
				}
			}
		}
		return temp;
	}
	//往链表里增加一个对象
	public void add(Object obj) {
		Node n = new Node();
		if(first==null) {
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			
			first = n;
			last = n;
		}else {
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			//此时last地址为老的最后一个节点
			last.setNext(n);
			//取消原有last位置的节点node，设置新的last节点
			last = n;
		}
		size++;
	}
	//直接获得对应索引元素的Obj
	public Object get(int index) {
		Node temp = getNode(index);
		if(temp!=null) {
			return temp.getObj();
		}
		return null;
	}
	//移除对应索引的节点
	public void remove(int index) {
		Node temp = getNode(index);
		
		Node up = temp.getPrevious();
		Node down= temp.getNext();
		//打通原节点前后两个节点的连接，相当于短路掉原节点
		up.setNext(down);
		down.setPrevious(up);
		
		size--;
	}
	//往对应索引位置增加一个节点
	public void addNode(int index,Object obj) {
		Node temp = getNode(index);
		Node newNode =new Node();	//不能为null 否则插入index的位置报空指针，为什么？？？因为还没创建对象，没有setPrevious等方法。
		if(temp!=first) {
			//打通新节点与对应位置前节点的连接
			newNode.setPrevious(temp.getPrevious());
			temp.getPrevious().setNext(newNode);;
			//打通新节点与对应位置后节点的连接
			newNode.setNext(temp);
			temp.setPrevious(newNode);
		}else {
			newNode.setPrevious(null);
			newNode.setNext(temp);
			temp.setPrevious(newNode);
			first = newNode;
		}
		newNode.setObj(obj);
		size++;
	}
	
	public static void main(String[] args) {
		MyLinkList list = new MyLinkList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
//		System.out.println(list.getNode(2).getObj());
		list.addNode(2, "新元素");//注意插入位置是在原有索引元素之前
		System.out.println(list.size);
//		list.remove(1);	//会存在去0时候的空指针异常，看practice180516里面的review MyLinkedList
		System.out.println(list.get(2));
	}
}


//定义节点，以利于构建链表
class Node{
	private Node previous;
	private Object obj;
	private Node next;
	//构建一个空构造器
	public Node() {
	}
	//Set and Get
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