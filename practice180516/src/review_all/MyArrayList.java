package review_all;

/**
 * ArrayList�ײ�������
 * @author ����
 *
 */
public class MyArrayList {
	//Array����ʵ�ʳ���
	private int size;
	//Array��������
	private Object[] object;
	//set get ����
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * �չ�����
	 */
	public MyArrayList() {
		//���ô��ι��죬��ʼ�����鳤��
		this(16);
	}
	/**
	 * ���ι��죬ָ����������ĳ���
	 * @param index
	 */
	public MyArrayList(int index) {
		if(index>0){
			//�������ȵ���Ϊָ������
			object = new Object[size];
		}else{
			try {
				throw new Exception("���õĳ��Ȳ��Ϸ���");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ȷ�����������鳤�Ⱥ���
	 * @param len
	 */
	public Object[] ensureCapcity(int len) {
		//�����Ҫȷ���ĳ��ȳ��������������ȣ�����x2
		if(len>=object.length) {
			//�����µ�����
			Object[] newObj = new Object[len*2];
			//�������ݿ�������������ȥ
			System.arraycopy(object, 0, newObj, 0, object.length);
			//���ǵ�������
			object = newObj;
		}
		//���õ������ݺ�����鷵��
		return object;
	}
	/**
	 * �����������Խ�磨��Ҫ�������鳤�ȣ�
	 * @param index
	 */
	public void checkRange(int index) {
		//�������С��0���ߴ�������ʵ�ʳ��ȣ��������������ȣ���
		if(index<0||index>size-1) {
			try {
				throw new Exception("����Խ��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ������ĩ�����Ԫ��
	 * @param obj ��Ԫ��
	 */
	public void add(Object obj) {
		//ȷ�����Ԫ�ص�ʱ�����鳤�ȹ���
		ensureCapcity(++size);
		//������ʵ�ʳ���ĩ�����Ԫ��
		object[size-1] = obj;
		//����object[size] = obj;size++;ensureCapcity(size);
	}
	/**
	 * ͨ������ָ��λ�����Ԫ��
	 * @param index ָ��������
	 * @param obj ��ӵ�Ԫ��
	 */
	public void add(int index,Object obj) {
		//��������Ƿ�Խ��
		checkRange(index);
		//ȷ�����Ԫ�ص�ʱ�����鳤�ȹ���
		ensureCapcity(++size);
		//��Ҫ���ƶ�Ԫ�صĸ���,Ʃ�糤��5����3(ʵ��Ԫ��4)λ�ã���Ҫ�ƶ�5-3��Ԫ��
		int moveLen = size-index;
		//���������ƶ���������λ��
		System.arraycopy(object, index, object, index+1, moveLen);
		//������λ�õĵط�������Ԫ��
		object[index] = obj;
	}
	/**
	 * ָ������λ���Ƴ�Ԫ��
	 * @param index ����
	 * @return ���Ƴ���Ԫ��ֵ
	 */
	public Object remove(int index) {
		//��������Ƿ�Խ��
		checkRange(index);
		//���ԭ�ȵ�Ԫ��ֵ
		Object oldObj = object[index];
		//��Ҫ���ƶ�Ԫ�صĸ���,Ʃ�糤��5����3(ʵ��Ԫ��4)λ�ã���Ҫ�ƶ�5-3-1��Ԫ��
		int removeLen = size-index-1;
		//����Ԫ���ƶ�����Ԫ��λ��
		System.arraycopy(object, index+1, object, index, removeLen);
		//����ʵ�ʳ��ȼ�һ,������ĩ��Ԫ��ֵΪ��
		object[--size]=null;
		//���������Ƴ���Ԫ��ֵ
		return oldObj;
	}
	/**
	 * ����Ӧ����λ��Ԫ�ظ���
	 * @param index ����
	 * @param obj ��ֵ
	 * @return ��������ԭ��Ԫ��ֵ
	 */
	public Object set(int index,Object obj) {
		//��������Ƿ�Խ��
		checkRange(index);
		Object OldValue = object[index];
		object[index] = obj;
		return OldValue;
	}
	
	public Object get(int index) {
		if(index>=0&&index<size) {
			return object[index];
		}else {
			//����û����������Χ�����������Զ���Խ�緵��ֵ-1
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
