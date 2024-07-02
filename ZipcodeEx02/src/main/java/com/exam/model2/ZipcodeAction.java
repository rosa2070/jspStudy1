package com.exam.model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZipcodeAction implements Action{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("ZipcodeAction");
    }
}
