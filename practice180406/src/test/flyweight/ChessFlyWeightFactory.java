package test.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 * @author 银涛
 *
 */
public class ChessFlyWeightFactory {
	//享元池 
	private static Map<String,ChessFlyWeight> map = new HashMap<>();
	
	public static ChessFlyWeight getChess(String color) {
		if(null!=map.get(color)) {
			return map.get(color);
		}else {
			ChessFlyWeight cfw = new ConcreteChess(color);
			map.put(color, cfw);
			return map.get(color);
		}
	}
}
