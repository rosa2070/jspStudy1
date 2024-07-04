package com.exam.album.board.model2;

import com.exam.album.board.model1.AlbumDAO;
import com.exam.album.board.model1.AlbumTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AlbumDeleteOkAction implements AlbumAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "AlbumDeletOkAction 호출" );
		
		AlbumTO to = new AlbumTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );
		
		AlbumDAO dao = new AlbumDAO();
		int flag = dao.albumDeleteOk(to);

		request.setAttribute( "flag", flag );
	}

}
