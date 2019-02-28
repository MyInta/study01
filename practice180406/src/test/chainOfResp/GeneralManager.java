package test.chainOfResp;
/**
 * 总经理
 * @author 银涛
 *
 */
public class GeneralManager extends Leader{
	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest reques) {
		if(reques.getLeaveDays()<30) {
			System.out.println("员工:"+reques.getEmpName()+"请假，天数："+reques.getLeaveDays()+"，理由:"+reques.getReason());
			System.out.println("总经理："+this.name+",审批通过！");
		}else {
			System.out.println("莫非"+reques.getEmpName()+"想辞职？请假："+reques.getLeaveDays()+"天！");
		}
	}

}
