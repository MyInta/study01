package test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	//String name() 实际是参数名 和参数类型 而非方法
	String name() default "";
	int age() default 0;
	int id() default -1;
	String[] schools() default {"浙江大学","杭州电子科技大学"};
}
