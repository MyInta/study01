package test.chainOfResp;
/**
 * 经理
 * @author 银涛
 *
 */
public class Manager extends Leader{
	public Manager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest reques) {
		if(reques.getLeaveDays()<10) {
			System.out.println("员工:"+reques.getEmpName()+"请假，天数："+reques.getLeaveDays()+"，理由:"+reques.getReason());
			System.out.println("经理："+this.name+",审批通过！");
		}else {
			if(this.nextLeader!=null) {
				this.nextLeader.handleRequest(reques);
			}
		}
	}

}
