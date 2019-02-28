package test.chainOfResp;
/**
 * ������
 * @author ����
 *
 */
public abstract class Leader {
	//ʹ��protected����Ϊ���ࡢ����ͬ���ʹ��
	protected String name;
	protected Leader nextLeader;//�������ϵĺ�̶���
	public Leader(String name) {
		super();
		this.name = name;
	}
	//�趨�������ĺ�̶���---->һ�㽻���ͻ�ʵ�֣��ÿͻ��������κ�̶���˳��
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	/**
	 * ��������ĺ��ĵ�ҵ�񷽷�
	 * @param reques
	 */
	public abstract void handleRequest(LeaveRequest reques);
	
	
}
