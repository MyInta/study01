package review;

/**
 * ����д���Լ���ArrayList��
 * @author ����
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
	 * �����ʼ��
	 */
	public MyArrayList() {
		this(16);
	}
	
	/**
	 * �Զ���������õ����鳤��
	 */
	public MyArrayList(int index) {
		if(index>0) {
			object = new Object[index];
		}else {
			try {
				throw new Exception("��������");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ȷ������ĳ����ڷ�Χ���ڡ��������򽫳��ȳ˶���
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
	 * ������Χ��⣬���������쳣
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
		//���������ڼ�֮���Ԫ�ؿ���ԭ��λ�ÿ���һλ����
		System.arraycopy(object, index, object, index+1, moveNum);
		object[index] = obj;
		return oldValue;
	}
	
	/**
	 * �Ƴ���������Ԫ��
	 * @param index ����
	 * @return �������Ƴ���Ԫ��ֵ
	 */
	public int remove(int index) {
		rangeCheck(index);
		int oldValue = (int) object[index];
		//ע��������ƶ����Ⱥ�add�������ƶ�������
		int moveLength = size-index-1;
		System.arraycopy(object, index+1, object, index, moveLength);
		//��ĩ��Ԫ���ÿգ�������ʱ��ûӰ�쵽��ֵ�仯��,���ҳߴ��һ
		object[--size] = null;
		return oldValue;
	}
	
	/**
	 * ����Ӧ����λ��Ԫ�ظ���
	 * @param index ����
	 * @param obj ��ֵ
	 * @return ��������ԭ��Ԫ��ֵ
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
			//����û����������Χ�����������Զ���Խ�緵��ֵ-1
			return -1;
		}
	}
	
}
