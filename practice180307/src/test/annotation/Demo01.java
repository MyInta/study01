package test.annotation;
@MyAnnotation
public class Demo01 {
	@MyAnnotation(name="Inta",age=15,id=123,schools= {"����","����"})
	public void test01() {
	}
	
	@MyAnnotation02("aaa")	//���ֻ��һ�����ԣ�����ʡ����value=����һ����
	public void test02() {
		
	}
}
