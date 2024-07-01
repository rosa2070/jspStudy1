package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormOkAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      
      System.out.println( "FormOkAction execute 호출" );
      System.out.println( "data : " + request.getParameter( "data" ) );

      // 백엔드컨트롤러 -> jsp
      request.setAttribute( "data", request.getParameter( "data" ) );
   }

}
