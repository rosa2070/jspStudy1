package action2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("View1Action execute 호출");
		System.out.println("data : " + request.getParameter("data"));

	}

}
