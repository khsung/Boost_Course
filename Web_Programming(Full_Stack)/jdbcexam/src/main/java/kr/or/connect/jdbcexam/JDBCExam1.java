package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleDao dao=new RoleDao();
		Role role=dao.getRole("user");
		System.out.println(role);
	}

}
