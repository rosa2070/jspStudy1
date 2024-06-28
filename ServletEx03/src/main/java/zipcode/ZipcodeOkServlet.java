package zipcode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ZipcodeOkServlet
 */
@WebServlet("/zipcode_ok")
public class ZipcodeOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb1");
			
			conn = dataSource.getConnection();
			
			String sql = "select zipcode, sido from zipcode where dong like '신사%'";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while ( rs.next() ) {
				String zipcode = rs.getString("zipcode");
				String sido = rs.getString("sido");
				
				System.out.println( zipcode );
				System.out.println( sido );
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} finally {
			if ( rs != null ) try { rs.close(); } catch (SQLException e) {}
			if ( pstmt != null ) try { pstmt.close(); } catch (SQLException e) {}
			if ( conn != null ) try { conn.close(); } catch (SQLException e) {}
		}
	}

}
