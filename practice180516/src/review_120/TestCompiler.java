package review_120;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class TestCompiler {
	public static void main(String[] args) throws IOException {
		String str = "public class Hi{\r\n" + 
				"	public static void main(String[] args){\r\n" + 
				"	String str= \""
				+ "inta �����ߵ���\"+\r\n" + 
				"\"javaѧϰ��һ��������\"+\r\n" + 
				"\"��������������\"+\r\n" + 
				"\"�ڲ��õĽ���\"+\r\n" + 
				"\"Inta�������ȡ��\"+\r\n" + 
				"\"��˶���ջ�\"+\r\n" + 
				"\"������Ϊ���ĵ������Ϻ���\";"
				+ "\r\n"+
				"	System.out.println(str);\r\n" + 
				"  	}\r\n" + 
				"\r\n" + 
				"}";
		File f = new File("F:/��Ƶ��ѧ/JAVA��ѧ/Practice/Compiler/Hi.java");
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(str);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JavaCompiler com = ToolProvider.getSystemJavaCompiler();
		int result = com.run(null,null,
				null,"F:/��Ƶ��ѧ/JAVA��ѧ/Practice/Compiler/Hi.java");
		System.out.println(result==0?"����ɹ�":"����ʧ��");
		
		//ʹ��Runtime�����µĽ���ִ��
		/*Runtime run = Runtime.getRuntime();
		Process process = run.exec("java -cp F:/��Ƶ��ѧ/JAVA��ѧ/Practice/Compiler	Hi");
		InputStream is = process.getInputStream();
		BufferedReader br =null;
		br = new BufferedReader(new InputStreamReader(is));
		String msg ="";
		while(null!=(msg=br.readLine())) {
			System.out.print(msg);
		}*/
		
		//ʹ�÷������
		try {
			URL[] url = new URL[] {new URL("file:/"+"F:/��Ƶ��ѧ/JAVA��ѧ/Practice/Compiler/")};
			URLClassLoader loader = new URLClassLoader(url);
			Class c = loader.loadClass("Hi");
			Method m = c.getMethod("main", String[].class);
			m.invoke(null, (Object)new String[] {/*"aaa","bbb"*/});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}
