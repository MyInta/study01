package testIo_file;

import java.io.File;


/**
 * 两个常量
 * 1、路径分隔符
 * 2、名称分割符 \（windows） --&-- /（Linux 等）
 * @author 银涛
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);	//相当于就是“;”。
		System.out.println(File.separator); 	//相当于“\” 
		//路径表示
		String path = "F:\\图片\\用途\\JAVA相关\\Plane"; //eclipse已经实现自动生成\\避免\单个的转换功能
		path = "F:"+File.separator+"图片"+File.separator+"用途"+File.separator+
				"JAVA相关"+File.separator+"Plane";		//推荐在动态生成中使用，定值不建议使用
		path = "F:/图片/用途/JAVA相关/Plane";				//Ctrl+F替换掉\\为/
		System.out.println(path);
	}
}
