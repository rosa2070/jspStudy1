<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>메일 전송 폼</title>
    <script>
        function validateForm() {
            var toEmail = document.getElementById("toEmail").value;
            var toName = document.getElementById("toName").value;
            var subject = document.getElementById("subject").value;
            var content = document.getElementById("content").value;

            var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(toEmail)) {
                alert("올바른 이메일 주소를 입력하세요.");
                return false;
            }
            if (toName.trim() === "") {
                alert("받는 사람 이름을 입력하세요.");
                return false;
            }
            if (subject.trim() === "") {
                alert("제목을 입력하세요.");
                return false;
            }
            if (content.trim() === "") {
                alert("내용을 입력하세요.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h2>메일 전송 폼</h2>
    <form action="./mail.jsp" method="post" onsubmit="return validateForm()">
        <label for="toEmail">받는 사람 이메일:</label>
        <input type="email" id="toEmail" name="toEmail" required><br><br>

        <label for="toName">받는 사람 이름:</label>
        <input type="text" id="toName" name="toName" required><br><br>

        <label for="subject">제목:</label>
        <input type="text" id="subject" name="subject" required><br><br>

        <label for="content">내용:</label>
        <textarea id="content" name="content" rows="10" cols="30" required></textarea><br><br>

        <input type="submit" value="메일 보내기">
    </form>
</body>
</html>