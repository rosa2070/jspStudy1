package com.exam.album.board.model2;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.exam.album.board.model1.AlbumDAO;
import com.exam.album.board.model1.AlbumTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AlbumModifyOkAction implements AlbumAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "AlbumModifyOkAction 호출" );
		
		int maxFileSize = 1024 * 1024 * 10;
		String encoding = "utf-8";

		AlbumTO to = new AlbumTO();
		int flag = 2;
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest( request, UPLOAD_PATH, maxFileSize, encoding, new DefaultFileRenamePolicy() );
			
			to.setSeq( multi.getParameter( "seq" ) );
			to.setSubject( multi.getParameter( "subject" ) );
			if( !multi.getParameter( "mail1" ).equals( "" ) && !multi.getParameter( "mail2" ).equals( "" ) ) {
				to.setMail( multi.getParameter( "mail1" ) + "@" + multi.getParameter( "mail2" ) );
			}
			to.setPassword( multi.getParameter( "password" ) );
			to.setContent( multi.getParameter( "content" ) );
			
			to.setImagename( multi.getFilesystemName( "upload" ) );
			File file = multi.getFile( "upload" ); 
			if( file != null ) {
				to.setImagesize( file.length() );
			}
			to.setLatitude( multi.getParameter( "latitude" ) );
			to.setLongitude( multi.getParameter( "longitude" ) );

			AlbumDAO dao = new AlbumDAO();
			flag = dao.albumModifyOk( to );
			
		} catch( IOException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		}
		
		request.setAttribute( "cpage", multi.getParameter( "cpage" ) );
		request.setAttribute( "seq", to.getSeq() );
		request.setAttribute( "flag", flag );
	}
}
