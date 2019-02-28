package test;

import java.util.List;

import sorm.core.MySqlQuery;
import sorm.core.Query;
import sorm.core.QueryFactory;
import vo.EmpVO;

/**
 * 客户端调用测试类
 * @author 银涛
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Query q = QueryFactory.createQuery();
		String sql2 = "select e.id,e.empname,e.salary+e.bonus 'xinzi',e.age,d.dname 'deptName',d.address 'deptAddr' from emp e " + 
				"join dept d on e.deptId=d.id";
		List<EmpVO> list2 = q.queryRows(sql2,EmpVO.class, null);
		
		for(EmpVO e:list2) {
			System.out.println(e.getEmpname()+"-"+e.getDeptAddr()+"-"+e.getDeptName());
		}
	}
}
