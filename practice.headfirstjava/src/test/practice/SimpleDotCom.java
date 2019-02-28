package test.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 使用链表，来解决重复数字出现的hit Bug
 * @author 银涛
 *
 */
public class SimpleDotCom {
	List<Integer> locationCells = new ArrayList<>();
	int numOfHits=0;
	int cellLength = 0;
	public int getCellLength() {
		return cellLength;
	}
	public void setCellLength(int cellLength) {
		this.cellLength = cellLength;
	}
	public List<Integer> getLocationCells() {
		return locationCells;
	}
	public void setLocationCells(List<Integer> locationCells) {
		this.locationCells = locationCells;
	}

	public String checkYourself(String stringGuess) {
		int guess = Integer.parseInt(stringGuess);
		String result = "miss";
		Iterator<Integer> it = locationCells.iterator();
			while(it.hasNext()) {
				if(guess==it.next()) {
					result = "hit";
					numOfHits++;
					it.remove();
					break;
				}
			}
		if(numOfHits==cellLength) {
			result = "kill";
		}
		System.out.println(result);
		return result;
	}
	/**
	 * 游戏的mian方法
	 * @param args
	 */
	public static void main(String[] args) {
		int numOfGuesses = 0;
		GameHelper helper =  new GameHelper();
		SimpleDotCom theDotCom = new SimpleDotCom();
		int randomNum =(int)(Math.random()*8);
		List<Integer> locations = new ArrayList<>();
		locations.add(randomNum);
		locations.add(randomNum+1);
		locations.add(randomNum+2);
		theDotCom.setCellLength(locations.size());
		theDotCom.setLocationCells(locations);
		boolean isAlive = true;
		while(isAlive) {
			String guess = helper.getUserInput("enter a number");
			String result = theDotCom.checkYourself(guess);
			numOfGuesses++;
			if(result.equals("kill")) {
				isAlive = false;
				System.out.println("You took "+numOfGuesses+" guesses");
				System.out.println("randomNum: "+randomNum);
			}
		}
		
		
		
	}
}
