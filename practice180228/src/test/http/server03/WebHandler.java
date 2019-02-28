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
		//��ʼ�����ĵ�
		entityList = new ArrayList<Entity>();
		mappingList = new ArrayList<Mapping>();
		
	}
	
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		//��ʼԪ��
		if(null!=arg2) {
			beginTag = arg2;
			//�ж���servlet����mapping
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
		//��������
		if(null!=beginTag) {
			//arg0���� arg1��ʼ arg2���� str�Ǳ�ǩ�ڵ�Ԫ��
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
		//����Ԫ��
		if(null!=arg2) {
			if(arg2.equals("servlet")) {
				entityList.add(entity);
			}else if(arg2.equals("servlet-mapping")) {
				mappingList.add(mapping);
			}
		}
		//����ǩ��Ϣ�ÿ�
		beginTag = null;
	}

	@Override
	public void endDocument() throws SAXException {
		//�ĵ���������
	}
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//��ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//��ȡ������
		SAXParser sax = factory.newSAXParser();
		//ָ��xml+������
		WebHandler web = new WebHandler();
		sax.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("WEB_INFO/web.xml"),
				web);
		System.out.println(web.getEntityList());
	}
}
