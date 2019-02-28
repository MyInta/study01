package testIo_others;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件分割 思路
 * 1、分割块数 size
 * 2、每一块的大小 blockSize
 * 	  最后一块的大小，总的文件大小-（n-1）blockSize
 * @author 银涛
 *
 */
public class RndDemo07 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(
				new File("F:/图片/用途/JAVA相关/Plane/test01.txt"
						)
				,"r");//r为参数，只读
		raf.seek(20);//从文件内容第几处开始
		//定义缓存
		byte[] flush = new byte[30];
		int len = 0;
		//没搞懂下面语句的逻辑问题，break?以及切割输出的大小80？
		//就是只显示80字节范围内的信息，不显示所有
		while(-1!=(len=raf.read(flush))) {
			if(len>80) {
				System.out.println(new String(flush,0,80));
				break;
			}else {
				System.out.println(new String(flush,0,len));
			}
		}
		testIo_util.FileUtil.close(raf);
	}
}
