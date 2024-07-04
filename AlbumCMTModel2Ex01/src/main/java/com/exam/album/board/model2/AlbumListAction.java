package com.exam.album.board.model2;

import java.util.ArrayList;

import com.exam.album.board.model1.AlbumDAO;
import com.exam.album.board.model1.AlbumListTO;
import com.exam.album.board.model1.AlbumTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AlbumListAction implements AlbumAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "AlbumListAction 호출" );
		
		int cpage = 1;
		if(request.getParameter( "cpage" ) != null && !request.getParameter( "cpage" ).equals( "" ) ) {
			cpage = Integer.parseInt( request.getParameter( "cpage" ) );
		}

		AlbumListTO listTO = new AlbumListTO();
		listTO.setCpage( cpage );
		
		AlbumDAO dao = new AlbumDAO();
		listTO = dao.albumList(listTO);
		
		request.setAttribute( "cpage", listTO.getCpage() );
		
		request.setAttribute( "recordPerPage", listTO.getRecordPerPage() );
		
		request.setAttribute( "totalRecord", listTO.getTotalRecord() );;
		request.setAttribute( "totalPage", listTO.getTotalPage() );
		
		request.setAttribute( "blockPerPage", listTO.getBlockPerPage() );
		request.setAttribute( "startBlock", listTO.getStartBlock() );
		request.setAttribute( "endBlock", listTO.getEndBlock() );
		
		request.setAttribute( "boardLists", listTO.getAlbumLists() );
	}
}
