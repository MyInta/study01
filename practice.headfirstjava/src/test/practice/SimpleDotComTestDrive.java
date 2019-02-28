package test.practice;
/**
 * 测试用代码
 * @author 银涛
 *
 */
public class SimpleDotComTestDrive {
	public static void main(String[] args) {
		SimpleDotCom dot = new SimpleDotCom();
		int[] locations = {2,3,4};
		//注意该行是因为我修改了，与其他类冲突才报错，避免麻烦我注释掉了
		//dot.setLocationCells(locations);
		String userGuess = "2";
		String result = dot.checkYourself(userGuess);
		String testResult = "failed";
		if(result.equals("hit")) {
			testResult = "passed";
		}
		System.out.println(testResult);
	}
}
