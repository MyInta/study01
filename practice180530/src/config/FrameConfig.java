package config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig implements Serializable{
	//标题
	private final String title;
	//窗口抬高
	private final int windowUp;
	//窗口宽
	private final int width;
	//窗口高
	private final int height;
	//边框内边距
	private final int padding;
	//边框厚度
	private final int border;
	//圆块尺寸左位移偏移量（左移及乘2的n次方）
	private final int sizeRol;
	//游戏结束后调用的索引
	private final int loseIdx;

	/**
	 * 图层属性
	 */
	private final List<LayerConfig> layerConfig;
	/**
	 * 按钮属性
	 */
	private final ButtonConfig buttonConfig;
	
	public FrameConfig(Element frame){
		//获取窗口标题
		this.title = frame.attributeValue("title");
		// 获取窗口抬升高度
		this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));
		// 获取窗口宽度
		this.width = Integer.parseInt(frame.attributeValue("width"));
		// 获取窗口高度
		this.height = Integer.parseInt(frame.attributeValue("height"));
		// 获取窗口边框粗细
		this.border = Integer.parseInt(frame.attributeValue("border"));
		// 获取边框内边距
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		// 圆块尺寸左位移偏移量
		this.sizeRol = Integer.parseInt(frame.attributeValue("sizeRol"));
		//游戏失败
		this.loseIdx = Integer.parseInt(frame.attributeValue("loseIdx"));
		// 获取窗体属性
		List<Element> layers = frame.elements("layer");
		layerConfig = new ArrayList<>();
		// 获取所有窗体属性
		for (Element layer : layers) {
			// 获取单一窗体属性
			LayerConfig lc = new LayerConfig(layer.attributeValue("className"),
					Integer.parseInt(layer.attributeValue("x")), Integer.parseInt(layer.attributeValue("y")),
					Integer.parseInt(layer.attributeValue("w")), Integer.parseInt(layer.attributeValue("h")));
			layerConfig.add(lc);
		}
		//初始化按钮属性
		this.buttonConfig= new ButtonConfig(frame.element("button"));
	}

	public String getTitle() {
		return title;
	}

	public int getWindowUp() {
		return windowUp;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getPadding() {
		return padding;
	}

	public int getBorder() {
		return border;
	}

	public List<LayerConfig> getLayerConfig() {
		return layerConfig;
	}

	public int getSizeRol() {
		return sizeRol;
	}

	public int getLoseIdx() {
		return loseIdx;
	}

	public ButtonConfig getButtonConfig() {
		return buttonConfig;
	}
	
}
