package action1;import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View1Action {
	public void execute() {
		System.out.println("View1Action execute 호출");
		System.out.println("필요한 DAO 호출");
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("View1Action execute 호출");
		System.out.println("data : " + request.getParameter("data"));
		
	}

}
