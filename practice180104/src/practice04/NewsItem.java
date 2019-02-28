package practice04;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 新闻条目实体类
 * @author 银涛
 *
 */
public class NewsItem implements java.lang.Comparable<NewsItem>{
	//标题
	private String title;
	//点击量
	private int hits;
	//时间
	private Date pubTime;
	public NewsItem() {
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	public NewsItem(String title, int hits, Date pubTime) {
		super();
		this.title = title;
		this.hits = hits;
		this.pubTime = pubTime;
	}
	/**
	 * 给该类型作比较的时候，设定一个新的比较方式，方便以后用来比较对象大小
	 * 单独的非基础类型对象如果后续要排序，都建议重写对比方法，继承Comparable包，重写compareTo即可
	 */
	//按时间降序，点击量升序，标题降序
	@Override
	public int compareTo(NewsItem arg0) {
		int result = 0;
		//比较时间
		result = -this.pubTime.compareTo(arg0.pubTime);//降序
		if(0==result) {//时间相同
			//看点击量
			result = this.hits-arg0.hits;//升序
			if(0==result) {//点击量相同
				result = -this.title.compareTo(arg0.title);//降序
			}
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("标题：").append(this.title);
		sb.append(",时间:").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.pubTime));
		sb.append(",点击量:").append(this.hits).append('\n');
		return sb.toString();
	}
}
