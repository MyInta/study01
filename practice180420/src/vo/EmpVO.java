package vo;

public class EmpVO {
	private Integer id;
	private String  empname;
	private Double xinzi;
	private Integer age;
	private String deptName;
	private String deptAddr;
	
	public EmpVO(Integer id, String empname, double xinzi, Integer age, String deptName, String deptAddr) {
		super();
		this.id = id;
		this.empname = empname;
		this.xinzi = xinzi;
		this.age = age;
		this.deptName = deptName;
		this.deptAddr = deptAddr;
	}
	public EmpVO() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Double getXinzi() {
		return xinzi;
	}
	public void setXinzi(Double xinzi) {
		this.xinzi = xinzi;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptAddr() {
		return deptAddr;
	}
	public void setDeptAddr(String deptAddr) {
		this.deptAddr = deptAddr;
	}
	
}
