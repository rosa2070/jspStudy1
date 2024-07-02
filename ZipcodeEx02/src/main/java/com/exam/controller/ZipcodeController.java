package com.exam.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.model2.Action;
import com.exam.model2.ZipcodeAction;
import com.exam.model2.ZipcodeOkAction;

/**
 * Servlet implementation class ZipcodeController
 */
@WebServlet("*.do")
public class ZipcodeController extends HttpServlet {
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
			request.setCharacterEncoding("utf-8");
			
			String path = request.getServletPath();
			
			String url = "/WEB-INF/views/error.jsp";
			
			Action action = null;
			
			if (path.equals("/zipcode.do")) {
				action = new ZipcodeAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/zipcode.jsp";
			} else if (path.equals("/zipcode_ok.do")) {
				action = new ZipcodeOkAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/zipcode_ok.jsp";
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
