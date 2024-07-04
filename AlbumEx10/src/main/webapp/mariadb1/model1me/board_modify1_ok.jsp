<%@page import="com.exam.album.board.model1.AlbumDAO"%>
<%@page import="com.exam.album.board.model1.AlbumTO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String uploadPath = "C:/java/jsp-workspace/AlbumEx10/src/main/webapp/upload";
	int maxFileSize = 10 * 1024 * 1024;
	String encoding = "utf-8";
	
	MultipartRequest multi = new MultipartRequest( request, uploadPath, maxFileSize, encoding, new DefaultFileRenamePolicy());
	
	AlbumTO to = new AlbumTO();
	to.setSeq(multi.getParameter("seq"));
	to.setSubject(multi.getParameter("subject"));
	if (!multi.getParameter("mail1").equals("") && !multi.getParameter("mail2").equals("")) {
		to.setMail(multi.getParameter("mail1") + "@" + multi.getParameter("mail2"));
	}
	to.setPassword(multi.getParameter("password"));
	to.setContent(multi.getParameter("content"));
	
	to.setImagename(multi.getFilesystemName("upload"));
	if ( multi.getFile("upload") != null) {
		to.setImagesize(multi.getFile("upload").length());
	}
	to.setLatitude(multi.getParameter("latitude"));
	to.setLongitude(multi.getParameter("longitude"));
	
	String cpage = multi.getParameter("cpage");
	String seq = multi.getParameter("seq");
	
	AlbumDAO dao = new AlbumDAO();
	int flag = dao
	
%>