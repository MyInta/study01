package test.chainOfResp;
/**
 * ��װ��ٻ�����Ϣ
 * @author ����
 *
 */
public class LeaveRequest {
	private String empName;
	private int LeaveDays;
	private String reason;
	public LeaveRequest(String empName, int leaveDays, String reason) {
		super();
		this.empName = empName;
		LeaveDays = leaveDays;
		this.reason = reason;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getLeaveDays() {
		return LeaveDays;
	}
	public void setLeaveDays(int leaveDays) {
		LeaveDays = leaveDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
