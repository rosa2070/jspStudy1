<%@ page language="java" contentType="text/html; charset=UTF-8"
       pageEncoding="UTF-8"%>

<%@ page import="paging1.BoardDAO"%>
<%@ page import="paging1.BoardTO"%>
<%@ page import="paging1.BoardListTO"%>

<%@ page import="java.util.ArrayList"%>

<%
   request.setCharacterEncoding("utf-8");

   int cpage = 1;// 받아오는 값이 없으면 기본값 1 페이지
   if(request.getParameter("cpage") != null && !request.getParameter("cpage").equals("")) { // cpage값이 있으면 page값을 쓴다
      cpage = Integer.parseInt(request.getParameter("cpage"));
   }

   BoardListTO listTO = new BoardListTO();
   listTO.setCpage(cpage);
   
   BoardDAO dao = new BoardDAO();
   listTO = dao.boardList(listTO);

   // paging
   int totalRecord = listTO.getTotalRecord();
   int totalPage = listTO.getTotalPage();
   
   int blockPerPage = listTO.getBlockPerPage();
   int startBlock = listTO.getStartBlock();
   int endBlock = listTO.getEndBlock();
   
   // 실제 데이터
   ArrayList<BoardTO> boardLists = listTO.getBoardLists();

   StringBuilder sbHtml = new StringBuilder();  

   for(BoardTO to : boardLists){
      String seq = to.getSeq();
      String subject = to.getSubject();
      String writer = to.getWriter();
      String wdate = to.getWdate();
      String hit = to.getHit();
      int wgap = to.getWgap();

      sbHtml.append("<tr>");
      sbHtml.append("<td>&nbsp;</td>");
      sbHtml.append("<td>" + seq +"</td>");
      
      sbHtml.append("<td class='left'>");
      sbHtml.append("<a href='board_view1.jsp?cpage=" + cpage + "&seq=" + seq + "'>" + subject +"</a>&nbsp;");
      if (wgap == 0  ) { // 오늘 나온 글이면 new 사진 붙고
         sbHtml.append("<img src='../../images/icon_new.gif' alt='NEW'></td>");
      }
      sbHtml.append("</td>"); // 아니면 td 닫음
      sbHtml.append("<td>"+ writer +"</td>");
      sbHtml.append("<td>" + wdate + "</td>");
      sbHtml.append("<td>"+ hit + "</td>");
      sbHtml.append("<td>&nbsp;</td>");
      sbHtml.append("</tr>");


   }
  
%>


<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport"
        content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <title>Insert title here</title>
   <link rel="stylesheet" type="text/css" href="../../css/board.css">
</head>

<body>
<!-- 상단 디자인 -->
<div class="con_title">
   <h3>게시판</h3>
   <p>
      HOME &gt; 게시판 &gt; <strong>게시판</strong>
   </p>
</div>
<div class="con_txt">
   <div class="contents_sub">
      <div class="board_top">
         <div class="bold">
            총 <span class="txt_orange"><%=totalRecord%></span>건
         </div>
      </div>

      <!--게시판-->
      <div class="board">
         <table>
            <tr>
               <th width="3%">&nbsp;</th>
               <th width="5%">번호</th>
               <th>제목</th>
               <th width="10%">글쓴이</th>
               <th width="17%">등록일</th>
               <th width="5%">조회</th>
               <th width="3%">&nbsp;</th>
            </tr>
            <%= sbHtml.toString() %>
            <!--                <tr> -->
            <!--                   <td>&nbsp;</td> -->
            <!--                   <td>1</td> -->
            <!--                   <td class="left"><a href="board_view1.jsp">adfas</a>&nbsp;<img -->
            <!--                      src="../../images/icon_new.gif" alt="NEW"></td> -->
            <!--                   <td>asdfa</td> -->
            <!--                   <td>2017-01-31</td> -->
            <!--                   <td>6</td> -->
            <!--                   <td>&nbsp;</td> -->
            <!--                </tr> -->

            <!--                <tr> -->
            <!--                   <td>&nbsp;</td> -->
            <!--                   <td>1</td> -->
            <!--                   <td class="left"><a href="board_view1.jsp">adfas</a>&nbsp;<img -->
            <!--                      src="../../images/icon_new.gif" alt="NEW"></td> -->
            <!--                   <td>asdfa</td> -->
            <!--                   <td>2017-01-31</td> -->
            <!--                   <td>6</td> -->
            <!--                   <td>&nbsp;</td> -->
            <!--                </tr> -->
         </table>
      </div>

      <div class="btn_area">
         <div class="align_right">
            <input type="button" value="쓰기" class="btn_write btn_txt01"
                  style="cursor: pointer;"
                  onclick="location.href='board_write1.jsp?cpage=<%=cpage %>'" />
         </div>


         <!--페이지넘버-->
         <div class="paginate_regular">
            <div align="absmiddle">
               <%
                  if (startBlock == 1) {
                     out.println("<span><a>&lt;&lt;</a></span>");
                  } else {
                     out.println("<span><a href='board_list1.jsp?cpage="+(startBlock - blockPerPage)+"'>&lt;&lt;</a></span>");
                  }
                  out.println("&nbsp;");

                  if (cpage == 1) {
                     out.println("<span><a>&lt;</a></span>");
                  } else {
                     out.println("<span><a href='board_list1.jsp?cpage=" + (cpage - 1) + "'>&lt;</a></span>");
                  }
                  out.println("&nbsp;&nbsp;");

                  for (int i = startBlock; i <= endBlock; i++) {
                     if (i == cpage) {
                        out.println("<span><a>[" + i + "]</a></span>");
                     } else {
                        out.println("<span><a href= 'board_list1.jsp?cpage=" + i + "'>" + i + "</a></span>");
                     }
                  }

                  out.println("&nbsp;&nbsp;");
                  if (cpage == totalPage) {
                     out.println("<span><a>&gt;</a></span>");
                  } else {
                     out.println("<span><a href = 'board_list1.jsp?cpage=" + (cpage + 1) + "'>&gt;</a></span>");
                  }

                  if (endBlock == totalPage) {
                     out.println("<span><a>&gt;&gt;</a></span>");
                  } else {
                     out.println("<span><a href='./board_list1.jsp?cpage=" + ( startBlock + blockPerPage) + "'>&gt;&gt;</a></span>");
                  }

               %>
               &nbsp;&nbsp;
               &nbsp;
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
