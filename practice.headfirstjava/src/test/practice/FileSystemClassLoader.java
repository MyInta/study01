package test.practice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemClassLoader extends ClassLoader{
	private String rootDir;
	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		//应该要先查询有没有加载过此类，如果加载直接返回，反之加载新类。
		if(c!=null) {
			return c;
		}else {
			ClassLoader parent = getParent();
			try {
				c = parent.loadClass(name);
			} catch (Exception e) {

			}
			if(c!=null) {
				return c;
			}else {
				byte[] classData = getClassData(name);
				if(classData==null) {
					throw new ClassNotFoundException();
				}else {
					c = defineClass(name, classData,0,classData.length);
				}
			}
		}
		return c;
	}
	private byte[] getClassData(String className) {
		String path = rootDir + "/"+className.replace('.', '/')+".class";
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			is = new FileInputStream(path);
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len=is.read(buffer))!=-1) {
				baos.write(buffer, 0, len);
			}
			return baos.toByteArray();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(baos!=null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
