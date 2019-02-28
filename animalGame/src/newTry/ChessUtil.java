package newTry;

import java.util.ArrayList;
import java.util.Random;

/**
 * ����ʵ�ù�����
 * 2��ײ����
 * 1�ǿ��ԳԹ�ȥ
 * 0�����ߵ���
 * -1�ǲ����
 * -2�ǳ����쳣
 * @author ����
 *
 */
public class ChessUtil{

	/**
	 * ���ӱȽϷ���
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	public static int compare(Chess arg0, Chess arg1) {
		//���Ŀ���ַ����������
		if(!arg1.isLive()) {
			return 1;
		}else if(arg0.getHome()==arg1.getHome()){//���Ŀ�ĵ���������ͬ��
			return -1;
		}else if(arg0.getPower()>arg1.getPower()){//�����Ŀ�ĵ����Ӵ�
			return 1;
		}else if(arg0.getPower()==arg1.getPower()) {//���������ͬ��
			return 0;
		}else if(arg0.getPower()<arg1.getPower()) {//������߱Ƚϴ�
			return 2;
		}
		return -2;
	}
	
	/**
	 * �ֽ���Ϣ��ȡ����x y�ͷ���int��������
	 * @param msg
	 * @return
	 */
	public static int[] splitMsg(String msg) {
		//���ո�ʽx y int�����и� �м��пո�
		String[] msgStr = msg.split(" ");
		int[] msgs = new int[msgStr.length];
		int i = 0;
		for(String temp:msgStr) {
			msgs[i] = Integer.parseInt(temp);
			i++;
		}
		return msgs;
		
	}
	
	/**
	 * ������ӵķ���
	 */
	public static Chess createChess(String name,int home,int power,int xCode,int yCode) {
		//�½�һ�����ӣ�������ڲ�Ԫ��
		Chess c = new Chess(name,home,power);
		//������λ�ô�������
		c.setLive(true);
		c.setxCode(xCode);
		c.setyCode(yCode);
		return c;
	}
	  /**
	   * �����������Ԫ�صķ���
	   * @param arr
	   * @return
	   */
	  public static Chess[] randomPiece(Chess[] arr) {
		  Chess [] arr2 = new Chess[arr.length];
		  int count = arr.length;
		  int randCount = 0;//����
		  int position = 0;//λ��
		  int k = 0;
		  do {
			  Random rand = new Random();
			  int r = count-randCount;
			  position = rand.nextInt(r);
			  arr2[k++] = arr[position];
			  randCount++;
			  arr[position] = arr[r-1];
		  }while(randCount<count);
		  return arr2;
	  }
	
}
