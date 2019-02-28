package jack;

	/**
	 * �����
	 * @author ����
	 *
	 */
	  public class ChessPoint {
	  /** �������� */
	  int x, y;
	
	  /** ������ �Ƿ�����*/
	  boolean hasPiece;
	
	  /** ����������� */
	  ChessPiece piece = null;
	
	  /** ������������ */
	  ChessBoard board = null;
	  /**
	   * ��ʼ������λ�ã��Լ���λ���Ƿ�������
	   * @param x ����ˮƽ����
	   * @param y ���Ӵ�ֱ����
	   * @param boo �Ƿ��������ж�
	   */
	  public ChessPoint(int x, int y, boolean boo) {
	  	this.x = x;
	  	this.y = y;
	  	hasPiece = boo;
	  }
	
	  /**
	   * �Ƿ������ӷ����ж�
	   * @return
	   */
	  public boolean isPiece() {
	  	return hasPiece;
	  }
	  /**
	   * ���ø�λ���Ƿ�������
	   * @param boo
	   */
	  public void setHasPiece(boolean boo) {
	  	hasPiece = boo;
	  }
	  /**
	   * ������������x
	   * @return
	   */
	  public int getX() {
	  	return x;
	  }
	  /**
	   * ������������y
	   * @return
	   */
	  public int getY() {
	  	return y;
	  }
	
	  /**
	   * ���øĵ�����
	   * @param piece Ҫ���ĵ�����
	   * @param board ����
	   */
	  public void setPiece(ChessPiece piece, ChessBoard board) {
	  	this.board = board;
	  	this.piece = piece;
	  	//���������������
	  	board.add(piece);
	  	//���̵�Ԫ���͸�
	  	int w = (board.unitWidth);
	  	int h = (board.unitHeight);
	  	piece.setBounds(x - w / 2, y - h / 2, w, h);// ����λ�ã���ȣ��߶�
	  	//��ʼ����λ��������
	  	hasPiece = true;
	  	//�������̿��ӻ�
	  	board.validate();
	  }
	
	  /**
	   * ��ȡ��λ�õ�����
	   * @return
	   */
	  public ChessPiece getPiece() {
	  	return piece;
	  }
	
	  /**
	   * ɾ�������ϵ�ĳ������
	   * @param piece
	   * @param board
	   */
	  public void reMovePiece(ChessPiece piece, ChessBoard board) {
	  	this.board = board;
	  	this.piece = piece;
	  	board.remove(piece);
	  	board.validate();
	  	//���ø�λ��������
	  	hasPiece = false;
	  }
	  }
