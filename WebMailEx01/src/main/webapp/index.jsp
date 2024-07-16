<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>메일 전송 폼</title>
    <script type="text/javascript">
    	window.onload = function() {
    		document.getElementById('mbtn').onclick = function() {
    			if (document.mfrm.toEmail.value.trim() == "") {
    				alert('받을 주소를 입력하세요.');
    				return false;
    			}
    			
    			if (document.mfrm.toName.value.trim() == "") {
    				alert('받는 사람 이름을 입력하세요.');
    				return false;
    			}
    			
    			if (document.mfrm.subject.value.trim() == "") {
    				alert('제목을 입력하세요.');
    				return false;
    			}
    			
    			if (document.mfrm.content.value.trim() == "") {
    				alert('내용을 입력하세요.');
    				return false;
    			}
    			
    			document.mfrm.submit();
    		}
    	}
        
    </script>
</head>
<body>
    <h2>메일 전송 폼</h2>
    <form action="./mail.jsp" method="post" name="mfrm" >
        <label for="toEmail">받을 주소:</label>
        <input type="email" id="toEmail" name="toEmail" required><br><br>

        <label for="toName">받는 사람 이름:</label>
        <input type="text" id="toName" name="toName" required><br><br>

        <label for="subject">제목:</label>
        <input type="text" id="subject" name="subject" required><br><br>

        <label for="content">내용:</label>
        <textarea id="content" name="content" rows="10" cols="30" required></textarea><br><br>

        <input type="submit" id="mbtn" value="메일 보내기">
    </form>
</body>
</html>