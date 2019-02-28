package jack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ������
 * @author ����
 *
 */
  public class ChessBoard extends JPanel implements MouseListener,
  	MouseMotionListener {
	  //���Ӷ�ά����
	  public ChessPoint point[][];
	  //���̵�Ԫ���͸�
	  public int unitWidth, unitHeight;
	  //x�᳤��y�᳤
	  private int x�᳤, y�᳤;
	  //����϶�ʱ���Ŀ����x��y����
	  private int x, y;
	  //���̱���ͼƬ
	  private Image img;
	  //���ӱ���ͼƬ
	  protected Image pieceImg;
	  //�ж������Ƿ����ƶ�
	  private boolean move = false;
	  //�������ӵĹ�����ɫ
	  public String �췽��ɫ = "�췽", �ڷ���ɫ = "�ڷ�",δ֪��ɫ="��ɫ";
	  //ÿһ�������ࣨ�췽�ͺڷ����֣�
	  ChessPiece ����, ��ʨ, �컢, �챪, ����, �칷, ��è, ����;
	  ChessPiece ����, ��ʨ, �ڻ�, �ڱ�, ����, �ڹ�, ��è, ����;
	  //TODO ��δ�㿪֮ǰ�������ӡ�
	  ChessPiece ����1,����2,����3,����4,����5,����6,����7,����8;
	  ChessPiece ����9,����10,����11,����12,����13,����14,����15,����16;
	  //���Է�Χ���ε�ˮƽ����X�ʹ�ֱ����Y
	  int startX, startY;
	  //ȷ�ϱ�ѡ�к�Ŀ��ˮƽ����X�ʹ�ֱ����Y
	  int startI, startJ;
	  //�����һ������
	  public boolean �췽���� = true, �ڷ����� = false;
	  //�����߷��淶
	  Rule rule = null;
	  //��¼����
	  public MakeChessManual record = null;
	  
	  /**
	   * ��ʼ������
	   * @param w 	���̵�Ԫ���
	   * @param h	���̵�Ԫ���
	   * @param r	x�᳤
	   * @param c	y�᳤
	   */
  public ChessBoard(int w, int h, int r, int c) {
  	setLayout(null);
  	addMouseListener(this);
  	addMouseMotionListener(this);
  	Color bc = getBackground();
  	unitWidth = w;
  	unitHeight = h;
  	x�᳤ = r;
  	y�᳤ = c;
  point = new ChessPoint[r + 1][c + 1];
   
  for (int i = 1; i <= r; i++) {
  	for (int j = 1; j <= c; j++) {
  		//��ʼ��ÿһ�����̵㣬�������ú����ǵĳߴ��Լ��Ƿ��������
  		point[i][j] = new ChessPoint(i * unitWidth, j * unitHeight,
  				false);
  	}
  }
  //��ʼ���߷�����
  rule = new Rule(this, point);
  //��ʼ����������
  record = new MakeChessManual(this, point);
  //��ȡ����ͼƬ
  img = Toolkit.getDefaultToolkit().getImage("F:\\JAVA\\Eclipse\\inta\\animalGame\\src\\jack\\01.jpg");
  //��ȡ���ӱ���ͼƬ
  pieceImg = Toolkit.getDefaultToolkit().getImage("F:\\JAVA\\Eclipse\\inta\\animalGame\\src\\jack\\02.jpg");
  
  //��ʼ����������
  ���� = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
  ����.set�������(�췽��ɫ);
  ��ʨ = new ChessPiece("ʨ", Color.red, bc, w - 4, h - 4, this);
  ��ʨ.set�������(�췽��ɫ);
  �컢 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
  �컢.set�������(�췽��ɫ);
  �챪 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
  �챪.set�������(�췽��ɫ);
  ���� = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
  ����.set�������(�췽��ɫ);
  �칷 = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
  �칷.set�������(�췽��ɫ);
  ��è = new ChessPiece("è", Color.red, bc, w - 4, h - 4, this);
  ��è.set�������(�췽��ɫ);
  ���� = new ChessPiece("��", Color.red, bc, w - 4, h - 4, this);
  ����.set�������(�췽��ɫ);
  
  
  ���� = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
  ����.set�������(�ڷ���ɫ);
  ��ʨ = new ChessPiece("ʨ", Color.black, bc, w - 4, h - 4, this);
  ��ʨ.set�������(�ڷ���ɫ);
  �ڻ� = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
  �ڻ�.set�������(�ڷ���ɫ);
  �ڱ� = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
  �ڱ�.set�������(�ڷ���ɫ);
  ���� = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
  ����.set�������(�ڷ���ɫ);
  �ڹ� = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
  �ڹ�.set�������(�ڷ���ɫ);
  ��è = new ChessPiece("è", Color.black, bc, w - 4, h - 4, this);
  ��è.set�������(�ڷ���ɫ);
  ���� = new ChessPiece("��", Color.black, bc, w - 4, h - 4, this);
  ����.set�������(�ڷ���ɫ);

//  ����1 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����1.set�������(δ֪��ɫ);
//  ����2 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����2.set�������(δ֪��ɫ);
//  ����3 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����3.set�������(δ֪��ɫ);
//  ����4 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����4.set�������(δ֪��ɫ);
//  ����5 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����5.set�������(δ֪��ɫ);
//  ����6 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����6.set�������(δ֪��ɫ);
//  ����7 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����7.set�������(δ֪��ɫ);
//  ����8 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����8.set�������(δ֪��ɫ);
//  ����9 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����9.set�������(δ֪��ɫ);
//  ����10 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����10.set�������(δ֪��ɫ);
//  ����11 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����11.set�������(δ֪��ɫ);
//  ����12 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����12.set�������(δ֪��ɫ);
//  ����13 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����13.set�������(δ֪��ɫ);
//  ����14 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����14.set�������(δ֪��ɫ);
//  ����15 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����15.set�������(δ֪��ɫ);
//  ����16 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  ����16.set�������(δ֪��ɫ);

//  ChessPiece[] boxs = {����1,����2,����3,����4,����5,����6,����7,����8,
//  ����9,����10,����11,����12,����13,����14,����15,����16};
  
  ChessPiece[] names={����, ��ʨ, �컢, �챪, ����, �칷, ��è, ����,
		  ����, ��ʨ, �ڻ�, �ڱ�, ����, �ڹ�, ��è, ����};
  names = MoveStep.randomPiece(names);
  
  int[] arr = {1,2,3,4};
  int temp=0;
 
  for(int i=1;i<=4;i++) {
	  for(int j=1;j<=4;j++) {
		  point[i][j].setPiece(names[temp], this);
		  temp++;
		  if(temp>names.length) {
			  break;
		  }
//		  point[i][j].setPiece(boxs[temp], this);
//		  temp++;
//		  if(temp>boxs.length) {
//			  break;
//		  }
	  }
  }
 
  }

  public void paintComponent(Graphics g) {
  	super.paintComponent(g);
  int imgWidth = img.getWidth(this);
  int imgHeight = img.getHeight(this);// ���ͼƬ�Ŀ����߶�
  int FWidth = getWidth();
  int FHeight = getHeight();// ��ô��ڵĿ����߶�
  int x = (FWidth - imgWidth) / 2;
  int y = (FHeight - imgHeight) / 2;
  g.drawImage(img, x, y, null);
   
  for (int j = 1; j <= y�᳤; j++) {
  	g.drawLine(point[1][j].x, point[1][j].y, point[x�᳤][j].x,
  			point[x�᳤][j].y);
  }
  for (int i = 1; i <= x�᳤; i++) {
  		g.drawLine(point[i][1].x, point[i][1].y, point[i][y�᳤].x,
  				point[i][y�᳤].y);
  		g.drawString("" + i, i * unitWidth, unitHeight / 2);
  }

  int j = 1;
  for (char c = 'A'; c <= 'D'; c++) {
  	g.drawString("" + c, unitWidth / 4, j * unitHeight);
  	j++;
  }
  }

  /**��갴���¼�*/
  public void mousePressed(MouseEvent e) {
  	ChessPiece piece = null;
  	Rectangle rect = null;
  	if (e.getSource() == this)
  		move = false;
  	if (move == false)
  		if (e.getSource() instanceof ChessPiece) {
  			piece = (ChessPiece) e.getSource();
  			//��ȡ������ʼλ�õ�ˮƽ�봹ֱ����
  			startX = piece.getBounds().x;
  			startY = piece.getBounds().y;
	  		rect = piece.getBounds();
	  		for (int i = 1; i <= x�᳤; i++) {
	  			for (int j = 1; j <= y�᳤; j++) {
	  				int x = point[i][j].getX();
	  				int y = point[i][j].getY();
	  				if (rect.contains(x, y)) {
	  					//������ΰ���������λ�õ㣬��øõ�����
	  					startI = i;
	  					startJ = j;
	  					break;
	  				}
	   
	  			}
	  		}
  	}
  }

  public void mouseMoved(MouseEvent e) {
  }

  /**����϶��¼�*/
  public void mouseDragged(MouseEvent e) {
	  ChessPiece piece = null;
	  if (e.getSource() instanceof ChessPiece) {
	  	piece = (ChessPiece) e.getSource();
	  	move = true;
	  	e = SwingUtilities.convertMouseEvent(piece, e, this);
  }
   
	  if (e.getSource() == this) {
	  	if (move && piece != null) {
	  		x = e.getX();
	  		y = e.getY();
	  		if (�췽���� && ((piece.�������()).equals(�췽��ɫ))) {
	  			piece.setLocation(x - piece.getWidth() / 2,
	  					y - piece.getHeight() / 2);
	  		}
	  		if (�ڷ����� && (piece.�������().equals(�ڷ���ɫ))) {
	  			piece.setLocation(x - piece.getWidth() / 2,
	  					y - piece.getHeight() / 2);
	  		}
	  	}
	  }

  }

  /**�ɿ�����¼�*/
  public void mouseReleased(MouseEvent e) {
  	ChessPiece piece = null;
  	move = false;
  	Rectangle rect = null;
  	if (e.getSource() instanceof ChessPiece) {
  		piece = (ChessPiece) e.getSource();
  		rect = piece.getBounds();
  		e = SwingUtilities.convertMouseEvent(piece, e, this);
  }
  if (e.getSource() == this) {
  	boolean containChessPoint = false;
  	int x = 0, y = 0;
  	int m = 0, n = 0;
  	if (piece != null) {
  		for (int i = 1; i <= x�᳤; i++) {
  			for (int j = 1; j <= y�᳤; j++) {
  				x = point[i][j].getX();
  				y = point[i][j].getY();
  				if (rect.contains(x, y)) {
  					containChessPoint = true;
  					m = i;
  					n = j;
  					break;
  				}
   
  			}
  		}
  	}
  	if (piece != null && containChessPoint) {
  		Color pieceColor = piece.��ȡ������ɫ();
  		if (point[m][n].isPiece()) {
  			Color c = (point[m][n].getPiece()).��ȡ������ɫ();
  			if (pieceColor.getRGB() == c.getRGB()) {
  				piece.setLocation(startX, startY);
   
  				(point[startI][startJ]).setHasPiece(true);
  			} else {
  				boolean ok = rule.movePieceRule(piece, startI, startJ,
  						m, n);
  				if (ok) {
  					ChessPiece pieceRemoved = point[m][n].getPiece();
  					point[m][n].reMovePiece(pieceRemoved, this);
  					point[m][n].setPiece(piece, this);
  					(point[startI][startJ]).setHasPiece(false);
  					record.��¼����(piece, startI, startJ, m, n);
  					//TODO ��¼�Ե����ֺͻ�ʤ����
  					record.��¼�Ե�������(pieceRemoved);
  					rule.isWine(pieceRemoved);
  					if (piece.�������().equals(�췽��ɫ)) {
  						�췽���� = false;
  						�ڷ����� = true;
  					}
  					if (piece.�������().equals(�ڷ���ɫ)) {
  						�ڷ����� = false;
  						�췽���� = true;
  					}
  					validate();
  					repaint();
  				} else {
  					piece.setLocation(startX, startY);
  					(point[startI][startJ]).setHasPiece(true);
  				}
  			}
   
  		} else {
   
  			boolean ok = rule
  					.movePieceRule(piece, startI, startJ, m, n);
  			if (ok) {
  				point[m][n].setPiece(piece, this);
  				(point[startI][startJ]).setHasPiece(false);
  				record.��¼����(piece, startI, startJ, m, n);
  				record.��¼�Ե�������("û������");
   
  				if (piece.�������().equals(�췽��ɫ)) {
  					�췽���� = false;
  					�ڷ����� = true;
  				}
  				if (piece.�������().equals(�ڷ���ɫ)) {
  					�ڷ����� = false;
  					�췽���� = true;
  				}
  			} else {
  				piece.setLocation(startX, startY);
  				(point[startI][startJ]).setHasPiece(true);
  			}
  		}
  	}
   
  	if (piece != null && !containChessPoint) {
  		piece.setLocation(startX, startY);
  		(point[startI][startJ]).setHasPiece(true);
  	}
  }
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void mouseClicked(MouseEvent e) {
  }
  }
