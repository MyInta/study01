package practice04;
/**
 * ����TreeSet�Ĳ���Comparator���� ʵ����
 * @author ����
 *
 */
public class Person {
	//��final�Ƿ�ֹTreeSet�Զ����м�����̣�һ���������ݣ����µ�˳�򲻷�
	private final String name;
	private final int score;
	public Person() {
		name = null;
		score = 0;
	}
	public Person(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getScore() {
		return score;
	}
//	public void setScore(int score) {
//		this.score = score;
//	}
	@Override
	public String toString() {
		return "������"+name+"��ֵ"+score+"\n";
	}
}
