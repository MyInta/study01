package review_test02_server;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import review_test02_servlet.Servlet;




public class WebApp {
	private static ServletContext contxt;
	static {
		try {
			//获得工厂类
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//获得解析器
			SAXParser parser = factory.newSAXParser();
			//指定xml+处理器
			WebHandler web = new WebHandler();
			parser.parse(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("review_test02_servlet/web.xml"),
					web);
			//将List 转换成Map
			contxt = new ServletContext();
			
			Map<String,String> servlet = contxt.getServlet();
			//servlet-name servlet-class
			for(Entity entity:web.getEntityList()) {
				servlet.put(entity.getName(), entity.getClz());
			}
			
			Map<String,String> mapping = contxt.getMapping();
			//servlet-name url-pattern
			for(Mapping mapp:web.getMappingList()) {
				List<String> urls = mapp.getUrlPattern();
				for(String url:urls) {
					mapping.put(url, mapp.getName());
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static Servlet getServlet(String url) throws 
		InstantiationException, IllegalAccessException, ClassNotFoundException{
		if(null==url||(url=url.trim()).equals("")) {
			return null;
		}
		//return contxt.getServlet().get(contxt.getMapping().get(url));	//?
		//根据字符串（完整路径） 创建对象
		String str = contxt.getServlet().get(contxt.getMapping().get(url));
		return (Servlet)Class.forName(str).newInstance();
	}
}
