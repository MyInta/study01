package jack;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

	/**
	 * �߷�����
	 * @author ����
	 *
	 */
	  public class Rule {
	  ChessBoard board = null;
	  ChessPiece piece = null;
	  ChessPoint point[][];
	  int startI, startJ, endI, endJ;
	
	  /**
	   * ��ʼ������
	   * @param board
	   * @param point
	   */
	  public Rule(ChessBoard board, ChessPoint point[][]) {
	  	this.board = board;
	  	this.point = point;
	  }
	
	  /**
	   * �ж��Ƿ�ʤ��
	   * @param piece
	   */
	  public void isWine(ChessPiece piece) {
	  	this.piece = piece;
//  	board.record.�Ե�������.size();
  	//TODO �������������е��ӣ����û��ĳһ�������ж���Ϸ������ʤ��
	  	if (piece.getName() == "��" || piece.getName() == "˧") {
	  		if (piece.��ɫ��� == "�췽") {
	  			JOptionPane.showMessageDialog(null, "�ڷ�  ʤ����");
	  		} else {
	  			JOptionPane.showMessageDialog(null, "�췽  ʤ����");
	  		}
	  	}
	  }
	  
	  /**
	   * �ƶ����ӵĹ���
	   * @param piece
	   * @param startI
	   * @param startJ
	   * @param endI
	   * @param endJ
	   * @return
	   */
	  public boolean movePieceRule(ChessPiece piece, int startI, int startJ,
	  		int endI, int endJ) {
	  	this.piece = piece;
	  	this.startI = startI;
	  	this.startJ = startJ;
	  	this.endI = endI;
	  	this.endJ = endJ;
	
	  	boolean �ɷ����� = false;

	  	int xAxle = Math.abs(startI - endI);
	  	int yAxle = Math.abs(startJ - endJ);
	  	if (endI <= 4 && endI >= 1) {
	  		//�ж��Ƿ�ֻ��ˮƽ���ߴ�ֱ�ƶ���һ��
	  		if ((xAxle == 1 && yAxle == 0) || (xAxle == 0 && yAxle == 1)) {
	  			�ɷ����� = true;
	  		} else {
	  			�ɷ����� = false;
	  		}
	  	} else {
	  		�ɷ����� = false;
	  	}
//	  	if ((piece.getName().equals("˧"))
//  		|| (piece.getName().equals("��"))) {
//	  }
	
	  return �ɷ�����;
	  }
	  }
