package review_120;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineTest {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException {
		//��ýű��������
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//����������洢��������������
		engine.put("msg", "Inta is the king of the world!");
		String str = "var user = {name:'Inta',age:24,school:['HDU','Scut']};";
		str +="print(user.name);";
		
		//ִ�нű�
		engine.eval(str);
		engine.eval("msg='Dont giveup!';");	//ͨ��JS�޸��˴洢������Ϣ
		System.out.println(engine.get("msg"));
		
		//���庯��
		engine.eval("function add(a,b){var sum=a+b;return sum;}");
		//ʹ��Invocableǿת��ȡ�õ��ýӿ�
		Invocable invo = (Invocable) engine;
		//ִ�нű��еķ���
		Object result = invo.invokeFunction("add", new Object[] {2,3});
		System.out.println(result);
	}
}
