package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.FormAction;
import action.FormOkAction;

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
      
      try {
         request.setCharacterEncoding( "utf-8" );
         
         String path = request.getParameter( "path" );
         
         String url = "/WEB-INF/views/error.jsp";
         if( path == null || path.equals("") || path.equals( "form" ) ) {
            url ="/WEB-INF/views/form.jsp";
            
            Action action = new FormAction();
            action.execute(request, response);
            
         } else if( path.equals( "form_ok" ) ) {
            url ="/WEB-INF/views/form_ok.jsp";

            Action action = new FormOkAction();
            action.execute(request, response);
         }
         
         RequestDispatcher dispatcher = request.getRequestDispatcher( url );
         dispatcher.forward(request, response);
         
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









