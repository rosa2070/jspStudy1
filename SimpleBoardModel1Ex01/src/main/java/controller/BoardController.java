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
@WebServlet("/controller")
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
			
			//이건 어디서 받아옴?
			String path = request.getParameter( "path" );	
			
			BoardAction action = null;
			
			String url = "/WEB-INF/views/error.jsp";
			if( path.equals( "list" ) ) {
				action = new ListAction();
				action.execute(request, response);
				
				//new ListAction().execute(request, response);
				
				url = "/WEB-INF/views/board_list1.jsp";
			} else if( path.equals( "view" ) ) {
				action = new ViewAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_view1.jsp";
			} else if( path.equals( "write" ) ) {
				action = new WriteAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_write1.jsp";
			} else if( path.equals( "write_ok" ) ) {
				action = new WriteOkAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_write1_ok.jsp";
			} else if( path.equals( "modify" ) ) {
				action = new ModifyAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_modify1.jsp";
			} else if( path.equals( "modify_ok" ) ) {
				action = new ModifyOkAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_modify1_ok.jsp";
			} else if( path.equals( "delete" ) ) {
				action = new DeleteAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_delete1.jsp";
			} else if( path.equals( "delete_ok" ) ) {
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
