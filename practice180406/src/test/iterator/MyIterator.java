package test.iterator;
/**
 * �Զ���������ӿ�
 * @author ����
 *
 */
public interface MyIterator {
	void first();	//���α�ָ���һ��Ԫ��
	void last();	//���α�ָ�����һ��Ԫ��
	void next();
	boolean hasNext();	//�ж��Ƿ�����һ��Ԫ��
	
	boolean isFirst();
	boolean isLast();
	
	Object getCurrentObj();	//��ȡ��ǰ�α�ָ�����
}
