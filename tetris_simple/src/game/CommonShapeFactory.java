package game;


import java.awt.Color;

import entities.Shape;
import entities.ShapeFactory;
import listener.ShapeListener;
import util.Global;

/**
 * 
 * 为了扩展一些功能，可用配置文件配置这个工厂用的颜色
 * 
 * @version 1.0, 01/01/08
 * 
 * @author 汤阳光
 * 
 */
public class CommonShapeFactory extends ShapeFactory {

	@Override
	public Shape getShape(ShapeListener shapeListener) {
		// TODO Auto-generated method stub
		int type = random.nextInt(shapes.length);
		int status = random.nextInt(shapes[type].length);
		Shape shape = new Shape(shapes[type], status);
		// System.out.println(type+"\t" + status);
		shape.setColor(isColorfulShape() ? getColorByType(type)
				: getDefaultShapeColor());
		shape.addShapeListener(shapeListener);
		return shape;
	}

	private Color getColorByType(int type) {
		if (type < 0 || type >= Global.COMMON_COLORS.size())
			return getDefaultShapeColor();
		return Global.COMMON_COLORS.get(type);
	}
}
