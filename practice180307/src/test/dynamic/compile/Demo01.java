package test.dynamic.compile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * ��̬����
 */
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {
	public static void main(String[] args) throws IOException {
		//ͨ��IO�����������ַ����洢��һ����ʱ�ļ�(Hi.java)���ٵ��ö�̬���뷽��
		String str = "public class testCompiler{public static void main(String[] args){System.out.println(\"Hello World!\");}}";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "F:/��Ƶ��ѧ/JAVA��ѧ/Practice/Compiler/testCompiler.java"); 
		System.out.println(result==0?"����ɹ�":"����ʧ��");
		
		//ͨ��Runtime����ִ����
//		Runtime run = Runtime.getRuntime();
//		Process process = run.exec("java -cp F:/��Ƶ��ѧ/JAVA��ѧ/Practice/Compiler testCompiler");	//ע�⡰java���ͽ�ѧ��Ҫ�пո�
//		
//		InputStream in = process.getInputStream();
//		BufferedReader br = new BufferedReader(new InputStreamReader(in));
//		String info = "";
//		while((info=br.readLine())!=null) {
//			System.out.println(info);
//		}
		
		
		
		//ͨ���������б���õ���
		
		try {
			URL[] urls = new URL[] {new URL("file:/"+"F:/��Ƶ��ѧ/JAVA��ѧ/Practice/Compiler/")};
			URLClassLoader loader = new URLClassLoader(urls);
			Class c = loader.loadClass("testCompiler");
			//���ü������main����
			Method m = c.getMethod("main", String[].class);
			m.invoke(null, (Object)new String[] {});	//����ǿת������new String[]{"aa","bb"}Ĭ�ϱ���Ϊ(null,"aa","bb")
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
