package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import config.FrameConfig;
import config.GameConfig;
import dto.GameDto;

/**
 * 绘制窗口
 * @author 银涛
 *
 */
public class Layer {
	
	/**
	 * 内边距
	 */
	protected static final int PADDING;
	/**
	 * 边框宽度
	 */
	protected static final int SIZE;
	static {
		// 获得游戏配置
		FrameConfig fcf = GameConfig.getFrameConfig();
		PADDING = fcf.getPadding();
		SIZE =fcf.getBorder();
	}
	
	private static int WINDOW_W = Img.WINDOW.getWidth(null);
	private static int WINDOW_H = Img.WINDOW.getHeight(null);
	
	/**
	 * 默认字体大小
	 */
	private static final Font DEF_FONT=new Font("黑体",Font.BOLD,20);
	
	/**
	 * 数字切片的宽度
	 */
	protected static final int IMG_NUMBER_W=Img.NUMBER.getWidth(null)/10;
	/**
	 * 数字切片的高度
	 */
	private static final int IMG_NUMBER_H=Img.NUMBER.getHeight(null);
	/**
	 * 矩形值槽背景（宽度）
	 */
	private static final int IMG_RECT_W = Img.RECT.getWidth(null);
	/**
	 * 矩形值槽背景（高度）
	 */
	protected static final int IMG_RECT_H = Img.RECT.getHeight(null);
	/**
	 * 矩形值槽（宽度）
	 */
	private final int rectW ;
	
	/**
	 * 窗口左上角x坐标
	 */
	protected final int x;
	/**
	 * 窗口左上角y坐标
	 */
	protected final int y;
	/**
	 * 窗口宽度w
	 */
	protected final int w;
	/**
	 * 窗口高度h
	 */
	protected final int h;

	/**
	 * 游戏数据
	 */
	protected GameDto dto=null;
	
	protected Layer(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rectW = this.w-(PADDING<<1);
	}

	/**
	 * 绘制窗口
	 * 
	 * @author 银涛
	 * @param g 画笔
	 */
	protected void createWindow(Graphics g) {
		// 左上
		g.drawImage(Img.WINDOW, x, y, x + SIZE, y + SIZE, 0, 0, SIZE, SIZE, null);
		// 中上
		g.drawImage(Img.WINDOW, x + SIZE, y, x + w - SIZE, y + SIZE, SIZE, 0, WINDOW_W - SIZE, SIZE, null);
		// 右上
		g.drawImage(Img.WINDOW, x + w - SIZE, y, x + w, y + SIZE, WINDOW_W - SIZE, 0, WINDOW_W, SIZE, null);
		// 左中
		g.drawImage(Img.WINDOW, x, y + SIZE, x + SIZE, y + h - SIZE, 0, SIZE, SIZE, WINDOW_H - SIZE, null);
		// 中
		g.drawImage(Img.WINDOW, x + SIZE, y + SIZE, x + w - SIZE, y + h - SIZE, SIZE, SIZE, WINDOW_W - SIZE,
				WINDOW_H - SIZE, null);
		// 右中
		g.drawImage(Img.WINDOW, x + w - SIZE, y + SIZE, x + w, y + h - SIZE, WINDOW_W - SIZE, SIZE, WINDOW_W,
				WINDOW_H - SIZE, null);
		// 左下
		g.drawImage(Img.WINDOW, x, y + h - SIZE, x + SIZE, y + h, 0, WINDOW_H - SIZE, SIZE, WINDOW_H, null);
		// 中下
		g.drawImage(Img.WINDOW, x + SIZE, y + h - SIZE, x + w - SIZE, y + h, SIZE, WINDOW_H - SIZE, WINDOW_W - SIZE,
				WINDOW_H, null);
		// 右下
		g.drawImage(Img.WINDOW, x + w - SIZE, y + h - SIZE, x + w, y + h, WINDOW_W - SIZE, WINDOW_H - SIZE, WINDOW_W,
				WINDOW_H, null);
	}

