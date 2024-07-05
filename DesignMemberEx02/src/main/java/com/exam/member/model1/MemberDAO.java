package com.exam.member.model1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataSource;
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			this.dataSource = (DataSource)envCtx.lookup("jdbc/mariadb4");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		}
	}
	
	public int addMember(MemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 1;
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getId());
			pstmt.setString(2, to.getPassword());
			pstmt.setString(3, to.getName());
			pstmt.setString(4, to.getGender());
			pstmt.setString(5, to.getBirth());
			pstmt.setString(6, to.getMail());
			pstmt.setString(7, to.getPhone());
			pstmt.setString(8, to.getAddress());
			pstmt.setString(9, to.getRegistDay());
			
			int result = pstmt.executeUpdate();
			if ( result == 1) {
				flag = 0;
			}
		} catch (SQLException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( pstmt != null ) try { pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try { conn.close(); } catch(SQLException e) {}
		}
		return flag;
		
	}
	
	public MemberTO login(String id, String password) {
		MemberTO to = new MemberTO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = this.dataSource.getConnection();
		String sql = "select id, password, name, gender, birth, mail, phone, address, regist_day from member where id = ? and password = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			to.setId(rs.getString("id"));
			to.setPassword(rs.getString("password"));
			to.setName(rs.getString("name"));
			to.setGender(rs.getString("gender"));
			to.setId(rs.getString("id"));
			to.setId(rs.getString("id"));
			to.setId(rs.getString("id"));
			to.setId(rs.getString("id"));
		}
		
		
		return null;
		
	}
}
