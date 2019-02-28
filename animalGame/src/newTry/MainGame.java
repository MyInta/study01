package newTry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * ��������̨����Ϸ
 * @author ����
 *
 */
public class MainGame {
	
	//���������Ӳ�����
	private ChessInit start;
	//get����
	public ChessInit getStart() {
		return start;
	}
	//����װ�����ӵ�����
	private ArrayList<Chess> newChess=new ArrayList<>(16);
	
	public ArrayList<Chess> getNewChess() {
		return newChess;
	}

	public MainGame() {
		start = new ChessInit();
		//��ʼ�������ϵ�����
		init(start);
	}

	  /**
	   * �������̳�ʼ����
	   * @param start
	   */
	  private void init(ChessInit start) {
		//��ʼ�����̶���X��  
		for(int i=0;i<16;i++) {
			start.addChess("X", 0, 1);
		}
		//�����ӷ��õ�����ͬʱ�趨������������Ϣ
		start.putOnBoard();
	  }
	
	  /**
	   * ��ӡ��������Ԫ�ط���
	   */
	  public void print() {
		  //�����������
			Chess[][] all = start.getChess();
//			int a = CompareChess.compare(all[0][0],all[0][1]);
			for(int i=0;i<all.length;i++) {
				for(int j=0;j<all[i].length;j++) {
					System.out.print("["+all[i][j].getName()+"]"+"\t");
				}
				System.out.println("\r\n");
			}
	  }
	  
	  /**
	   * �����ʵ�������
	   */
	  public void realChess() {
		  newChess.add(ChessUtil.createChess("��", 1, 8,1,1));
		  newChess.add(ChessUtil.createChess("ʨ", 1, 7,1,2));
		  newChess.add(ChessUtil.createChess("��", 1, 6,1,3));
		  newChess.add(ChessUtil.createChess("��", 1, 5,1,4));
		  newChess.add(ChessUtil.createChess("��", 1, 4,2,1));
		  newChess.add(ChessUtil.createChess("��", 1, 3,2,2));
		  newChess.add(ChessUtil.createChess("è", 1, 2,2,3));
		  newChess.add(ChessUtil.createChess("��", 1, 1,2,4));
	
		  newChess.add(ChessUtil.createChess("��'", 2, 8,3,1));
		  newChess.add(ChessUtil.createChess("ʨ'", 2, 7,3,2));
		  newChess.add(ChessUtil.createChess("��'", 2, 6,3,3));
		  newChess.add(ChessUtil.createChess("��'", 2, 5,3,4));
		  newChess.add(ChessUtil.createChess("��'", 2, 4,4,1));
		  newChess.add(ChessUtil.createChess("��'", 2, 3,4,2));
		  newChess.add(ChessUtil.createChess("è'", 2, 2,4,3));
		  newChess.add(ChessUtil.createChess("��'", 2, 1,4,4));
		  
		  Collections.shuffle(newChess);

	  }
	  
	public static void main(String[] args) {
		
		//������Ϸ
		MainGame core = new MainGame();
		//��ӡ����
		core.print();
		Scanner scan = new Scanner(System.in);
		//��������Ԫ��
		core.realChess();
		while(true) {
			System.out.println("������Ŀ��x����+�ո�+y����+�ո�+����+�س�");
			String msg = scan.nextLine();
			//�ָ��������ͷ�����Ϣ
			int[] msgs = ChessUtil.splitMsg(msg);
			Chess[][] c = core.getStart().getChess();
			//���������λ�õ����̵�����Ϊ��Ӧ����
			c[msgs[0]-1][msgs[1]-1] = core.getNewChess().get(msgs[0]+(msgs[1]-1)*4-1);
			//���´�ӡ
			core.print();
		}
	}
	
}
