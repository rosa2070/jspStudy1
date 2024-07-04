package com.exam.album.board.model2;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.exam.album.board.model1.AlbumDAO;
import com.exam.album.board.model1.AlbumTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AlbumWriteOkAction implements AlbumAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println( "AlbumWriteOkAction 호출" );
		
		int maxFileSize = 1024 * 1024 * 10;
		String encoding = "utf-8";
		
		int flag = 1;
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(request, UPLOAD_PATH, maxFileSize, encoding, new DefaultFileRenamePolicy());
			
			AlbumTO to = new AlbumTO();
			to.setSubject( multi.getParameter( "subject" ) );
			to.setWriter( multi.getParameter( "writer" ) );
			if( !multi.getParameter( "mail1" ).equals( "" ) && !multi.getParameter( "mail2" ).equals( "" ) ) {
				to.setMail( multi.getParameter( "mail1" ) + "@" + multi.getParameter( "mail2" ) );
			}
			to.setPassword( multi.getParameter( "password" ) );
			to.setContent( multi.getParameter( "content" ) );
			
			to.setWip( request.getRemoteAddr() );
			
			to.setImagename( multi.getFilesystemName( "upload" ) );
			File file = multi.getFile( "upload" ); 
			if( file != null ) {
				to.setImagesize( file.length() );
			}
			
			to.setLatitude( multi.getParameter( "latitude" ) );
			to.setLongitude( multi.getParameter( "longitude" ) );
			
			AlbumDAO dao = new AlbumDAO();
			flag = dao.albumWriteOk( to );
			
		} catch( IOException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		}
		
		request.setAttribute( "flag", flag );
	}

}
