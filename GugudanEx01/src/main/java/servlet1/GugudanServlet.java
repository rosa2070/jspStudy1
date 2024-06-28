package servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GugudanServlet extends HttpServlet {

	// get
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}

	// post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
			
	// get post 통합
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.setContentType("text/html;charset=utf-8");
			
			//Servlet에 대한 정보
			ServletContext context = getServletContext();
			String serverInfo = context.getServerInfo();
			
			String path = context.getContextPath();
			String path2 = context.getRealPath(path);
			
			StringBuilder sbHtml = new StringBuilder();
			sbHtml.append("<!DOCTYPE html>");
			sbHtml.append("<html>");
			sbHtml.append("<head>");
			sbHtml.append("<mate charset='utf-8' />");
			sbHtml.append("<title>Insert title here</title>");
			sbHtml.append("</head>");
			sbHtml.append("<body>");
			sbHtml.append("Hello Gugudan<br />");
			sbHtml.append(serverInfo + "<br />");
			sbHtml.append(path + "<br />");
			sbHtml.append(path2 + "<br />");
			sbHtml.append("</body>");
			sbHtml.append("</html>");
			
			PrintWriter out = resp.getWriter();
			out.println(sbHtml.toString());
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러]" + e.getMessage());
		}
		
		
	}

}
