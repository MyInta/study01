package util;

public class GameFunction {
	
	/**
	 * 设置睡眠时间（加速度）随等级上升而上升
	 * @param level 等级
	 * @return 睡眠时间
	 */
	public static long getSleepTimeByLevel(int level) {
		long time = -40*level+740;
		time = time<100?100:time;
		return time;
	}
}
