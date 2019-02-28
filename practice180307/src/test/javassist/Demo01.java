package test.javassist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * 测试javassist生成一个新的类
 * @author 银涛
 *
 */
public class Demo01 {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("test.bean.Emp");
		
		//创建属性
		CtField f1 = CtField.make("private int empno;", cc);
		CtField f2 = CtField.make("private String ename;", cc);
		cc.addField(f1);
		cc.addField(f2);
		
		//创建方法
		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
		CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno = empno;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//创建构造器
		CtConstructor constructor = new CtConstructor(new CtClass[] {CtClass.intType,pool.get("java.lang.String")}, cc);
		constructor.setBody("{this.empno=empno;this.ename = ename;}");//构造构造体的方法体
		cc.addConstructor(constructor);
		
		cc.writeFile("F:/视频教学/JAVA教学");
		System.out.println("生成类，成功");
		
		
	}
	
}
