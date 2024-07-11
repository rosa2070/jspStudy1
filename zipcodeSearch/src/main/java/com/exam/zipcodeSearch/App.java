package com.exam.zipcodeSearch;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:mariadb://localhost:3306/project";
        String user = "root";
        String password = "123456";
        
        Connection conn = null;
        
        try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
			
			String sql = "select zipcode, sido, gugun, dong, ri, bunji where dong = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sql);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} finally {
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx01 frame = new JFrameEx01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
