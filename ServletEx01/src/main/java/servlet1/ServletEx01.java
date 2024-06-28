package servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx01 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		// 초기화 작업
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// 마무리 작업
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 요청에 대한 처리하는 부분
		//System.out.println( "service() 호출" );
		
		resp.setContentType( "text/html;charset=utf-8" );
		
		StringBuilder sbHtml = new StringBuilder();
		sbHtml.append( "<!DOCTYPE html>" );
		sbHtml.append( "<html>" );
		sbHtml.append( "<head>" );
		sbHtml.append( "<meta charset='utf-8' />" );
		sbHtml.append( "</head>" );
		sbHtml.append( "<body>" );
		sbHtml.append( "Hello Servlet" );
		sbHtml.append( "</body>" );
		sbHtml.append( "</html>" );

		
		PrintWriter out = resp.getWriter();
		out.print( sbHtml.toString() );
		out.print( "" );
		
		//out.println( "<!DOCTYPE html>" );
		//out.println( "<html>" );
		//out.println( "<head>" );
		//out.println( "<meta charset='utf-8' />" );
		//out.println( "</head>" );
		//out.println( "<body>" );
		//out.println( "Hello Servlet" );
		//out.println( "</body>" );
		//out.println( "</html>" );
		
		out.close();
	}
}








