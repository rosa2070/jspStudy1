package com.exam.album.board.model2;

import com.exam.album.board.model1.AlbumDAO;
import com.exam.album.board.model1.AlbumTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AlbumModifyAction implements AlbumAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "AlbumModifyAction 호출" );
		
		AlbumTO to = new AlbumTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		AlbumDAO dao = new AlbumDAO();
		to = dao.albumModify( to );

		request.setAttribute( "cpage", request.getParameter( "cpage" ) );
		request.setAttribute( "to", to );
	}

}
