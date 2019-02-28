package test.javascript.engine;

import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 测试脚本引擎执行javascrip代码
 * @author 银涛
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException {
		//获取脚本引擎对象
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//定义变量，存储到引擎上下文
		engine.put("msg", "Inta is studying");
		String str = "var user = {name:'Inta',age:15,schools:['北京大学','杭电','浙大']};";	//里面的;不要忘
		str += "print(user.name);";	//同样;不能忘
		
		//执行脚本
		engine.eval(str);
		engine.eval("msg = 'Inta is playing';");
		System.out.println(engine.get("msg"));
		System.out.println("===================");
		
		//定义函数
		engine.eval("function add(a,b){var sum = a+b;return sum;}");
		//执行js函数
		Invocable jsInvoke = (Invocable) engine;
		Object result1 = jsInvoke.invokeFunction("add", new Object[] {2,3});
		System.out.println(result1);
		
		//导入其他java包，使用包内的java类
		String jsCode = "var list = java.util.Arrays.asList([\"行黛安\",\"杭电\",\"广州\"]);";
		engine.eval(jsCode);
		List<String> list2 = (List<String>) engine.get("list");
		for(String temp : list2) {
			System.out.println(temp);
		}
	}
}
