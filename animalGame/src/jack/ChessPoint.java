package jack;

	/**
	 * 棋点类
	 * @author 银涛
	 *
	 */
	  public class ChessPoint {
	  /** 棋子坐标 */
	  int x, y;
	
	  /** 该坐标 是否有子*/
	  boolean hasPiece;
	
	  /** 改坐标的棋子 */
	  ChessPiece piece = null;
	
	  /** 坐标所属棋盘 */
	  ChessBoard board = null;
	  /**
	   * 初始化棋子位置，以及该位置是否有棋子
	   * @param x 棋子水平坐标
	   * @param y 棋子垂直坐标
	   * @param boo 是否有棋子判断
	   */
	  public ChessPoint(int x, int y, boolean boo) {
	  	this.x = x;
	  	this.y = y;
	  	hasPiece = boo;
	  }
	
	  /**
	   * 是否有棋子返回判断
	   * @return
	   */
	  public boolean isPiece() {
	  	return hasPiece;
	  }
	  /**
	   * 设置该位置是否有棋子
	   * @param boo
	   */
	  public void setHasPiece(boolean boo) {
	  	hasPiece = boo;
	  }
	  /**
	   * 返回棋子坐标x
	   * @return
	   */
	  public int getX() {
	  	return x;
	  }
	  /**
	   * 返回棋子坐标y
	   * @return
	   */
	  public int getY() {
	  	return y;
	  }
	
	  /**
	   * 设置改点棋子
	   * @param piece 要更改的棋子
	   * @param board 棋盘
	   */
	  public void setPiece(ChessPiece piece, ChessBoard board) {
	  	this.board = board;
	  	this.piece = piece;
	  	//往棋盘上添加棋子
	  	board.add(piece);
	  	//棋盘单元格宽和高
	  	int w = (board.unitWidth);
	  	int h = (board.unitHeight);
	  	piece.setBounds(x - w / 2, y - h / 2, w, h);// 棋子位置，宽度，高度
	  	//初始化该位置有棋子
	  	hasPiece = true;
	  	//设置棋盘可视化
	  	board.validate();
	  }
	
	  /**
	   * 获取该位置的棋子
	   * @return
	   */
	  public ChessPiece getPiece() {
	  	return piece;
	  }
	
	  /**
	   * 删除棋盘上的某个棋子
	   * @param piece
	   * @param board
	   */
	  public void reMovePiece(ChessPiece piece, ChessBoard board) {
	  	this.board = board;
	  	this.piece = piece;
	  	board.remove(piece);
	  	board.validate();
	  	//设置该位置无棋子
	  	hasPiece = false;
	  }
	  }
