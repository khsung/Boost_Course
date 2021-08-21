package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2 {

	public static void main(String[] args) {
		String id="JDBC";
		String username="JDBC";
		Role role=new Role(id,username);
		RoleDao dao=new RoleDao();
		int insertcount=dao.addRole(role);
		System.out.println(insertcount);
	}

}
