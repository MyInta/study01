package practice04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsApp {
	public static void main(String[] args) {
		List<Goods> list = new ArrayList<Goods>();
		list.add(new Goods("����",4000.00,1000));
		list.add(new Goods("̨��",200.00,3000));
		list.add(new Goods("��ͨ����",40.00,2000));
		list.add(new Goods("��ͨ����",40.00,1000));
		list.add(new Goods("�ߵ�����",233.00,2000));
		list.add(new Goods("kindle",900.00,500));
		System.out.println("����ǰ��"+list);
		Collections.sort(list,new GoodsPriceComp());
		System.out.println("�����:"+list);
	}
}
