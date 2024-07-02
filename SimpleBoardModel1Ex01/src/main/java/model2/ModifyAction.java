package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simple1.BoardDAO;
import simple1.BoardTO;

public class ModifyAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "ModifyAction" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardModify( to );

		request.setAttribute( "to", to );
	}

}
