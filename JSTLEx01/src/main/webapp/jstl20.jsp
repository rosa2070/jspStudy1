<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>    
    
<s:setDataSource 
	var="ds" 
	url="jdbc:mariadb://localhost:3306/sample" 
	driver="org.mariadb.jdbc.Driver" 
	user="root" 
	password="123456" />
출력 : ${ ds }
<%--<s:update 
	var="result" 
	dataSource="${ ds }"
	sql="insert into dept2 values ( 60, '개발부', '서울')" /> --%>

<s:update var="result" dataSource="${ ds }">
	insert into dept2 values (60, '개발부', '부산')
</s:update>
결과 : ${ result }