 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<div>
			<h1>게시글</h1>
		</div>
		<br/>
		<table class="table">
			<tr>
				<th style="padding: 13px 0 0 15px">게시판 타입</th>
				<td>
					<div>
						<span/>
					</div>
				</td>
			</tr>
			<tr>
				<th style="padding: 13px 0 0 15px;">생성날짜</th>
				<td><span/>
			</tr>
			<tr>
				<th style="padding: 13px 0 0 15px;">제목</th>
				<td><span/></td>
			</tr>
			<tr>
				<th style="padding: 13px 0 0 15px;">내용</th>
				<td><span> </span></td>
			</tr>
			

			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>
		 <div class="pull-left">
			<a href="/list" class="btn btn-default">목록으로</a>
		</div>
		
		<div class="pull-right">
			
			<button type="button" id="insert">저장</button>
			<button type="button" id="update">수정 및 삭제</button>
			<!-- <button th:if="${member?.id}" type="button" class="btn btn-danger" id="delete">삭제</button> -->
		</div>
		
	</div>
</body>
</html>