package com.exam.jdbc01;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mariadb://localhost:3306/sample";
        String user = "root";
        String password = "123456";
        
        Connection conn = null;
        
        try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
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
                    WeekendCalendar frame = new WeekendCalendar();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

}
