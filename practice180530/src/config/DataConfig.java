package config;


import java.io.Serializable;

import org.dom4j.Element;

public class DataConfig implements Serializable{
	/**
	 * 最大行数
	 */
	private final int maxRow;
	/**
	 * 数据接口A
	 */
	private final DataInterfaceConfig dataA;
	private final DataInterfaceConfig dataB;
	
	public DataConfig(Element data) {
		this.maxRow = Integer.parseInt(data.attributeValue("maxRow"));
		this.dataA = new DataInterfaceConfig(data.element("dataA"));
		this.dataB = new DataInterfaceConfig(data.element("dataB"));
	}

	public DataInterfaceConfig getDataA() {
		return dataA;
	}

	public DataInterfaceConfig getDataB() {
		return dataB;
	}

	public int getMaxRow() {
		return maxRow;
	}
	
	
}
