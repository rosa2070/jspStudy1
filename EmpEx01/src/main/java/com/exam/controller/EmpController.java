package com.exam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.model2.Action;
import com.exam.model2.EmpAction;
import com.exam.model2.EmpOkAction;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/controller")
public class EmpController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {
				req.setCharacterEncoding("utf-8");
				
				String path = req.getParameter("path");
				
				String url = "/WEB_INF/views/error.jsp";
				
				if (path.equals("emp")) {
					
					Action action = new EmpAction();
					action.execute(req, resp);
					
					url = "/WEB-INF/views/emp.jsp";
					
				} else if (path.equals("emp_ok")) {
					
					Action action = new EmpOkAction();
					action.execute(req, resp);
					
					url = "/WEB-INF/views/emp_ok.jsp";
				}
				RequestDispatcher dispatcher = req.getRequestDispatcher(url);
				dispatcher.forward(req, resp);
		} catch (ServletException e) {
			System.out.println("[에러] " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[에러] " + e.getMessage());
		}
	
	}
}
