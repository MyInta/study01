package test.chainOfResp;
/**
 * 主任
 * 继承抽象类Leader 需要实现里面的 具体类的名称 责任的实现 不过责任后继链交由客户来设置
 * @author 银涛
 *
 */
public class Director extends Leader{
	public Director(String name) {
		super(name);
	}
	/**
	 * 核心实现方法
	 */
	@Override
	public void handleRequest(LeaveRequest reques) {
		if(reques.getLeaveDays()<3) {
			System.out.println("员工:"+reques.getEmpName()+"请假，天数："+reques.getLeaveDays()+"，理由:"+reques.getReason());
			System.out.println("主任："+this.name+",审批通过！");
		}else {
			if(this.nextLeader!=null) {
				this.nextLeader.handleRequest(reques);
			}
		}
	}

}
