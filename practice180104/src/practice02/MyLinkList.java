package practice02;
/**
 * ������������������д
 * @author ����
 *
 */
public class MyLinkList {
	private Node first;
	private Node last;
	private int size;

	public int size() {
		return size;
	}
	//������Χ���
	public void rangCheck(int index) {
		if(index<0||index>=size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//��ö�Ӧ�����Ľڵ���Ϣ
	public Node getNode(int index) {
		rangCheck(index);
		Node temp = null;
		if(first!=null) {
			//�����жϣ�����ɸѡ��ԭ���ϼ����ַ�
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
	//������������һ������
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
			//��ʱlast��ַΪ�ϵ����һ���ڵ�
			last.setNext(n);
			//ȡ��ԭ��lastλ�õĽڵ�node�������µ�last�ڵ�
			last = n;
		}
		size++;
	}
	//ֱ�ӻ�ö�Ӧ����Ԫ�ص�Obj
	public Object get(int index) {
		Node temp = getNode(index);
		if(temp!=null) {
			return temp.getObj();
		}
		return null;
	}
	//�Ƴ���Ӧ�����Ľڵ�
	public void remove(int index) {
		Node temp = getNode(index);
		
		Node up = temp.getPrevious();
		Node down= temp.getNext();
		//��ͨԭ�ڵ�ǰ�������ڵ�����ӣ��൱�ڶ�·��ԭ�ڵ�
		up.setNext(down);
		down.setPrevious(up);
		
		size--;
	}
	//����Ӧ����λ������һ���ڵ�
	public void addNode(int index,Object obj) {
		Node temp = getNode(index);
		Node newNode =new Node();	//����Ϊnull �������index��λ�ñ���ָ�룬Ϊʲô��������Ϊ��û��������û��setPrevious�ȷ�����
		if(temp!=first) {
			//��ͨ�½ڵ����Ӧλ��ǰ�ڵ������
			newNode.setPrevious(temp.getPrevious());
			temp.getPrevious().setNext(newNode);;
			//��ͨ�½ڵ����Ӧλ�ú�ڵ������
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
		list.addNode(2, "��Ԫ��");//ע�����λ������ԭ������Ԫ��֮ǰ
		System.out.println(list.size);
//		list.remove(1);	//�����ȥ0ʱ��Ŀ�ָ���쳣����practice180516�����review MyLinkedList
		System.out.println(list.get(2));
	}
}


//����ڵ㣬�����ڹ�������
class Node{
	private Node previous;
	private Object obj;
	private Node next;
	//����һ���չ�����
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