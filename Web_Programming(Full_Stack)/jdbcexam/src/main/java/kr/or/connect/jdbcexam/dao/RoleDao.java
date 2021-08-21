package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	private static String dburl="jdbc:mysql://localhost:3306/aaaa?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbuser="root";
	private static String dbpassword="rnjsdudwn1";
	
	public List<Role> getRoles(){
		List<Role> list=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql ="SELECT * FROM test";
		try(Connection conn=DriverManager.getConnection(dburl,dbuser,dbpassword);
			PreparedStatement ps=conn.prepareStatement(sql)) {
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					String user_id=rs.getString(1);
					String user_name=rs.getString(2);
					Role role=new Role(user_id,user_name);
					list.add(role);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return list;
	}
	
	public int addRole(Role role) {
		int insertcount=0;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbuser,dbpassword);
			String sql="INSERT INTO test (id,username) VALUES(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, role.getId());
			ps.setString(2, role.getUsername());
			insertcount=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return insertcount;
	}
	
	public Role getRole(String id) {
		Role role=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbuser,dbpassword);
			String sql="SELECT id,username FROM test WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				String userid=rs.getString(1);
				String username=rs.getString("username");
				role=new Role(userid,username);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return role;
	}
}
