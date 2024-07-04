<%@page import="java.io.FileInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String filename = request.getParameter("filename");
	String downloadPath = "C:/java/jsp-workspace/AlbumEx10/src/main/webapp/upload/" + filename;
	
	out.clearBuffer();
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));
	FileInputStream fis = new FileInputStream(downloadPath);
	ServletOutputStream sos = response.getOutputStream();
	int data;
	byte readByte[] = new byte[4096];
	while((data = fis.read(readByte, 0, readByte.length)) != -1) {
		sos.write(readByte, 0, data);
	}
	sos.flush();
	sos.close();
	fis.close();
	
%>