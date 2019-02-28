package newTry;

import java.util.ArrayList;
import java.util.Random;

/**
 * ���̳�ʼ��
 * ��������װ������
 * ��ӡ����������Ԫ��
 * @author ����
 *
 */
public class ChessInit {

	//����װ�����ӵ�����
	private ArrayList<Chess> arrChess=new ArrayList<>(16);
	//�������� ��ʱ��Ҫ����������Ԫ�ذ���װ������
	private Chess[][] all = new Chess[4][4]; 
	//�����ṩ��ȡ��������ķ���
	public Chess[][] getChess() {
		return all;
	}

	/**
	 * ������ӵķ���
	 */
	public void addChess(String name,int home,int power) {
		//�½�һ�����ӣ�������ڲ�Ԫ��
		Chess c = new Chess(name,home,power);
		
		if(name.equals("X")||name.equals("+")) {//�����������ΪX���ʾ��������
			c.setHome(0);//0��ʾ����Ϊ���� ����1��2������
			c.setLive(false);
		}
		//������λ�ô�������
		c.setLive(true);
		//�������������������
		arrChess.add(c);
	}
	
	/**
	 * �޸�������ĳ������Ԫ��
	 * @param index
	 */
	public void setChess(int index,Chess chess) {
		//���ԭ�е�����
		Chess c = arrChess.get(index);
		//����ԭ������Ϊ�µ�����
		c.setName(chess.getName());
		c.setHome(chess.getHome());
		c.setLive(chess.isLive());
		c.setPower(chess.getPower());
		c.setxCode(chess.getxCode());
		c.setyCode(chess.getyCode());
	}
	
	/**
	 * �����������������
	 * @param arrChess
	 * @return
	 */
	public Chess[][] putOnBoard() {
		
		int n=0;
		//��������
		for(int i=0;i<all.length;i++) {
			for(int j=0;j<all[i].length;j++) {
				//����Ӧ����λ���������Ԫ��
				Chess c = arrChess.get(n);
				//������Ӻ�����
				c.setxCode(i+1);
				//�������y����
				c.setyCode(j+1);
				all[i][j] = c;
				
				n++;
				if(n>=16) {
					break;
				}
			}
		}
		
		return getChess();
	}
	
	  
}
