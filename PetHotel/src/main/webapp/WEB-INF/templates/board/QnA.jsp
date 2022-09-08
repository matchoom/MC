<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String memberId = (String) session.getAttribute("SessionMemberId");
	System.out.print(memberId);	
%>

<div>

   <div>
      <h1>게시글 목록</h1>
   </div>
   <br/>
   <div style="width: 100px; margin: 10px 0;">
      <a href="insert.do">등록</a>
   </div>
   <br/>
   <br/>
   <br/>
   <div id="mainHide">
      <table>
         <thead>
            <tr>
               <th scope="col">글번호</th>
               <th scope="col">서비스 분류</th>
               <th scope="col">제목</th>
               <th scope="col">작성자</th>
               <th scope="col">작성일</th>
            </tr>
         </thead>
         <tbody>
         <c:forEach var="board" items="${boardList}">
         	<tr> 
               <td>${board.boardNo}</td>
               <td>${board.boardType}</td>
               <td>${board.title}</td>
               <td>${board.memberId}</td>
               <td>${board.wdate}</td>
            </tr>
            </c:forEach>
            
         </tbody>
      </table>
   </div>
  </div>
</body>
</html>