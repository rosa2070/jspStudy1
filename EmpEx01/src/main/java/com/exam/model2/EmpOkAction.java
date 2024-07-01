package com.exam.model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.model1.EmpDAO;
import com.exam.model1.EmpTO;

public class EmpOkAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("EmpOkAction");
		
		String ename = req.getParameter("ename");
		
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpTO> lists = dao.listEmp(ename);
		
		req.setAttribute("lists", lists);
	}
}
