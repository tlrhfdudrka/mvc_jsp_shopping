<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자 - 게시판목록</title>
<link rel="stylesheet" href="${path}/header/header.css" />
<link rel="stylesheet" href="${path}/header/header.js" />
<link rel="stylesheet" href="${path}/board/notice/notice.css" />

<script>
	$(function() {
		$("#btnInsert").click(function() {
			location.href="${path}/board_insert.bc";
		});
	});
</script>

</head>
<body>

	<div class="notice-wrap">
		<!-- header 시작 -->
		<div id="header"><%@include file="../../header/header.jsp"%></div>
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작(본문) -->
		<div id="container">
			<div id="contents">
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<h2 align="center"> 게시글목록 </h2>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
						
					<!-- 우측메뉴 시작 -->
					<div id="right">
						<div class="table_div">
							<form name="ad_productList" method="post">
								<table>
									<tr>
										<th style="width: 5%"> 글번호 </th>
										<th style="width: 10%"> 작성자 </th>
										<th style="width: 15%"> 글제목 </th>
										<th style="width: 10%"> 작성일 </th>
										<th style="width: 10%"> 조회수 </th>
									</tr>
									
									<!-- 게시글이 있으면 -->
									<c:forEach var="dto" items="${list}">
										<tr>
											<td> ${dto.num} </td>
											<td> ${dto.writer} </td>
											<td>
												<a href="${path}/board_detailAction.bc?num=${dto.num}">${dto.title}</a>
											</td>
											<td> ${dto.regDate} </td>
											<td> ${dto.readCnt} </td>
										</tr>
									</c:forEach>
									
									<tr>
										<td colspan="5" align="center">
											<!-- 페이징 처리 -->
											<!-- 이전 버튼 활성화 -->
											<c:if test="${paging.startPage > 10}">
												<a href="${path}/board_list.bc?pageNum=${paging.prev}">[이전]</a>
											</c:if>
											
											<!-- 페이지 번호 처리 -->
											<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
												<a href="${path}/board_list.bc?pageNum=${num}">${num}</a>
											</c:forEach>
											
											<!-- 다음 버튼 활성화 -->
											<c:if test="${paging.endPage < paging.pageCount}">
												<a href="${path}/board_list.bc?pageNum=${paging.next}">[다음]</a>
											</c:if>
										</td>
									</tr>
									
									<tr>
										<td colspan="5" align="center">
											<input type="button" class="inputButton" value="글쓰기" id="btnInsert">
										</td>
									</tr>
								</table>
							</form>
						</div>					
					</div>
					<!-- 우측메뉴 종료 -->
					
				</div>	
			</div>		
		</div>
		<!-- 컨텐츠 끝 -->
		
		<!-- footer 시작 -->
		<div id="header"><%@include file="../../footer/footer.jsp"%></div>
		<!-- footer 끝 -->
	</div>

</body>
</html>