package practiceGuava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 只读设置
 * @author 银涛
 *
 */
public class Demo01 {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		//对原有的list进行包装，相当于原有list的一个快照，不够安全
		List<String> readList = Collections.unmodifiableList(list);
		// java.lang.UnsupportedOperationException
		readList.add("d");//-->因为已经为不可修改对象，故会报错
		list.add("d");	//原有List试图也改变
		
		//对比查看 初始化List guava对只读设置安全可靠，并且相对简单
		List<String> immutableList = ImmutableList.of("a","b","c");
		immutableList.add("d");	//java.lang.UnsupportedOperationException
		
	}
}
