package test.chainOfResp;
/**
 * �ܾ���
 * @author ����
 *
 */
public class GeneralManager extends Leader{
	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest reques) {
		if(reques.getLeaveDays()<30) {
			System.out.println("Ա��:"+reques.getEmpName()+"��٣�������"+reques.getLeaveDays()+"������:"+reques.getReason());
			System.out.println("�ܾ���"+this.name+",����ͨ����");
		}else {
			System.out.println("Ī��"+reques.getEmpName()+"���ְ����٣�"+reques.getLeaveDays()+"�죡");
		}
	}

}
