package test.chainOfResp;
/**
 * ����
 * @author ����
 *
 */
public class Manager extends Leader{
	public Manager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest reques) {
		if(reques.getLeaveDays()<10) {
			System.out.println("Ա��:"+reques.getEmpName()+"��٣�������"+reques.getLeaveDays()+"������:"+reques.getReason());
			System.out.println("����"+this.name+",����ͨ����");
		}else {
			if(this.nextLeader!=null) {
				this.nextLeader.handleRequest(reques);
			}
		}
	}

}
