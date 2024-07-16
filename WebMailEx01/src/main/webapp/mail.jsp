<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.exam.mail.MyAuthenticator" %>
<%@ page import="com.exam.mail.MailSender" %>
<%
    // 받은 데이터 처리
    String toEmail = request.getParameter("toEmail");
    String toName = request.getParameter("toName");
    String subject = request.getParameter("subject");
    String content = request.getParameter("content");

    // 기본 값 설정 (만약 폼에서 값이 제대로 전달되지 않았을 경우)
    if (toEmail == null || toEmail.isEmpty()) {
        toEmail = "rosa207061@gmail.com"; // 기본 이메일 주소
    }
    if (toName == null || toName.isEmpty()) {
        toName = "테스터"; // 기본 받는 사람 이름
    }
    if (subject == null || subject.isEmpty()) {
        subject = "테스트 제목"; // 기본 제목
    }
    if (content == null || content.isEmpty()) {
        // 기본 내용
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
        content = sbHtml.toString();
    }

    MailSender mailSender = new MailSender();
    mailSender.sendMail(toEmail, toName, subject, content);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 전송 결과</title>
</head>
<body>
    <h2>메일 전송 성공</h2>
    <p>받는 사람: <%= toName %> &lt;<%= toEmail %>&gt;</p>
    <p>제목: <%= subject %></p>
    <p>내용:</p>
    <%= content %>
</body>
</html>
