package review_all;

/**
 * LinkedList�ײ��ǽڵ㴮���Ķ���
 * ��ArrayList�ײ�ʵ�ֲ�ͬ��������ArrayList�г�ʼ������
 * @author ����
 *
 */
public class MyLinkedList {
	//�ʼ�Ľڵ�
	private Node first;
	//���һ���ڵ�
	private Node last;
	//�����ʵ�ʳ���
	private int size;
	//get�������������
	public int getSize() {
		return size;
	}
	/**
	 * ����Ƿ�Խ��
	 * @param index
	 */
	private void rangeCheck(int index) {
		if(index<0||index>=size) {
			try {
				throw new Exception("����Խ��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ͨ��������ö�Ӧ�ڵ�
	 * @param index ����
	 * @return ���ز��ҵ��Ľڵ�
	 */
	public Node getNode(int index) {
		//�鿴�����Ƿ�Խ��
		rangeCheck(index);
		//����һ���½ڵ㲢��ʼ��Ϊ��
		Node n = null;
		//�����һ���ڵ㲻Ϊ�գ�˵���������Բ���
		if(null!=first) {
			//ʹ�ö��ַ����ұ��Щ����������������һ��֮��
			if(index<(size>>1)){
				//�Ƚ��ڵ�ŵ���һ���ڵ�λ��
				n = first;
				//��ʼ����������������Ѱ�ҵ���Ӧ�ڵ�
				for(int i=0;i<index;i++) {
					n=n.getNext();
				}
			}else {	//����ĵ���Ѱ��
				//�Ƚ��ڵ�ŵ����λ��
				n = last;
				//��ʼ����������Ѱ�Ҷ�Ӧ�����ڵ�
				for(int i=size-1;i>index;i--) {
					n = n.getPrevious();
				}
				
			}
		}
		return n;
	}
	/**
	 * ͨ��������ö�Ӧ����λ�õ�Ԫ��
	 * @param index ����
	 * @return ���ض�Ӧλ�õ�Ԫ��
	 */
	public Object get(int index) {
		//��������
		rangeCheck(index);
		//��ͨ��������ýڵ����
		Node n = getNode(index);
		//��������һ��Ĭ��Ϊ�յ�Ԫ��
		Object obj = null;
		//����ڵ㲻Ϊ�գ��򽫽ڵ��ڵ�Ԫ�ظ�ֵ���ö���
		if(null!=n) {
			//��ø������ڵ��Ԫ��
			obj = n.getObj();
		}
		return obj;
	}
	/**
	 * Ĭ���ڽڵ�֮�����һ��Ԫ��
	 * @param obj Ԫ��
	 */
	public void add(Object obj) {
		//�ȴ���һ���ڵ����Գ���Ԫ��
		Node n = new Node();
		//��Ԫ������ڵ���
		n.setObj(obj);
		n.setNext(null);
		//�����ͷ��Ԫ��Ϊ����
		if(null==first) {
			//�����½��Ľڵ�
			n.setPrevious(null);
			//�����µĵ�һ�������һ���ڵ�Ԫ��
			first = n;
			last = n;
		}else {
			//����˵���Ѿ����ڽڵ㣬����Ҫ�´���һ�Žڵ�
			//�൱����ͨ���������last��Ӧ�ڵ�����ĩ�˽ڵ�ǰ���ͨ
			n.setPrevious(last);
			last.setNext(n);
			//���ǵ�ԭ�ȵ�last���½���ĩ�˽ڵ�������
			last = n;
		}
		//��Ҫ����ÿ����ӳɹ�����������һ
		size++;
	}
	/**
	 * ͨ��������Ӷ�Ӧλ�õ�Ԫ��
	 * @param index ��Ӧ����
	 * @param obj Ԫ��
	 */
	public void add(int index,Object obj) {
		//��������
		rangeCheck(index);
		//ͨ���������ҵ��ڵ�
		Node n = getNode(index);
		//����һ���µ�Node���ں�����Ӳ���
		Node newNode = new Node();
		//����Ҫ��ӵ�Ԫ����ӵ��½�Node��
		newNode.setObj(obj);
		//�鿴��Ӧ�����Ƿ�Ϊ�׸�������Ӱ��ڵ�ǰ�õ�����
		if(n==first) {
			//�½��ڵ�ǰ�ڵ�Ϊ��
			newNode.setPrevious(null);
			//�½��ڵ��ڵ�����Ϊ���׸��ڵ�
			newNode.setNext(first);
			//���׸��ڵ�ǰ�ڵ���Ϊ�½��ڵ㣬��ͨ����ͨ
			first.setPrevious(newNode);
			//�������׸��ڵ�
			first = newNode;
		}else {
			//�����Ӧ���������׸�λ�ã�����Ҫһ��ǰ�ýڵ�Э��
			Node up = n.getPrevious();
			//���½��ڵ��ǰ�ýڵ���ΪЭ���ڵ�
			newNode.setPrevious(up);
			//��ǰ��Э���ڵ�ĺ��ýڵ���Ϊ�½��ڵ㣬ǰһͨ����ͨ
			up.setNext(newNode);
			//���½��ڵ�ĺ��ýڵ���Ϊ�ɽڵ�
			newNode.setNext(n);
			//���ɽڵ��ǰ�ýڵ���Ϊ�½��ڵ�,��һͨ����ͨ
			n.setPrevious(newNode);
		}
		//��󣬳�����һ
		size++;
	}
	/**
	 * ɾ����Ӧ����λ�õĽڵ�
	 * @param index
	 */
	public void remove(int index) {
		//��������
		rangeCheck(index);
		//��ø�����λ�õĽڵ�
		Node n = getNode(index);
		//��Ҫ���ǿ����Ƿ����׸��ڵ������
		if(n==first) {
			//�������λ�����׸��ڵ㣬���·���һ�ڵ��ǰһ�ڵ�Ϊ��
			n.getNext().setPrevious(null);
			first = n.getNext();
		}else {
			//˼·�ǽ����·��
			n.getPrevious().setNext(n.getNext());
			//���ǵ����ýڵ����Ϊ�գ�nΪlast�ڵ㣩
			if(null==n.getNext()) {
				//��Ϊ����ɾ���Ľڵ�Ϊlast������ֱ��ʡȥ�˹�ͨ��һ����̣�������
				last = n.getPrevious();
			}else {
				n.getNext().setPrevious(n.getPrevious());
			}
		}
		//��������ȼ�һ
		size--;
	}
	
	//����
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
	//�ڵ�ǰ�ڵ�
	private Node previous;
	//�ڵ㵱ǰ����
	private Object obj;
	//�ڵ��һ�ڵ�
	private Node next;
	//�չ�����
	public Node() {
	}
	/**
	 * ���ι���
	 * @param previous ǰ�ڵ�
	 * @param obj ��ǰ����
	 * @param next ��һ�ڵ�
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