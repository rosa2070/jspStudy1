package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action2.View1Action;
import action2.View2Action;
import action2.Action;

/**
 * Servlet implementation class ControllerEx01
 */
@WebServlet("/controller")
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
        //controller                    view1.jsp
		//controller?path=view1         view1.jsp
        //controller?path=view2         view2.jsp
		
		try {
			request.setCharacterEncoding("utf-8");
			
			String path = request.getParameter("path");
			
			String url = "/WEB-INF/views/error.jsp";
			if (path == null || path.equals("") || path.equals("view1")) {
				url = "/WEB-INF/views/view1.jsp";
				
				//View1Action action = new View1Action();
				Action action = new View1Action();
				//action.execute();
				action.execute(request, response);
				
			} else if (path.equals("view2")) {
				url = "/WEB-INF/views/view2.jsp";
				
				//View2Action action = new View2Action();
				Action action = new View2Action();
				//action.execute();
				action.execute(request, response);
			}
			
			//System.out.println(url);
			
			// forward
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
