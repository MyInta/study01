package practiceGuava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

/**
 * ˫����Map-->Table-->rowKey +columnKey+value
 * 1������ 		��ʽ����ѧ��-�γ�-�ɼ���
 * ���������ݣ�cellSet()
 * ���е�ѧ����rowKeySet()
 * ���пγ̣�columKeySet()
 * ���еĳɼ���values()
 * ѧ����Ӧ�γ̣�rowMap()+get(ѧ��)
 * 					row(ѧ��)
 * �γ̶�Ӧ��ѧ����columnMap+get(�γ�)
 * 					column(�γ�)
 * @author ����
 *
 */
public class Demo08 {

	public static void main(String[] args) {
		Table<String,String,Integer> tables = HashBasedTable.create();
		//��������
		tables.put("inta", "javase", 98);
		tables.put("����", "��ѧ", 99);
		tables.put("ţ��", "��ѧ", 99);
		tables.put("��ΰ��", "javase", 60);
		tables.put("��ΰ��", "��ѧ", 60);
		//��������
		Set<Cell<String,String,Integer>> cells = tables.cellSet();
		for(Cell<String,String,Integer> temp:cells) {
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
		System.out.println("=====��ѧ���鿴�ɼ�========");//չʾ ��ѧ�� �γ����ơ�
		System.out.print("ѧ��\t");
		Set<String> course = tables.columnKeySet();
		for(String strStu:course) {
			System.out.print(strStu+"\t");
		}
		System.out.println();
		//���е�ѧ��
		Set<String> stu = tables.rowKeySet();
		for(String strStu:stu) {
			System.out.print(strStu+"\t");
			Map<String,Integer> scores= tables.row(strStu);//���õ����ظ�V����Ϊ��Map�洢�����ض�ѧ���£��γ�K��γ̳ɼ�V
			//�����γ̵õ���Ӧ�ɼ�
			for(String str:course) {
				System.out.print(scores.get(str)+"\t");
			}
			System.out.println();
		}
		
		System.out.println("=====���γ̲鿴ѧ���ɼ�========");//չʾ ��ѧ�� �γ����ơ�
		System.out.print("�γ�\t");
		Set<String> stu2 = tables.rowKeySet();
		for(String cours:stu2) {
			System.out.print(cours+"\t");
		}
		System.out.println();
		//���еĿγ�
		Set<String> cours = tables.columnKeySet();
		for(String strCours:cours) {
			System.out.print(strCours+"\t");
			Map<String,Integer> scores= tables.column(strCours);
			//����ѧ���õ���Ӧ�ɼ�
			for(String str:stu2) {
				System.out.print(scores.get(str)+"\t");
			}
			System.out.println();
		}
		System.out.println("===========ת��row��column˳��===========");
		Table<String,String,Integer> tables2 = Tables.transpose(tables);
		Set<Cell<String,String,Integer>> cells2 = tables2.cellSet();
		for(Cell<String,String,Integer> temp:cells2) {
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
	}

}
