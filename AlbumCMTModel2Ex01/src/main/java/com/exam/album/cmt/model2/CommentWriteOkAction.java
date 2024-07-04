package com.exam.album.cmt.model2;

import com.exam.album.board.model2.AlbumAction;

import com.exam.album.cmt.model1.CommentDAO;
import com.exam.album.cmt.model1.CommentTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommentWriteOkAction implements AlbumAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "CommentWriteOkAction 호출" );
	}
}
