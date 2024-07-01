package com.exam.model1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class EmpDAO {
	private DataSource dataSource;
	
	public EmpDAO() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			this.dataSource = (DataSource) envCtx.lookup("jdbc/mariadb1");
		} catch (NamingException e) {
			System.out.println("에러 : " + e.getMessage());
		}
	}
	
	public ArrayList<EmpTO> listEmp(String ename) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<EmpTO> lists = new ArrayList<EmpTO>();
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where ename like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename + "%");
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpTO to = new EmpTO();
				to.setEmpno(rs.getString("empno"));
				to.setEname(rs.getString("ename"));
				to.setJob(rs.getString("job"));
				to.setMgr(rs.getString("mgr"));
				to.setHiredate(rs.getString("hiredate"));
				to.setSal(rs.getString("sal"));
				to.setComm(rs.getString("comm"));
				to.setDeptno(rs.getString("deptno"));
				
				lists.add(to);
				
			}
		} catch (SQLException e) {
			System.out.println("[에러] " + e.getMessage());
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn != null) try { conn.close(); } catch(SQLException e) {}
			if (rs != null) try { rs.close(); } catch(SQLException e) {}
		}
			return lists;
		
	}

}
