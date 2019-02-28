package test.composite;

public class Client {
	public static void main(String[] args) {
		AbstractFile f2,f3,f4,f5;
		Folder f1 = new Folder("一号文件夹");
		f2 = new ImageFile("Intadd.jpg");
		f3 = new TextFile("小文件01.txt");
		f1.add(f2);
		f1.add(f3);
		
		Folder f11 = new Folder("一号内的小视频文件夹");
		f4 = new VideoFile("周星驰.avi");
		f5 = new VideoFile("周润发.avi");
		f11.add(f4);
		f11.add(f5);
		
		f1.add(f11);
		f1.killVirus();
	}
}
