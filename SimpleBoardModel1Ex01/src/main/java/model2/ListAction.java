package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simple1.BoardDAO;
import simple1.BoardTO;

public class ListAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "ListAction" );
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardTO> boardLists = dao.boardList();
		
		request.setAttribute( "boardLists", boardLists );
	}

}
