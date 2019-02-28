package test.http.server03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WebHandler extends DefaultHandler{
	private List<Entity> entityList;
	private List<Mapping> mappingList;
	private Entity entity;
	private Mapping mapping;
	private String beginTag;
	private boolean isMap;

	public List<Entity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<Entity> entityList) {
		this.entityList = entityList;
	}

	public List<Mapping> getMappingList() {
		return mappingList;
	}

	public void setMappingList(List<Mapping> mappingList) {
		this.mappingList = mappingList;
	}

	@Override
	public void startDocument() throws SAXException {
		//开始解析文档
		entityList = new ArrayList<Entity>();
		mappingList = new ArrayList<Mapping>();
		
	}
	
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		//开始元素
		if(null!=arg2) {
			beginTag = arg2;
			//判断是servlet还是mapping
			if(arg2.equals("servlet")) {
				isMap = false;
				entity = new Entity();
			}else if(arg2.equals("servlet-mapping")) {
				isMap = true;
				mapping = new Mapping();
			}
		}
		
	}
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		//处理内容
		if(null!=beginTag) {
			//arg0缓存 arg1开始 arg2长度 str是标签内的元素
			String str = new String(arg0,arg1,arg2);
			if(isMap) {
				if(beginTag.equals("servlet-name")) {
					mapping.setName(str);
				}else if(beginTag.equals("url-pattern")) {
					mapping.getUrlPattern().add(str);
				}
			}else if(beginTag.equals("servlet-name")) {
				entity.setName(str);
			}else if(beginTag.equals("servlet-class")) {
				entity.setClz(str);
			}
		}
	}
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		//结束元素
		if(null!=arg2) {
			if(arg2.equals("servlet")) {
				entityList.add(entity);
			}else if(arg2.equals("servlet-mapping")) {
				mappingList.add(mapping);
			}
		}
		//将标签信息置空
		beginTag = null;
	}

	@Override
	public void endDocument() throws SAXException {
		//文档解析结束
	}
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//获取解析器
		SAXParser sax = factory.newSAXParser();
		//指定xml+处理器
		WebHandler web = new WebHandler();
		sax.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("WEB_INFO/web.xml"),
				web);
		System.out.println(web.getEntityList());
	}
}
