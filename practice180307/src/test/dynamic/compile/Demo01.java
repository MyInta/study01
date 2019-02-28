package test.dynamic.compile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 动态编译
 */
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {
	public static void main(String[] args) throws IOException {
		//通过IO流操作，将字符串存储成一个临时文件(Hi.java)，再调用动态编译方法
		String str = "public class testCompiler{public static void main(String[] args){System.out.println(\"Hello World!\");}}";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "F:/视频教学/JAVA教学/Practice/Compiler/testCompiler.java"); 
		System.out.println(result==0?"编译成功":"编译失败");
		
		//通过Runtime调用执行类
//		Runtime run = Runtime.getRuntime();
//		Process process = run.exec("java -cp F:/视频教学/JAVA教学/Practice/Compiler testCompiler");	//注意“java”和教学后都要有空格
//		
//		InputStream in = process.getInputStream();
//		BufferedReader br = new BufferedReader(new InputStreamReader(in));
//		String info = "";
//		while((info=br.readLine())!=null) {
//			System.out.println(info);
//		}
		
		
		
		//通过反射运行编译好的类
		
		try {
			URL[] urls = new URL[] {new URL("file:/"+"F:/视频教学/JAVA教学/Practice/Compiler/")};
			URLClassLoader loader = new URLClassLoader(urls);
			Class c = loader.loadClass("testCompiler");
			//调用加载类的main方法
			Method m = c.getMethod("main", String[].class);
			m.invoke(null, (Object)new String[] {});	//必需强转，避免new String[]{"aa","bb"}默认编译为(null,"aa","bb")
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
