<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/common/css/header.css" />
<link rel="stylesheet" href="${path}/common/css/footer.css" />
<link rel="stylesheet" href="css/board_reviewList.css" />
</head>
<body>

	<!-- header 시작 -->
	<div id="header"><%@include file="/common/header.jsp" %></div>
	<!-- header 끝 -->
	<div class="wrap">
		<!-- 컨텐츠 시작 -->
		<div class="container">
			<div class="contents">

				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<p align="center">reviewList</p>
				</div>

				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 내용 시작 -->
					<div id="right">
						<div class="table_div">
							<form name="ad_productList" method="post">
								<!-- 화면에서 입력받은 값을 전송한다. -->
								<table>
									<tr>
									    <td class="top-border bottom-border" rowspan="4" style="width: 120;"><img src="img/이미지.PNG" width="100px"></td>
									    <td class="board-title"> 브라운 코트의 정석 </td>
									</tr>
									<tr>
										<td class="board-date"> 이**** | 24.01.30 </td>
									</tr>
									<tr>
										<td > <br>  </td>
									</tr>
									<tr>
										<td class="bottom-border"> <br>  </td>
									</tr>
									<!-- 게시글이 있으면 -->
									<!-- forEach 태그는 배열, ArrayList, Map에 저장되어 있는 값들을 순차적으로 처리할 때 사용한다. -->
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
										<td colspan="5" align="center"><input type="button"
											class="write-btn" value="글작성" id="btnInsert"></td>
									</tr>
									<tr>
										<td class="paging" colspan="5" align="center">
											<!-- 페이징 처리 --> <!-- 이전 버튼 활성화 --> <c:if
												test="${paging.startPage > 10}">
												<a href="${path}/board_list.bc?pageNum=${paging.prev}">[이전]</a>
											</c:if> <!-- 페이지 번호 처리 --> <c:forEach var="num"
												begin="${paging.startPage}" end="${paging.endPage}">
												<a href="${path}/board_list.bc?pageNum=${num}">${num}</a>
											</c:forEach> <!-- 다음 버튼 활성화 --> <c:if
												test="${paging.endPage < paging.pageCount}">
												<a href="${path}/board_list.bc?pageNum=${paging.next}">[다음]</a>
											</c:if>
										</td>
									</tr>
								</table>
							</form>

							<div class="board-search">
								<div class="select-box">
									<select value="게시판선택" class="time-select">
										<option selected disabled>일주일</option>
										<option value="board">한달</option>
										<option value="board">세달</option>
										<option value="board">전체</option>
									</select>
									<select value="게시판선택" class="title-select">
										<option selected disabled>제목</option>
										<option value="board">내용</option>
										<option value="board">글쓴이</option>
										<option value="board">아이디</option>
										<option value="board">별명</option>
									</select>
								</div>
							<div class="search-wrap">
								<td><input type="search" class="search-box"></td>
								<td><input type="submit" class="search-btn" value="검색"></td>
							</div>	
							</div>
						</div>
					</div>
					<!-- 내용 종료 -->
				</div>
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
	</div>

	<!-- footer 시작 -->
	<div id="footer"><%@ include file="/common/footer.jsp" %></div>
	<!-- footer 끝 -->
	<script src="${path}/common/js/header.js"></script>
</body>
</html>