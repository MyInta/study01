package test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	//String name() ʵ���ǲ����� �Ͳ������� ���Ƿ���
	String name() default "";
	int age() default 0;
	int id() default -1;
	String[] schools() default {"�㽭��ѧ","���ݵ��ӿƼ���ѧ"};
}
