<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.exam.album.board.model1.AlbumTO" %>
<%@ page import="com.exam.album.board.model1.AlbumDAO" %>

<%
	request.setCharacterEncoding( "utf-8" );

	AlbumTO to = new AlbumTO();
	
	// board_delte1의 form에서 가져온 request
	to.setSeq( request.getParameter( "seq" ) );
	to.setPassword( request.getParameter( "password" ) );
	
	AlbumDAO dao = new AlbumDAO();
	int flag = dao.albumDeleteOk( to );

	out.println( "<script type='text/javascript'>" );
	if( flag == 0 ) {
		out.println( "alert('글삭제에 성공했습니다.');" );
		out.println( "location.href='board_list1.jsp';" );
	} else if(flag == 1){
		out.println( "alert('비밀번호가 틀립니다.');" );
		out.println( "history.back();" );
	} else {
		out.println( "alert('글삭제에 실패했습니다.');" );
		out.println( "history.back();" );	
	}
	out.println( "</script>" );
%>
