<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.exam.mail.MyAuthenticator" %>
<%@ page import="com.exam.mail.MailSender" %>
<%
	//mail.jsp
      
    //받을 사람
    String toEmail = "rosa207061@gmail.com";
    String toName = "테스터";
    
    //제목
    String subject = "테스트 제목";
    
    //내용
    // String content = "<html><head></head><body><font color='red'>테스트 내용</font><br/>테스트 내용</body></html>";
    
    // file / db
    StringBuilder sbHtml = new StringBuilder();
    sbHtml.append("<html>");
    sbHtml.append("<head>");
    sbHtml.append("<meta charset='utf-8' />");
    sbHtml.append("</head>");
    sbHtml.append("<body>");
    sbHtml.append("<font color='blue'>테스트 내용</font><br />테스트 내용");    
    sbHtml.append("<img src='https://img1.daumcdn.net/thumb/S300x300/?scode=b2_01&x-twg-thumb-fname=http%3A%2F%2Ft1.daumcdn.net%2Fb2%2Fcreative%2F599267%2Fcf2ddbb7cfb62c660875eed741d85002.jpg&TWGServiceId=b2&Expires=1720753200&Signature=8fPfu0joPR4M8ssj5dRZCA28wjA%3D' />");
    sbHtml.append("</body>");
    sbHtml.append("</html>");
    
    
    MailSender mailSender = new MailSender();
    mailSender.sendMail(toEmail, toName, subject, sbHtml.toString());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
메일 전송 성공
</body>
</html>