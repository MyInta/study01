package util;

public class GameFunction {
	
	/**
	 * ����˯��ʱ�䣨���ٶȣ���ȼ�����������
	 * @param level �ȼ�
	 * @return ˯��ʱ��
	 */
	public static long getSleepTimeByLevel(int level) {
		long time = -40*level+740;
		time = time<100?100:time;
		return time;
	}
}
