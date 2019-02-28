package jack;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

	/**
	 * 走法规则
	 * @author 银涛
	 *
	 */
	  public class Rule {
	  ChessBoard board = null;
	  ChessPiece piece = null;
	  ChessPoint point[][];
	  int startI, startJ, endI, endJ;
	
	  /**
	   * 初始化规则
	   * @param board
	   * @param point
	   */
	  public Rule(ChessBoard board, ChessPoint point[][]) {
	  	this.board = board;
	  	this.point = point;
	  }
	
	  /**
	   * 判断是否胜利
	   * @param piece
	   */
	  public void isWine(ChessPiece piece) {
	  	this.piece = piece;
//  	board.record.吃掉的棋子.size();
  	//TODO 遍历棋盘上所有的子，如果没有某一方，则判断游戏的最终胜利
	  	if (piece.getName() == "将" || piece.getName() == "帅") {
	  		if (piece.颜色类别 == "红方") {
	  			JOptionPane.showMessageDialog(null, "黑方  胜利！");
	  		} else {
	  			JOptionPane.showMessageDialog(null, "红方  胜利！");
	  		}
	  	}
	  }
	  
	  /**
	   * 移动棋子的规则
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
	
	  	boolean 可否走棋 = false;

	  	int xAxle = Math.abs(startI - endI);
	  	int yAxle = Math.abs(startJ - endJ);
	  	if (endI <= 4 && endI >= 1) {
	  		//判断是否只是水平或者垂直移动了一格
	  		if ((xAxle == 1 && yAxle == 0) || (xAxle == 0 && yAxle == 1)) {
	  			可否走棋 = true;
	  		} else {
	  			可否走棋 = false;
	  		}
	  	} else {
	  		可否走棋 = false;
	  	}
//	  	if ((piece.getName().equals("帅"))
//  		|| (piece.getName().equals("将"))) {
//	  }
	
	  return 可否走棋;
	  }
	  }
