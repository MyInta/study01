package test.iterator;
/**
 * 自定义迭代器接口
 * @author 银涛
 *
 */
public interface MyIterator {
	void first();	//将游标指向第一个元素
	void last();	//将游标指向最后一个元素
	void next();
	boolean hasNext();	//判断是否有下一个元素
	
	boolean isFirst();
	boolean isLast();
	
	Object getCurrentObj();	//获取当前游标指向对象
}
