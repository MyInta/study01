package config;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

public class SystemConfig implements Serializable{

	private final int minX;
	private final int maxX;
	private final int minY;
	private final int maxY;
	//多少行可对应等级上升
	private final int levelUp;
	//俄罗斯方块不同形状组成的List下保存的对应形状下每块方块的坐标数组集合
	private final List<Point[]> typeConfig;
	private final List<Boolean> typeRound;
	private final Map<Integer,Integer> plusPoint;
	
	public SystemConfig(Element system) {
		minX= Integer.parseInt(system.attributeValue("minX"));
		maxX= Integer.parseInt(system.attributeValue("maxX"));
		minY= Integer.parseInt(system.attributeValue("minY"));
		maxY= Integer.parseInt(system.attributeValue("maxY"));
//		System.out.println(system.attributeValue("levelUp"));
		levelUp = Integer.parseInt(system.attributeValue("levelUp"));
		//获得俄罗斯整体方块数组
		List<Element> rects = system.elements("rect");
		//对应方块坐标数组
		typeConfig = new ArrayList<Point[]>(rects.size());
		//对应方块判别是否可旋转数组
		typeRound = new ArrayList<Boolean>(rects.size());
		//遍历每个俄罗斯整体方块
		for(Element rect:rects) {
			//往boolean数组中加入对应方块的是否旋转判别
			this.typeRound.add(Boolean.parseBoolean(rect.attributeValue("round")));
			//获得每一小块方块的坐标对象
			List<Element> pointConfig=rect.elements("point");
			//创建Point对象数组
			Point[] points = new Point[pointConfig.size()];
			//初始化Point对象数组
			for(int i=0;i<points.length;i++) {
				int x = Integer.parseInt(pointConfig.get(i).attributeValue("x"));
				int y = Integer.parseInt(pointConfig.get(i).attributeValue("y"));
				points[i] = new Point(x,y);
			}
			//将Point对象数组放到typeConfig中
			typeConfig.add(points);
		}
		//获得连消加分配置
		plusPoint = new HashMap<>();
		List<Element> plusScore = system.elements("plusScore");
		for(Element e:plusScore){
			int rm = Integer.parseInt(e.attributeValue("rm"));
			int score = Integer.parseInt(e.attributeValue("score"));
			this.plusPoint.put(rm, score);
		}
	}
	public int getMinX() {
		return minX;
	}
	public int getMaxX() {
		return maxX;
	}
	public int getMinY() {
		return minY;
	}
	public int getMaxY() {
		return maxY;
	}
	public List<Point[]> getTypeConfig() {
		return typeConfig;
	}
	
	public List<Boolean> getTypeRound() {
		return typeRound;
	}
	public int getLevelUp() {
		return levelUp;
	}
	public Map<Integer, Integer> getPlusPoint() {
		return plusPoint;
	}
	
}
