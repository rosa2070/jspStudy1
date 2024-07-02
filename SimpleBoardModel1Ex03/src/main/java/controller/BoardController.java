package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.BoardAction;
import model2.DeleteAction;
import model2.DeleteOkAction;
import model2.ListAction;
import model2.ModifyAction;
import model2.ModifyOkAction;
import model2.ViewAction;
import model2.WriteAction;
import model2.WriteOkAction;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
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
		
		try {
			request.setCharacterEncoding( "utf-8" );
			
			String path = request.getServletPath();
			
			BoardAction action = null;
			
			String url = "/WEB-INF/views/error.jsp";
			if( path.equals( "/list.do" ) ) {
				action = new ListAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_list1.jsp";
			} else if( path.equals( "/view.do" ) ) {
				action = new ViewAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_view1.jsp";
			} else if( path.equals( "/write.do" ) ) {
				action = new WriteAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_write1.jsp";				
			} else if( path.equals( "/write_ok.do" ) ) {
				action = new WriteOkAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_write1_ok.jsp";				
			} else if( path.equals( "/modify.do" ) ) {
				action = new ModifyAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_modify1.jsp";
			} else if( path.equals( "/modify_ok.do" ) ) {
				action = new ModifyOkAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_modify1_ok.jsp";				
			} else if( path.equals( "/delete.do" ) ) {
				action = new DeleteAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_delete1.jsp";
			} else if( path.equals( "/delete_ok.do" ) ) {
				action = new DeleteOkAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_delete1_ok.jsp";								
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher( url );
			dispatcher.forward( request, response );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		}
	}
}
