package test.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * �Զ���ۺ���
 * @author ����
 *
 */
public class ConcreteMyAggregate {
	private List<Object> list = new ArrayList<>();
	
	public void addObject(Object obj) {
		list.add(obj);
	}
	public void removeObject(Object obj) {
		list.remove(obj);
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	//��õ�����
	public MyIterator createIterator() {
		return new ConcreteIterator();
	}
	
	//ʹ���ڲ��ඨ�������������ֱ��ʹ���ⲿ������
	private class ConcreteIterator implements MyIterator{
		private int cursor;//�����α꣬���ڼ�¼����ʱ��λ��
		@Override
		public void first() {
			cursor = 0;
		}

		@Override
		public void last() {
			cursor = list.size()-1;
		}

		@Override
		public boolean hasNext() {
			if(cursor<list.size()) {
				return true;
			}
			return false;
		}

		@Override
		public boolean isFirst() {
			return cursor==0?true:false;
		}

		@Override
		public boolean isLast() {
			return cursor==(list.size()-1)?true:false;
		}

		@Override
		public Object getCurrentObj() {
			return list.get(cursor);
		}

		@Override
		public void next() {
			if(cursor<list.size()) {
				cursor++;
			}
		}
		
	}
}