package test.practice;
/**
 * �����ô���
 * @author ����
 *
 */
public class SimpleDotComTestDrive {
	public static void main(String[] args) {
		SimpleDotCom dot = new SimpleDotCom();
		int[] locations = {2,3,4};
		//ע���������Ϊ���޸��ˣ����������ͻ�ű��������鷳��ע�͵���
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
