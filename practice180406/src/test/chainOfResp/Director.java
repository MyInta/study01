package test.chainOfResp;
/**
 * ����
 * �̳г�����Leader ��Ҫʵ������� ����������� ���ε�ʵ�� �������κ�������ɿͻ�������
 * @author ����
 *
 */
public class Director extends Leader{
	public Director(String name) {
		super(name);
	}
	/**
	 * ����ʵ�ַ���
	 */
	@Override
	public void handleRequest(LeaveRequest reques) {
		if(reques.getLeaveDays()<3) {
			System.out.println("Ա��:"+reques.getEmpName()+"��٣�������"+reques.getLeaveDays()+"������:"+reques.getReason());
			System.out.println("���Σ�"+this.name+",����ͨ����");
		}else {
			if(this.nextLeader!=null) {
				this.nextLeader.handleRequest(reques);
			}
		}
	}

}
