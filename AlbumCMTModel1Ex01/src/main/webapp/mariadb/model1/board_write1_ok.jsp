<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.exam.album.board.model1.AlbumTO" %>    
<%@ page import="com.exam.album.board.model1.AlbumDAO" %>

<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<%@ page import="java.io.File" %>

<%
	String uploadPath = "C:/Java/jsp-workspace/AlbumCMTModel1Ex01/src/main/webapp/upload";
	int maxFileSize = 10 * 1024 * 1024;
	String encoding = "utf-8";
	
	MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, encoding, new DefaultFileRenamePolicy());
	
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
	int flag = dao.albumWriteOk( to );
		
	out.println("<script type='text/javascript'>");
	if(flag == 0) {
		out.println( "alert('글쓰기에 성공했습니다.');" );
		out.println( "location.href='board_list1.jsp';" );
	} else {
		out.println( "alert('글쓰기에 실패했습니다.');" );
		out.println( "history.back();");
	}
	out.println( "</script>" );
%>