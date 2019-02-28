package practice05;
/**
 * 测试自定义堆栈
 * @author 银涛
 *
 */
public class TestMyStack {
	public static void main(String[] args) {
		MyStack<String> nest = new MyStack<String>(3);
		nest.push("游啊游啊游");
		nest.push("在池塘里");
		nest.push("快乐的小青蛙");
		nest.push("很开森");
		System.out.println(nest.size());
		
		//遍历
		String item = null;
		while(null!=(item=nest.pop())) {
			System.out.println(item);
		}
	}
}
