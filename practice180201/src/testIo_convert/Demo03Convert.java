package testIo_convert;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 问题？如何实现不用Reader和Writer
 * 实现字符集的改变-->用"utf-8"到"gbk"的乱码的产生
 * 有待实现-->2018-2-7
 * @author 银涛
 *
 */
public class Demo03Convert {

	public static void main(String[] args) throws IOException {
		String srcStr = new String("F:/图片/用途/JAVA相关/Plane/Demo06.java");
		String destStr = "F:/图片/用途/JAVA相关/Plane/Demo08.java";
		File src = new File(srcStr);
		File dest = new File(destStr);
		//指定解码字符集
		BufferedInputStream br = new BufferedInputStream(	
						new FileInputStream(src));
		//写出文件
		BufferedOutputStream bw = new BufferedOutputStream(
						new FileOutputStream(dest));	
		byte[] date = new byte[1024];
		int len =0;
		while(-1!=(len=br.read(date))) {
			bw.write(date, 0, len);
		}
		bw.flush();
		testIo_util.FileUtil.close(bw,br);
	}

}