	/**
	 * 数据库set方法
	 * @param dto
	 */
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	
	/**
	 * 绘画数据库内数字位置靠右对齐
	 * @param x
	 * @param y
	 * @param g
	 */
	protected void drawLeft(String strNum,int x,int y,Graphics g) {
		//5表示控制数值为五位以内
		for(int i=0;i<5;i++) {
			if((5-i)<=strNum.length()) {
				//获得数字在字符串中的下标
				int idx = strNum.length()+i-5;
				//把数字number中的每一位取出
				String bit = Integer.toString(strNum.charAt(idx)-'0');//加这个零是为了显示为数字int类型
				//绘制数字
				g.drawString(bit,x+i*10,y);	//10是单个数字的宽度
			}
		}
	}
	
	/**
	 * 显示数字
	 * @param x 左上角x坐标
	 * @param y 左上角y坐标
	 * @param num 要显示的数字
	 * @param maxBit 数字位数
	 * @param g 画笔对象
	 */
	protected void drawNumberLeftPad(int x,int y,int num,int maxBit,Graphics g) {
		//把number中的每一位数取出 转成字符串
		String strNum = Integer.toString(num);
		//循环绘制数字右靠齐
		for(int i=0;i<maxBit;i++) {
			//判断是否满足绘制条件
			if((maxBit-i)<=strNum.length()) {
				//获得数字在字符串中的下标
				int idx = strNum.length()+i-maxBit;
				//把数字number中的每一位取出
				int bit = strNum.charAt(idx)-'0';	//加这个零是为了显示为数字int类型
				//绘制数字
				g.drawImage(Img.NUMBER,
					this.x+x+IMG_NUMBER_W*i, this.y+y-PADDING, 	//数字图片透明层上高多空白16像素,差不多等PADDING。
					this.x+x+IMG_NUMBER_W*(i+1),  this.y+y+IMG_NUMBER_H-PADDING,
					bit*IMG_NUMBER_W, 0,
					(bit+1)*IMG_NUMBER_W, IMG_NUMBER_H,
					null);
			}
			
		}
	}
	
	/**
	 * 绘制值槽
	 * @param y 坐标
	 * @param title 标题
	 * @param number 数值
	 * @param percent 值占比
	 * @param g 画笔
	 */
	protected void drawRect(int y,String title,String number,double percent,Graphics g) {
		//各种值初始化
		int rect_x = this.x+PADDING;
		int rect_y = this.y+y;
		//绘制背景
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H+4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x+1, rect_y+1, this.rectW-2, IMG_RECT_H+2);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x+2, rect_y+2, this.rectW-4, IMG_RECT_H);
		//动态经验值
		/*g.setColor(getNowColor((double)(rmLine%LEVEL_UP),(double)LEVEL_UP));
		g.fillRect(this.x+PADDING+2, this.y+expY+2, w, h-4);*/
		
		//求出宽度
		int w=(int)(percent*(this.rectW-4));
		//求出颜色
		int subIdx = (int)(percent*IMG_RECT_W)-1;
		//绘制值槽
		g.drawImage(Img.RECT,
				rect_x+2, rect_y+2, 
				rect_x+2+w, rect_y+2+IMG_RECT_H,
				subIdx, 0, subIdx+1, IMG_RECT_H,
				null);
		g.setColor(Color.WHITE);
		g.setFont(DEF_FONT);
		g.drawString(title, rect_x+4, rect_y+22);
		if(null!=number) {
			//右对齐的显示方法
			drawLeft(number,rect_x+248, rect_y+22,g);
//			g.drawString(number, rect_x+248, rect_y+22);
		}
	}
	/**
	 * 正中绘画
	 * @param img 图片
	 * @param g 画笔
	 */
	protected void drawImagAtCenter(Image img,Graphics g) {
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		int imgX = (this.w-imgW>>1)+this.x;
		int imgY = (this.h-imgH>>1)+this.y;
		g.drawImage(img, imgX, imgY, null);
	}
	
	/**
	 * 刷新游戏具体内容
	 * 
	 * @author 银涛
	 * @param g 画笔
	 */
	public void paint(Graphics g) {

	}
}
