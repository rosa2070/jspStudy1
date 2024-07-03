<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<%
	// upload_ok.jsp
	String uploadPath = "C:/java/jsp-workspace/UploadEx10/src/main/webapp/upload";	
	int maxFileSize = 2 * 1024 * 1024;
	String encType = "utf-8";
	
	// apache-tomcat 9 - X
	// apache-tomcat 10 - request(HttpServletRequest)
	MultipartRequest multi 
		= new MultipartRequest( request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
%>