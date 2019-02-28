package jack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 棋盘类
 * @author 银涛
 *
 */
  public class ChessBoard extends JPanel implements MouseListener,
  	MouseMotionListener {
	  //棋子二维数组
	  public ChessPoint point[][];
	  //棋盘单元格宽和高
	  public int unitWidth, unitHeight;
	  //x轴长和y轴长
	  private int x轴长, y轴长;
	  //鼠标拖动时候的目标物x、y坐标
	  private int x, y;
	  //棋盘背景图片
	  private Image img;
	  //棋子背景图片
	  protected Image pieceImg;
	  //判断棋子是否能移动
	  private boolean move = false;
	  //设置棋子的归属颜色
	  public String 红方颜色 = "红方", 黑方颜色 = "黑方",未知颜色="无色";
	  //每一个棋子类（红方和黑方的字）
	  ChessPiece 红象, 红狮, 红虎, 红豹, 红狼, 红狗, 红猫, 红鼠;
	  ChessPiece 黑象, 黑狮, 黑虎, 黑豹, 黑狼, 黑狗, 黑猫, 黑鼠;
	  //TODO 在未点开之前都是箱子。
	  ChessPiece 箱子1,箱子2,箱子3,箱子4,箱子5,箱子6,箱子7,箱子8;
	  ChessPiece 箱子9,箱子10,箱子11,箱子12,箱子13,箱子14,箱子15,箱子16;
	  //测试范围矩形的水平坐标X和垂直坐标Y
	  int startX, startY;
	  //确认被选中后目标水平坐标X和垂直坐标Y
	  int startI, startJ;
	  //标记哪一方走棋
	  public boolean 红方走棋 = true, 黑方走棋 = false;
	  //棋子走法规范
	  Rule rule = null;
	  //记录棋盘
	  public MakeChessManual record = null;
	  
	  /**
	   * 初始化棋盘
	   * @param w 	棋盘单元格宽
	   * @param h	棋盘单元格高
	   * @param r	x轴长
	   * @param c	y轴长
	   */
  public ChessBoard(int w, int h, int r, int c) {
  	setLayout(null);
  	addMouseListener(this);
  	addMouseMotionListener(this);
  	Color bc = getBackground();
  	unitWidth = w;
  	unitHeight = h;
  	x轴长 = r;
  	y轴长 = c;
  point = new ChessPoint[r + 1][c + 1];
   
  for (int i = 1; i <= r; i++) {
  	for (int j = 1; j <= c; j++) {
  		//初始化每一个棋盘点，并且设置好他们的尺寸以及是否存在棋子
  		point[i][j] = new ChessPoint(i * unitWidth, j * unitHeight,
  				false);
  	}
  }
  //初始化走法规则
  rule = new Rule(this, point);
  //初始化制作棋谱
  record = new MakeChessManual(this, point);
  //获取背景图片
  img = Toolkit.getDefaultToolkit().getImage("F:\\JAVA\\Eclipse\\inta\\animalGame\\src\\jack\\01.jpg");
  //获取棋子背景图片
  pieceImg = Toolkit.getDefaultToolkit().getImage("F:\\JAVA\\Eclipse\\inta\\animalGame\\src\\jack\\02.jpg");
  
  //初始化所有棋子
  红象 = new ChessPiece("象", Color.red, bc, w - 4, h - 4, this);
  红象.set棋子类别(红方颜色);
  红狮 = new ChessPiece("狮", Color.red, bc, w - 4, h - 4, this);
  红狮.set棋子类别(红方颜色);
  红虎 = new ChessPiece("虎", Color.red, bc, w - 4, h - 4, this);
  红虎.set棋子类别(红方颜色);
  红豹 = new ChessPiece("豹", Color.red, bc, w - 4, h - 4, this);
  红豹.set棋子类别(红方颜色);
  红狼 = new ChessPiece("狼", Color.red, bc, w - 4, h - 4, this);
  红狼.set棋子类别(红方颜色);
  红狗 = new ChessPiece("狗", Color.red, bc, w - 4, h - 4, this);
  红狗.set棋子类别(红方颜色);
  红猫 = new ChessPiece("猫", Color.red, bc, w - 4, h - 4, this);
  红猫.set棋子类别(红方颜色);
  红鼠 = new ChessPiece("鼠", Color.red, bc, w - 4, h - 4, this);
  红鼠.set棋子类别(红方颜色);
  
  
  黑象 = new ChessPiece("象", Color.black, bc, w - 4, h - 4, this);
  黑象.set棋子类别(黑方颜色);
  黑狮 = new ChessPiece("狮", Color.black, bc, w - 4, h - 4, this);
  黑狮.set棋子类别(黑方颜色);
  黑虎 = new ChessPiece("虎", Color.black, bc, w - 4, h - 4, this);
  黑虎.set棋子类别(黑方颜色);
  黑豹 = new ChessPiece("豹", Color.black, bc, w - 4, h - 4, this);
  黑豹.set棋子类别(黑方颜色);
  黑狼 = new ChessPiece("狼", Color.black, bc, w - 4, h - 4, this);
  黑狼.set棋子类别(黑方颜色);
  黑狗 = new ChessPiece("狗", Color.black, bc, w - 4, h - 4, this);
  黑狗.set棋子类别(黑方颜色);
  黑猫 = new ChessPiece("猫", Color.black, bc, w - 4, h - 4, this);
  黑猫.set棋子类别(黑方颜色);
  黑鼠 = new ChessPiece("鼠", Color.black, bc, w - 4, h - 4, this);
  黑鼠.set棋子类别(黑方颜色);

//  箱子1 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子1.set棋子类别(未知颜色);
//  箱子2 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子2.set棋子类别(未知颜色);
//  箱子3 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子3.set棋子类别(未知颜色);
//  箱子4 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子4.set棋子类别(未知颜色);
//  箱子5 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子5.set棋子类别(未知颜色);
//  箱子6 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子6.set棋子类别(未知颜色);
//  箱子7 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子7.set棋子类别(未知颜色);
//  箱子8 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子8.set棋子类别(未知颜色);
//  箱子9 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子9.set棋子类别(未知颜色);
//  箱子10 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子10.set棋子类别(未知颜色);
//  箱子11 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子11.set棋子类别(未知颜色);
//  箱子12 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子12.set棋子类别(未知颜色);
//  箱子13 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子13.set棋子类别(未知颜色);
//  箱子14 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子14.set棋子类别(未知颜色);
//  箱子15 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子15.set棋子类别(未知颜色);
//  箱子16 = new ChessPiece("?", Color.blue, bc, w - 4, h - 4, this);
//  箱子16.set棋子类别(未知颜色);

//  ChessPiece[] boxs = {箱子1,箱子2,箱子3,箱子4,箱子5,箱子6,箱子7,箱子8,
//  箱子9,箱子10,箱子11,箱子12,箱子13,箱子14,箱子15,箱子16};
  
  ChessPiece[] names={红象, 红狮, 红虎, 红豹, 红狼, 红狗, 红猫, 红鼠,
		  黑象, 黑狮, 黑虎, 黑豹, 黑狼, 黑狗, 黑猫, 黑鼠};
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
  int imgHeight = img.getHeight(this);// 获得图片的宽度与高度
  int FWidth = getWidth();
  int FHeight = getHeight();// 获得窗口的宽度与高度
  int x = (FWidth - imgWidth) / 2;
  int y = (FHeight - imgHeight) / 2;
  g.drawImage(img, x, y, null);
   
  for (int j = 1; j <= y轴长; j++) {
  	g.drawLine(point[1][j].x, point[1][j].y, point[x轴长][j].x,
  			point[x轴长][j].y);
  }
  for (int i = 1; i <= x轴长; i++) {
  		g.drawLine(point[i][1].x, point[i][1].y, point[i][y轴长].x,
  				point[i][y轴长].y);
  		g.drawString("" + i, i * unitWidth, unitHeight / 2);
  }

  int j = 1;
  for (char c = 'A'; c <= 'D'; c++) {
  	g.drawString("" + c, unitWidth / 4, j * unitHeight);
  	j++;
  }
  }

  /**鼠标按下事件*/
  public void mousePressed(MouseEvent e) {
  	ChessPiece piece = null;
  	Rectangle rect = null;
  	if (e.getSource() == this)
  		move = false;
  	if (move == false)
  		if (e.getSource() instanceof ChessPiece) {
  			piece = (ChessPiece) e.getSource();
  			//获取棋子起始位置的水平与垂直坐标
  			startX = piece.getBounds().x;
  			startY = piece.getBounds().y;
	  		rect = piece.getBounds();
	  		for (int i = 1; i <= x轴长; i++) {
	  			for (int j = 1; j <= y轴长; j++) {
	  				int x = point[i][j].getX();
	  				int y = point[i][j].getY();
	  				if (rect.contains(x, y)) {
	  					//如果矩形包含了棋盘位置点，获得该点坐标
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

  /**鼠标拖动事件*/
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
	  		if (红方走棋 && ((piece.棋子类别()).equals(红方颜色))) {
	  			piece.setLocation(x - piece.getWidth() / 2,
	  					y - piece.getHeight() / 2);
	  		}
	  		if (黑方走棋 && (piece.棋子类别().equals(黑方颜色))) {
	  			piece.setLocation(x - piece.getWidth() / 2,
	  					y - piece.getHeight() / 2);
	  		}
	  	}
	  }

  }

  /**松开鼠标事件*/
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
  		for (int i = 1; i <= x轴长; i++) {
  			for (int j = 1; j <= y轴长; j++) {
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
  		Color pieceColor = piece.获取棋子颜色();
  		if (point[m][n].isPiece()) {
  			Color c = (point[m][n].getPiece()).获取棋子颜色();
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
  					record.记录棋谱(piece, startI, startJ, m, n);
  					//TODO 记录吃掉的字和获胜条件
  					record.记录吃掉的棋子(pieceRemoved);
  					rule.isWine(pieceRemoved);
  					if (piece.棋子类别().equals(红方颜色)) {
  						红方走棋 = false;
  						黑方走棋 = true;
  					}
  					if (piece.棋子类别().equals(黑方颜色)) {
  						黑方走棋 = false;
  						红方走棋 = true;
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
  				record.记录棋谱(piece, startI, startJ, m, n);
  				record.记录吃掉的棋子("没吃棋子");
   
  				if (piece.棋子类别().equals(红方颜色)) {
  					红方走棋 = false;
  					黑方走棋 = true;
  				}
  				if (piece.棋子类别().equals(黑方颜色)) {
  					黑方走棋 = false;
  					红方走棋 = true;
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
