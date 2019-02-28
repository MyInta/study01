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
 * ����javassist��API
 * @author ����
 *
 */
public class Demo02 {
	/**
	 * ������Ļ����÷�
	 * @throws NotFoundException 
	 * @throws CannotCompileException 
	 * @throws IOException 
	 */
	public static void test01() throws NotFoundException, IOException, CannotCompileException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.javassist.Emp");
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		System.out.println(cc.getName());	//�������
		System.out.println(cc.getSimpleName());//��ü�Ҫ����
		System.out.println(cc.getSuperclass());//��ø���
		System.out.println(cc.getInterfaces());	//��ȡ�ӿ�
	}
	
	public static void test02() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.javassist.Emp");
		
		CtMethod m = new CtMethod(CtClass.intType, "add", 
							new CtClass[] {CtClass.intType,CtClass.intType}, cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("return $1+$2;");
		cc.addMethod(m);
		
		//ͨ�����÷��������ɷ���
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();	//�����޲ι��죬�����µ�Emp����
		Method method = clazz.getDeclaredMethod("add", int.class,int.class);
		int result = (int) method.invoke(obj,200, 300);
		System.out.println(result);
		
	}
	/**
	 * �޸����з�������Ϣ
	 * @throws Exception
	 */
	public static void test03() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.javassist.Emp");
		
		CtMethod cm = cc.getDeclaredMethod("sayHello",new CtClass[] {CtClass.intType});
		cm.insertBefore("System.out.println($1);System.out.println(\"Start!\");");
		cm.insertAt(8, "int b =3;System.out.println(\"b=\"+b);");	//��ĳ���޸ļ�����Ϣ
		cm.insertAfter("System.out.println(\"End~\");");
		
		//ͨ�����÷��������ɷ���
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();	//�����޲ι��죬�����µ�Emp����
		Method method = clazz.getDeclaredMethod("sayHello", int.class);
		Object result = method.invoke(obj,200);
	}
	/**
	 * ��������
	 * @throws Exception
	 */
	public static void test04() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.javassist.Emp");
		
		//CtField f1 = CtField.make("private int empno;", cc);
		CtField f1 = new CtField(CtClass.intType,"salary", cc);
		f1.setModifiers(Modifier.PRIVATE);
		cc.addField(f1,"1000");	//����Ϊ��ӵ�Ĭ��ֵ
		//��ȡָ������
		//cc.getDeclaredField("empno");
		
		//������Ӧ��set��get����
		cc.addMethod(CtNewMethod.getter("getSalary", f1));
		cc.addMethod(CtNewMethod.getter("setSalary", f1));
	}
	/**
	 * ������
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
