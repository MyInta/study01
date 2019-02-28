package practice04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 使用Collections
 * @author 银涛
 *
 */
public class NewItemApp {
	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem("牛琦涨工资了，室友庆祝",100,new Date()));
		news.add(new NewsItem("陈文妹子来研究院了",180,new Date(System.currentTimeMillis()-1000*60*60)));
		news.add(new NewsItem("车票抢不到，都快急死了",150,new Date(System.currentTimeMillis()+1000*60*60)));
		news.add(new NewsItem("大熊猫双胞胎宝宝出世了",250,new Date(System.currentTimeMillis()-1000*60*60*2)));
		System.out.println("排序前："+news);
		System.out.println("============================");
		Collections.sort(news);
//		Utils.sort(news);
		System.out.println("排序后:"+news);
	}
}
