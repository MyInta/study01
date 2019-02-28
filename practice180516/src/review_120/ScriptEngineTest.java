package review_120;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineTest {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException {
		//获得脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//定义变量，存储到引擎上下文中
		engine.put("msg", "Inta is the king of the world!");
		String str = "var user = {name:'Inta',age:24,school:['HDU','Scut']};";
		str +="print(user.name);";
		
		//执行脚本
		engine.eval(str);
		engine.eval("msg='Dont giveup!';");	//通过JS修改了存储对象信息
		System.out.println(engine.get("msg"));
		
		//定义函数
		engine.eval("function add(a,b){var sum=a+b;return sum;}");
		//使用Invocable强转后取得调用接口
		Invocable invo = (Invocable) engine;
		//执行脚本中的方法
		Object result = invo.invokeFunction("add", new Object[] {2,3});
		System.out.println(result);
	}
}
