package practiceGuava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * �����鿴��ʦ���ڿγ�
 * Multimap :key-value key�����ظ�,��һ��key��Ӧ���value
 * ��ȻMulimap�����һ��key��Ӧ���V�����⣬����û������K��Ӧ���V�����⣨���ײ���ֵ�����ǵ�����
 * @author ����
 *
 */
public class Demo06 {
	public static void main(String[] args) {
		Map<String,String> cours = new HashMap<>();
//		cours.put("��ѧ", "ţ��");//��ȻMulimap�����һ��key��Ӧ���V�����⣬����û������K��Ӧ���V������
		cours.put("��ѧ", "�ų�ܰ");
		cours.put("��Ϸ", "�ų�ܰ");
		cours.put("����", "�ų�ܰ");
		cours.put("����", "ţ��");
		cours.put("NBA", "ţ��");
		cours.put("ʵ��", "����");
		
		//Multimap
		Multimap<String,String> teachers = ArrayListMultimap.create();
		
		//������
		Iterator<Map.Entry<String,String>> it = cours.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String,String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			//��ʦ-->�γ̣���Multimap�����Ծ�������key�Ŀ��ظ���
			teachers.put(value, key);//���õ��ĺ����V���ǵ�ǰ���V
		}
		Set<String> set = teachers.keySet();
		for(String str:set) {
			Collection<String> col = teachers.get(str);
			System.out.println(str+"-->"+/*teachers.get(str)*/col);
		}
		
	}
}
