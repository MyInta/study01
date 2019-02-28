package test.http.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 存储对象
 * @author 银涛
 *
 */
public class PersonHandler extends DefaultHandler{
	private List<Person> persons;
	private Person person;
	private String tag;//标签记录
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("处理文档开始");
		persons = new ArrayList<Person>();
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		//System.out.println("开始一个元素"+arg2);
		if(null!=arg2) {
			tag = arg2;
		}
		if(/*null!=arg2&&*/arg2.equals("person")) {
			person = new Person();
		}
	}
	
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		//System.out.println(new String(arg0,arg1,arg2));
		String str = new String(arg0,arg1,arg2);
		if(tag!=null&&tag.equals("name")) {
			person.setName(str);
		}else if(tag!=null&&tag.equals("age")) {
			Integer age = Integer.valueOf(str);
			person.setAge(age);
		}
	}
	
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		//System.out.println("结束一个元素"+arg2);
		if(arg2.equals("person")) {
			this.persons.add(person);
		}
		tag = null;
	}
	
	@Override
	public void endDocument() throws SAXException {
		//System.out.println("文档处理结束");
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
}
