package practiceGuava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * ֻ������
 * @author ����
 *
 */
public class Demo01 {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		//��ԭ�е�list���а�װ���൱��ԭ��list��һ�����գ�������ȫ
		List<String> readList = Collections.unmodifiableList(list);
		// java.lang.UnsupportedOperationException
		readList.add("d");//-->��Ϊ�Ѿ�Ϊ�����޸Ķ��󣬹ʻᱨ��
		list.add("d");	//ԭ��List��ͼҲ�ı�
		
		//�ԱȲ鿴 ��ʼ��List guava��ֻ�����ð�ȫ�ɿ���������Լ�
		List<String> immutableList = ImmutableList.of("a","b","c");
		immutableList.add("d");	//java.lang.UnsupportedOperationException
		
	}
}
