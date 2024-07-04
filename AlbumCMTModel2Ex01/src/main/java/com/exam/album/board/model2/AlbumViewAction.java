package com.exam.album.board.model2;

import java.util.ArrayList;

import com.exam.album.board.model1.AlbumDAO;
import com.exam.album.board.model1.AlbumTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AlbumViewAction implements AlbumAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "AlbumViewAction 호출" );
		
		AlbumTO bto = new AlbumTO();
		bto.setSeq( request.getParameter( "seq" ) );

		AlbumDAO dao = new AlbumDAO();
		bto = dao.albumView( bto );

		request.setAttribute( "cpage", request.getParameter( "cpage" ) );
		request.setAttribute( "bto", bto );
	}

}
