package game;

import entities.Ground;
import listener.GroundAdapter;
import util.Global;


/**
 * �Լ��õ�һ��GroundListener, �������������ϰ���, ����Ȥζ��
 * 
 * @version 1.0, 01/01/08
 * 
 * @author ������
 * 
 */

public class MyGroundListener extends GroundAdapter {

	int deletedLineCount = 0;

	@Override
	public void fullLineDeleted(Ground ground, int deletedLineCount) {

		this.deletedLineCount += deletedLineCount;
		// TODO Auto-generated method stub
		if ((deletedLineCount %= 10) == 9 || deletedLineCount > 2)
			for (int y = 0; y < Global.HEIGHT; y++)
				for (int x = 0; x < Global.WIDTH; x++)
					if (ground.isStubbornObstacle(x, y))
						ground.addObstacle(x, y);
	}

}