package practice04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * ʹ��Collections
 * @author ����
 *
 */
public class NewItemApp {
	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem("ţ���ǹ����ˣ�������ף",100,new Date()));
		news.add(new NewsItem("�����������о�Ժ��",180,new Date(System.currentTimeMillis()-1000*60*60)));
		news.add(new NewsItem("��Ʊ�����������켱����",150,new Date(System.currentTimeMillis()+1000*60*60)));
		news.add(new NewsItem("����è˫��̥����������",250,new Date(System.currentTimeMillis()-1000*60*60*2)));
		System.out.println("����ǰ��"+news);
		System.out.println("============================");
		Collections.sort(news);
//		Utils.sort(news);
		System.out.println("�����:"+news);
	}
}
