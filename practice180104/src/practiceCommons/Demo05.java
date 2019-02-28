package practiceCommons;

import java.util.Queue;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.QueueUtils;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;

/**
 * Queue����
 * 1��ѭ������
 * 	  circular
 * 2��ֻ��
 * 	  readOnly-->�൱��JDK�����unmodifiable
 * 3������
 * 	  Predicate
 * @author ����
 *
 */
public class Demo05 {

	public static void main(String[] args) {
//		circular();
//		readOnly();
		predicate();
	}
	/**
	 * ѭ������
	 */
	public static void circular() {
		//ʵ�����Ƚ��ȳ�����
		CircularFifoQueue<String> que = new CircularFifoQueue<>(2);//2��ʾ��������Ԫ�أ��Ƚ��ȳ�
		que.add("a");
		que.add("b");
		que.add("c");
		for(String str:que) {
			System.out.println(str);
		}
	}
	/**
	 * ֻ��
	 */
	public static void readOnly() {
		CircularFifoQueue<String> que = new CircularFifoQueue<>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Queue<String> readOnly = UnmodifiableQueue.unmodifiableQueue(que);
		//readOnly.add("d");//java.lang.UnsupportedOperationException
	}
	/**
	 * ����
	 */
	public static void predicate() {
		CircularFifoQueue<String> que = new CircularFifoQueue<>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Predicate notNull = NotNullPredicate.INSTANCE;
		//��װ�ɶ�Ӧ�ж��µĶ���
		Queue<String> que2 = PredicatedQueue.predicatedQueue(que, notNull);
		que2.add(null);
	}
}
