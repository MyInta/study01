package test.annotation;
@MyAnnotation
public class Demo01 {
	@MyAnnotation(name="Inta",age=15,id=123,schools= {"杭电","政法"})
	public void test01() {
	}
	
	@MyAnnotation02("aaa")	//如果只有一个属性，可以省掉“value=”这一部分
	public void test02() {
		
	}
}
