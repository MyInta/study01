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
	//�����пɶ�Ӧ�ȼ�����
	private final int levelUp;
	//����˹���鲻ͬ��״��ɵ�List�±���Ķ�Ӧ��״��ÿ�鷽����������鼯��
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
		//��ö���˹���巽������
		List<Element> rects = system.elements("rect");
		//��Ӧ������������
		typeConfig = new ArrayList<Point[]>(rects.size());
		//��Ӧ�����б��Ƿ����ת����
		typeRound = new ArrayList<Boolean>(rects.size());
		//����ÿ������˹���巽��
		for(Element rect:rects) {
			//��boolean�����м����Ӧ������Ƿ���ת�б�
			this.typeRound.add(Boolean.parseBoolean(rect.attributeValue("round")));
			//���ÿһС�鷽����������
			List<Element> pointConfig=rect.elements("point");
			//����Point��������
			Point[] points = new Point[pointConfig.size()];
			//��ʼ��Point��������
			for(int i=0;i<points.length;i++) {
				int x = Integer.parseInt(pointConfig.get(i).attributeValue("x"));
				int y = Integer.parseInt(pointConfig.get(i).attributeValue("y"));
				points[i] = new Point(x,y);
			}
			//��Point��������ŵ�typeConfig��
			typeConfig.add(points);
		}
		//��������ӷ�����
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
