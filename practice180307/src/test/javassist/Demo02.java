package test.javassist;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

/**
 * 测试javassist的API
 * @author 银涛
 *
 */
public class Demo02 {
	/**
	 * 处理类的基本用法
	 * @throws NotFoundException 
	 * @throws CannotCompileException 
	 * @throws IOException 
	 */
	public static void test01() throws NotFoundException, IOException, CannotCompileException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.javassist.Emp");
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		System.out.println(cc.getName());	//获得类名
		System.out.println(cc.getSimpleName());//获得简要类名
		System.out.println(cc.getSuperclass());//获得父类
		System.out.println(cc.getInterfaces());	//获取接口
	}
	
	public static void test02() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.javassist.Emp");
		
		CtMethod m = new CtMethod(CtClass.intType, "add", 
							new CtClass[] {CtClass.intType,CtClass.intType}, cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("return $1+$2;");
		cc.addMethod(m);
		
		//通过调用反射新生成方法
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();	//调用无参构造，生成新的Emp对象
		Method method = clazz.getDeclaredMethod("add", int.class,int.class);
		int result = (int) method.invoke(obj,200, 300);
		System.out.println(result);
		
	}
	/**
	 * 修改已有方法的信息
	 * @throws Exception
	 */
	public static void test03() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.javassist.Emp");
		
		CtMethod cm = cc.getDeclaredMethod("sayHello",new CtClass[] {CtClass.intType});
		cm.insertBefore("System.out.println($1);System.out.println(\"Start!\");");
		cm.insertAt(8, "int b =3;System.out.println(\"b=\"+b);");	//在某行修改加入信息
		cm.insertAfter("System.out.println(\"End~\");");
		
		//通过调用反射新生成方法
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();	//调用无参构造，生成新的Emp对象
		Method method = clazz.getDeclaredMethod("sayHello", int.class);
		Object result = method.invoke(obj,200);
	}
	/**
	 * 定义属性
	 * @throws Exception
	 */
	public static void test04() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.javassist.Emp");
		
		//CtField f1 = CtField.make("private int empno;", cc);
		CtField f1 = new CtField(CtClass.intType,"salary", cc);
		f1.setModifiers(Modifier.PRIVATE);
		cc.addField(f1,"1000");	//后面为添加的默认值
		//获取指定属性
		//cc.getDeclaredField("empno");
		
		//增加相应的set和get方法
		cc.addMethod(CtNewMethod.getter("getSalary", f1));
		cc.addMethod(CtNewMethod.getter("setSalary", f1));
	}
	/**
	 * 构造器
	 * @throws Exception
	 */
	public static void test05() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.javassist.Emp");
		
		CtConstructor[] cs = cc.getConstructors();
		for(CtConstructor c:cs) {
			System.out.println(c.getLongName());
		}
	}
	
	public static void main(String[] args) throws Exception {
		test05();
	}
}
