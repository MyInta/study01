package test.chainOfResp;
/**
 * 抽象类
 * @author 银涛
 *
 */
public abstract class Leader {
	//使用protected限制为子类、包、同类可使用
	protected String name;
	protected Leader nextLeader;//责任链上的后继对象
	public Leader(String name) {
		super();
		this.name = name;
	}
	//设定责任链的后继对象---->一般交给客户实现，让客户决定责任后继对象顺序
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	/**
	 * 处理请求的核心的业务方法
	 * @param reques
	 */
	public abstract void handleRequest(LeaveRequest reques);
	
	
}
