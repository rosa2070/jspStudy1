package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerEx01
 */
@WebServlet("*.do")
public class ControllerEx01 extends HttpServlet {
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
		// 1.
		//System.out.println(request.getRequestURI());
		//System.out.println(request.getContextPath());
		// 2.
		//System.out.println(request.getServletPath());
		
		try {
			request.setCharacterEncoding("utf-8");
			
			String path = request.getServletPath();
			
			String url = "/WEB-INF/views/error.jsp";
			
			if( path.equals("/view1.do")) {
				url = "/WEB-INF/views/view1.jsp";
			} else if (path.equals("/view2.do")) {
				url = "/WEB-INF/views/view2.jsp";
			} else if (path.equals("/board/view1.do")) {
				url = "/WEB-INF/views/view1.jsp";
			} else if (path.equals("/board/view2.do")) {
				url = "/WEB-INF/views/view2.jsp";
			} 
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] " + e.getMessage());
		}
	}

}
