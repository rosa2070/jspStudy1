package com.exam.controller;

import com.exam.model2.Action;
import com.exam.model2.ZipcodeAction;
import com.exam.model2.ZipcodeOkAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class ZipcodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");

            String path = req.getParameter("path");

            String url = "/WEB-INF/views/error.jsp";

            if (path.equals("zipcode")) {

                Action action = new ZipcodeAction();
                action.execute(req, resp);

                url = "/WEB-INF/views/zipcode.jsp";

            } else if (path.equals("zipcode_ok")) {

                Action action = new ZipcodeOkAction();
                action.execute(req, resp);

                url = "/WEB-INF/views/zipcode_ok.jsp";
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher(url);
            dispatcher.forward(req, resp);

        } catch (ServletException e) {
            System.out.println("[에러]" + e.getMessage());
        } catch (IOException e) {
            System.out.println("[에러]" + e.getMessage());
        }
    }
}
