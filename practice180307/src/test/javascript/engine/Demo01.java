package test.javascript.engine;

import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * ���Խű�����ִ��javascrip����
 * @author ����
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException {
		//��ȡ�ű��������
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//����������洢������������
		engine.put("msg", "Inta is studying");
		String str = "var user = {name:'Inta',age:15,schools:['������ѧ','����','���']};";	//�����;��Ҫ��
		str += "print(user.name);";	//ͬ��;������
		
		//ִ�нű�
		engine.eval(str);
		engine.eval("msg = 'Inta is playing';");
		System.out.println(engine.get("msg"));
		System.out.println("===================");
		
		//���庯��
		engine.eval("function add(a,b){var sum = a+b;return sum;}");
		//ִ��js����
		Invocable jsInvoke = (Invocable) engine;
		Object result1 = jsInvoke.invokeFunction("add", new Object[] {2,3});
		System.out.println(result1);
		
		//��������java����ʹ�ð��ڵ�java��
		String jsCode = "var list = java.util.Arrays.asList([\"���찲\",\"����\",\"����\"]);";
		engine.eval(jsCode);
		List<String> list2 = (List<String>) engine.get("list");
		for(String temp : list2) {
			System.out.println(temp);
		}
	}
}
