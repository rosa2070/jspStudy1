<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<%
	request.setCharacterEncoding("utf-8");

	int cpage = 1;
	
	if (request.getParameter("cpage") != null && !request.getParameter("cpage").equals("")) {
		cpage = Integer.parseInt(request.getParameter("cpage"));
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 한페이지당 보여줄 게시글 수
	int recordPerPage = 10;
	int totalPage = 1;
	int totalRecord = 0;
	int blockPerPage = 5;
	
	StringBuilder sbHtml = new StringBuilder();
	
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		// context.xml의 Resource name과 같음
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb2");
		
		conn = dataSource.getConnection();
		
		String sql = "select seq, subject, cmdcnt, writer, imagename, imagesize, date_format(wdate, '%Y.%m.%d') wdate, hit, datediff(now(), wdate) wgap from album_cmt_board1 order by seq desc";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		rs.last();
		totalRecord = rs.getRow();
		rs.beforeFirst();
		
		// 읽을 위치 지정
		int skip = (cpage - 1) * recordPerPage;
		// 읽을 위치로 커서 이동
		if (skip != 0) rs.absolute(skip);
		
		totalPage = ((totalRecord - 1) / recordPerPage) + 1;
		
		while (rs.next()) {
			String seq = rs.getString("seq");
			String subject = rs.getString("subject");
			if(subject.length() >= 10) {
				subject = subject.substring(0, 11) + "...";
			}
			int cmdcnt = rs.getInt("cmdcnt");
			String writer = rs.getString("writer");
			String imagename = rs.getString("imagename");
			long imagesize = rs.getLong("imagesize");
			String wdate = rs.getString("wdate");
			String hit = rs.getString("hit");
			int wgap = rs.getInt("wgap");
			
			sbHtml.append("<tr>");
			sbHtml.append( "	<td class='last2'>" );
			sbHtml.append( "		<div class='board'>" );
			sbHtml.append( "			<table class='boardT'>" );
			sbHtml.append( "			<tr>" );
			sbHtml.append( "				<td class='boardThumbWrap'>" );
			sbHtml.append( "					<div class='boardThumb'>" );
			sbHtml.append( "						<a href='board_view1.jsp?cpage=" + cpage + "&seq=" + seq + "'><img src='../../upload/" + imagename + "' border='0' width='100%' /></a>" );
			sbHtml.append( "					</div>" );
			sbHtml.append( "				</td>" );
			sbHtml.append( "			</tr>" );
			sbHtml.append( "			<tr>" );
			sbHtml.append( "				<td>" );
			sbHtml.append( "					<div class='boardItem'>" );	
			sbHtml.append( "						<strong>" + subject +"</strong>" );
			if( wgap == 0 ) {
				sbHtml.append( "					<img src='../../images/icon_new.gif' alt='NEW'>") ;
			}
			sbHtml.append( "					</div>" );
			sbHtml.append( "				</td>" );
			sbHtml.append( "			</tr>" );
			sbHtml.append( "			<tr>" );
			sbHtml.append( "				<td><div class='boardItem'><span class='bold_blue'>" + writer + "</span></div></td>" );
			sbHtml.append( "			</tr>" );
			sbHtml.append( "			<tr>" );
			sbHtml.append( "				<td><div class='boardItem'>" + wdate + " <font>|</font> Hit " + hit + "</div></td>" );
			sbHtml.append( "			</tr>") ;
			sbHtml.append( "		</table>" );
			sbHtml.append( "	</div>" );
			sbHtml.append( "</td>" );
			sbHtml.append("</tr>");
		} 
	} catch (NamingException e) {
		System.out.println( "[에러] : " + e.getMessage() );
	} catch (SQLException e) {
		System.out.println( "[에러] : " + e.getMessage() );
	} finally {
		if ( rs != null ) rs.close();
		if ( pstmt != null ) pstmt.close();
		if ( conn != null) conn.close();
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/board_list.css">
<style type="text/css">
<!--
	.board_pagetab { text-align: center; }
	.board_pagetab a { text-decoration: none; font: 12px verdana; color: #000; padding: 0 3px 0 3px; }
	.board_pagetab a:hover { text-decoration: underline; background-color:#f2f2f2; }
	.on a { font-weight: bold; }
-->
</style>
</head>

<body>
<!-- 상단 디자인 -->
<div class="contents1"> 
	<div class="con_title"> 
		<p style="margin: 0px; text-align: right">
			<img style="vertical-align: middle" alt="" src="../../images/home_icon.gif" /> &gt; 커뮤니티 &gt; <strong>여행지리뷰</strong>
		</p>
	</div> 
	<div class="contents_sub">	
		<div class="board_top">
			<div class="bold">
				<p>총 <span class="txt_orange">1</span>건</p>
			</div>
		</div>	
		
		<!--게시판-->
		<table class="board_list">
		<tr>
			<td width="20%" class="last2">
				<div class="board">
					<table class="boardT">
					<tr>
						<td class='boardThumbWrap'>
							<div class='boardThumb'>
								<a href="board_view1.jsp"><img src="../../upload/607927_1_thumb1.jpg" border="0" width="100%" /></a>
							</div>																		
						</td>
					</tr>
					<tr>
						<td>
							<div class='boardItem'>	
								<strong>제주 올레길 좋아...</strong>
								<span class="coment_number"><img src="../../images/icon_comment.png" alt="commnet">2</span>
								<img src="../../images/icon_new.gif" alt="NEW">
							</div>
						</td>
					</tr>
					<tr>
						<td><div class='boardItem'><span class="bold_blue">여행자</span></div></td>
					</tr>
					<tr>
						<td><div class='boardItem'>2016.03.02 <font>|</font> Hit 329</div></td>
					</tr>
					</table>
				</div>
			</td>

			<td width="20%" class="last2">
				<div class="board">
					<table class="boardT">
					<tr>
						<td class='boardThumbWrap'>
							<div class='boardThumb'>
								<a href="board_view1.jsp"><img src="../../upload/607927_1_thumb1.jpg" border="0" width="100%" /></a>
							</div>																		
						</td>
					</tr>
					<tr>
						<td>
							<div class='boardItem'>	
								<strong>제주 올레길 좋아...</strong>
								<span class="coment_number"><img src="../../images/icon_comment.png" alt="commnet">2</span>
								<img src="../../images/icon_new.gif" alt="NEW">
							</div>
						</td>
					</tr>
					<tr>
						<td><div class='boardItem'><span class="bold_blue">여행자</span></div></td>
					</tr>
					<tr>
						<td><div class='boardItem'>2016.03.02 <font>|</font> Hit 329</div></td>
					</tr>
					</table>
				</div>
			</td>
			<td width="20%" class="last2">
				<div class="board">
					<table class="boardT">
					<tr>
						<td class='boardThumbWrap'>
							<div class='boardThumb'>
								<a href="board_view1.jsp"><img src="../../upload/607927_1_thumb1.jpg" border="0" width="100%" /></a>
							</div>																		
						</td>
					</tr>
					<tr>
						<td>
							<div class='boardItem'>	
								<strong>제주 올레길 좋아...</strong>
								<span class="coment_number"><img src="../../images/icon_comment.png" alt="commnet">2</span> 
								<img src="../../images/icon_new.gif" alt="NEW">
							</div>
						</td>
					</tr>
					<tr>
						<td><div class='boardItem'><span class="bold_blue">여행자</span></div></td>
					</tr>
					<tr>
						<td><div class='boardItem'>2016.03.02 <font>|</font> Hit 329</div></td>
					</tr>
					</table>
				</div>
			</td>
			<td width="20%" class="last2">
				<div class="board">
					<table class="boardT">
					<tr>
						<td class='boardThumbWrap'>
							<div class='boardThumb'>
								<a href="board_view1.jsp"><img src="../../upload/607927_1_thumb1.jpg" border="0" width="100%" /></a>
							</div>																		
						</td>
					</tr>
					<tr>
						<td>
							<div class='boardItem'>	
								<strong>제주 올레길 좋아...</strong>
								<span class="coment_number"><img src="../../images/icon_comment.png" alt="commnet">2</span> 
								<img src="../../images/icon_new.gif" alt="NEW">
							</div>
						</td>
					</tr>
					<tr>
						<td><div class='boardItem'><span class="bold_blue">여행자</span></div></td>
					</tr>
					<tr>
						<td><div class='boardItem'>2016.03.02 <font>|</font> Hit 329</div></td>
					</tr>
					</table>
				</div>
			</td>
			<td width="20%" class="last2">
				<div class="board">
					<table class="boardT">
					<tr>
						<td class='boardThumbWrap'>
							<div class='boardThumb'>
								<a href="board_view1.jsp"><img src="../../upload/607927_1_thumb1.jpg" border="0" width="100%" /></a>
							</div>																		
						</td>
					</tr>
					<tr>
						<td>
							<div class='boardItem'>	
								<strong>제주 올레길 좋아...</strong>
								<span class="coment_number"><img src="../../images/icon_comment.png" alt="commnet">2</span>
								<img src="../../images/icon_new.gif" alt="NEW">
							</div>
						</td>
					</tr>
					<tr>
						<td><div class='boardItem'><span class="bold_blue">여행자</span></div></td>
					</tr>
					<tr>
						<td><div class='boardItem'>2016.03.02 <font>|</font> Hit 329</div></td>
					</tr>
					</table>
				</div>
			</td>
		</tr>
		</table>
	
		<div class="btn_area">
			<div class="align_right">		
				<input type="button" value="쓰기" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='board_write1.jsp'" />
			</div>
		
			<!--페이지넘버-->
			<div class="paginate_regular">
				<div class="board_pagetab">
					<span class="off"><a href="#">&lt;&lt;</a>&nbsp;&nbsp;</span>
					<span class="off"><a href="#">&lt;</a>&nbsp;&nbsp;</span>
					<span class="off"><a href="#">[ 1 ]</a></span>
					<span class="on"><a href="#">[ 2 ]</a></span>
					<span class="off"><a href="#">[ 3 ]</a></span>
					<span class="off">&nbsp;&nbsp;<a href="#">&gt;</a></span>
					<span class="off">&nbsp;&nbsp;<a href="#">&gt;&gt;</a></span>
				</div>
			</div>
			<!--//페이지넘버-->
		</div>
		<!--//게시판-->	
  	</div>
</div>
<!--//하단 디자인 -->

</body>
</html>
