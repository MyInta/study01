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
 * Queue队列
 * 1、循环队列
 * 	  circular
 * 2、只读
 * 	  readOnly-->相当于JDK里面的unmodifiable
 * 3、断言
 * 	  Predicate
 * @author 银涛
 *
 */
public class Demo05 {

	public static void main(String[] args) {
//		circular();
//		readOnly();
		predicate();
	}
	/**
	 * 循环队列
	 */
	public static void circular() {
		//实现了先进先出队列
		CircularFifoQueue<String> que = new CircularFifoQueue<>(2);//2表示容纳两个元素，先进先出
		que.add("a");
		que.add("b");
		que.add("c");
		for(String str:que) {
			System.out.println(str);
		}
	}
	/**
	 * 只读
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
	 * 断言
	 */
	public static void predicate() {
		CircularFifoQueue<String> que = new CircularFifoQueue<>(2);
		que.add("a");
		que.add("b");
		que.add("c");
		Predicate notNull = NotNullPredicate.INSTANCE;
		//包装成对应判断下的队列
		Queue<String> que2 = PredicatedQueue.predicatedQueue(que, notNull);
		que2.add(null);
	}
}
