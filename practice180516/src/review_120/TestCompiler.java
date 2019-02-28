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
				+ "inta 终于走到了\"+\r\n" + 
				"\"java学习的一条正轨上\"+\r\n" + 
				"\"我们有理由相信\"+\r\n" + 
				"\"在不久的将来\"+\r\n" + 
				"\"Inta将会从中取得\"+\r\n" + 
				"\"丰硕的收获\"+\r\n" + 
				"\"让我们为王的诞生献上贺礼\";"
				+ "\r\n"+
				"	System.out.println(str);\r\n" + 
				"  	}\r\n" + 
				"\r\n" + 
				"}";
		File f = new File("F:/视频教学/JAVA教学/Practice/Compiler/Hi.java");
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
				null,"F:/视频教学/JAVA教学/Practice/Compiler/Hi.java");
		System.out.println(result==0?"编译成功":"编译失败");
		
		//使用Runtime启动新的进程执行
		/*Runtime run = Runtime.getRuntime();
		Process process = run.exec("java -cp F:/视频教学/JAVA教学/Practice/Compiler	Hi");
		InputStream is = process.getInputStream();
		BufferedReader br =null;
		br = new BufferedReader(new InputStreamReader(is));
		String msg ="";
		while(null!=(msg=br.readLine())) {
			System.out.print(msg);
		}*/
		
		//使用反射调用
		try {
			URL[] url = new URL[] {new URL("file:/"+"F:/视频教学/JAVA教学/Practice/Compiler/")};
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
