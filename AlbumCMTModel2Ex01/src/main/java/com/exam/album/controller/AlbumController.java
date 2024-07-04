package com.exam.album.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.exam.album.board.model2.AlbumAction;
import com.exam.album.board.model2.AlbumDeleteAction;
import com.exam.album.board.model2.AlbumDeleteOkAction;
import com.exam.album.board.model2.AlbumListAction;
import com.exam.album.board.model2.AlbumModifyAction;
import com.exam.album.board.model2.AlbumModifyOkAction;
import com.exam.album.board.model2.AlbumViewAction;
import com.exam.album.board.model2.AlbumWriteAction;
import com.exam.album.board.model2.AlbumWriteOkAction;

import com.exam.album.cmt.model2.CommentWriteOkAction;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerEx01
 */
@WebServlet("*.do")
public class AlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding( "utf-8" );
			
			String path = request.getServletPath();
			
			String url = "/WEB-INF/views/board_error1.jsp";
			AlbumAction boardAction = null;
			
			if( path.equals( "/board_list.do" ) ) {
				boardAction = new AlbumListAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/views/board_list1.jsp";
			} else if( path.equals( "/board_view.do" ) ) {
				boardAction = new AlbumViewAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/views/board_view1.jsp";
			} else if( path.equals( "/board_write.do" ) ) {
				boardAction = new AlbumWriteAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/views/board_write1.jsp";
			} else if( path.equals( "/board_write_ok.do" ) ) {
				boardAction = new AlbumWriteOkAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/views/board_write1_ok.jsp";
			} else if( path.equals( "/board_modify.do" ) ) {
				boardAction = new AlbumModifyAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/views/board_modify1.jsp";
			} else if( path.equals( "/board_modify_ok.do" ) ) {
				boardAction = new AlbumModifyOkAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/views/board_modify1_ok.jsp";
			} else if( path.equals( "/board_delete.do" ) ) {
				boardAction = new AlbumDeleteAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/views/board_delete1.jsp";
			} else if( path.equals( "/board_delete_ok.do" ) ) {
				boardAction = new AlbumDeleteOkAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/views/board_delete1_ok.jsp";
			} else if( path.equals( "/comment_write_ok.do" ) ) {
				boardAction = new CommentWriteOkAction();
				boardAction.execute(request, response);
				
				url = "/WEB-INF/views/comment_write1_ok.jsp";
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
