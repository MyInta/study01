package practice04;
/**
 * ʵ��Comparable�Ľӿ�
 * @author ����
 *
 */
public class Person02 implements java.lang.Comparable<Person02> {
	private String name;
	private int score;
	public Person02() {
	}
	public Person02(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * ��дcompareTo�ķ���
	 */
	@Override
	public int compareTo(Person02 arg0) {
		//����ֵ������ǰ�ߴ��ں��߽����㼴��ȣ�����˵��ǰ��С�ں���Ϊ����
		return this.score>arg0.getScore()?1:this.score==arg0.getScore()?0:-1;
	}
	@Override
	public String toString() {
		return "���֣�"+name+"��ֵ������"+score+"\n";
	}
}
