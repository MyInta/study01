package test.composite;

public class Client {
	public static void main(String[] args) {
		AbstractFile f2,f3,f4,f5;
		Folder f1 = new Folder("һ���ļ���");
		f2 = new ImageFile("Intadd.jpg");
		f3 = new TextFile("С�ļ�01.txt");
		f1.add(f2);
		f1.add(f3);
		
		Folder f11 = new Folder("һ���ڵ�С��Ƶ�ļ���");
		f4 = new VideoFile("���ǳ�.avi");
		f5 = new VideoFile("����.avi");
		f11.add(f4);
		f11.add(f5);
		
		f1.add(f11);
		f1.killVirus();
	}
}
