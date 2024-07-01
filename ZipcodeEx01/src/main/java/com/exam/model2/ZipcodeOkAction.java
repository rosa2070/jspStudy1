package com.exam.model2;

import com.exam.model1.ZipcodeDAO;
import com.exam.model1.ZipcodeTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ZipcodeOkAction implements Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("ZipcodeOkAction");

        String strDong = req.getParameter("strDong");

        ZipcodeDAO dao = new ZipcodeDAO();
        ArrayList<ZipcodeTO> lists = dao.listZipcode(strDong);

        req.setAttribute("lists", lists);
    }
}
