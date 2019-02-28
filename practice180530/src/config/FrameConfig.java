package config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig implements Serializable{
	//����
	private final String title;
	//����̧��
	private final int windowUp;
	//���ڿ�
	private final int width;
	//���ڸ�
	private final int height;
	//�߿��ڱ߾�
	private final int padding;
	//�߿���
	private final int border;
	//Բ��ߴ���λ��ƫ���������Ƽ���2��n�η���
	private final int sizeRol;
	//��Ϸ��������õ�����
	private final int loseIdx;

	/**
	 * ͼ������
	 */
	private final List<LayerConfig> layerConfig;
	/**
	 * ��ť����
	 */
	private final ButtonConfig buttonConfig;
	
	public FrameConfig(Element frame){
		//��ȡ���ڱ���
		this.title = frame.attributeValue("title");
		// ��ȡ����̧���߶�
		this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));
		// ��ȡ���ڿ��
		this.width = Integer.parseInt(frame.attributeValue("width"));
		// ��ȡ���ڸ߶�
		this.height = Integer.parseInt(frame.attributeValue("height"));
		// ��ȡ���ڱ߿��ϸ
		this.border = Integer.parseInt(frame.attributeValue("border"));
		// ��ȡ�߿��ڱ߾�
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		// Բ��ߴ���λ��ƫ����
		this.sizeRol = Integer.parseInt(frame.attributeValue("sizeRol"));
		//��Ϸʧ��
		this.loseIdx = Integer.parseInt(frame.attributeValue("loseIdx"));
		// ��ȡ��������
		List<Element> layers = frame.elements("layer");
		layerConfig = new ArrayList<>();
		// ��ȡ���д�������
		for (Element layer : layers) {
			// ��ȡ��һ��������
			LayerConfig lc = new LayerConfig(layer.attributeValue("className"),
					Integer.parseInt(layer.attributeValue("x")), Integer.parseInt(layer.attributeValue("y")),
					Integer.parseInt(layer.attributeValue("w")), Integer.parseInt(layer.attributeValue("h")));
			layerConfig.add(lc);
		}
		//��ʼ����ť����
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
