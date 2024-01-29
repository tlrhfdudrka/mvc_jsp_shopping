<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/header/header.css" />
<link rel="stylesheet" href="${path}/board/board.css" />
</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<div id="header"><%@include file="/header/header.jsp"%></div>
		<!-- header 끝 -->
		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
			
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<p align="center"> 공지 </p>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 내용 시작 -->
					<div id="right">
						<div class="table_div">
							<form name="ad_productList" method="post"> <!-- 화면에서 입력받은 값을 전송한다. -->
								<table>
									<tr>
										<td class="top-border" style="width: 100%"> 제목 </td>
									</tr>
									
									<tr>
										<td  class="bottom-border"> (주)위드아웃썸머 | 등록일 | 조회수 </td>
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
							
						   <select value="게시판선택">
		                    <option selected disabled>일주일</option>
		                    <option value="board">한달</option>
		                    <option value="board">세달</option>
		                    <option value="board">전체</option>
		                  </select>
		                  
		                  <select value="게시판선택">
		                    <option selected disabled>제목</option>
		                    <option value="board">내용</option>
		                    <option value="board">글쓴이</option>
		                    <option value="board">아이디</option>
		                    <option value="board">별명</option>
		                  </select>
		                 
		       
						<td><input type="search"></td>
						<td><input type="submit" value="검색"></td>
								
						</div>
					</div>
					<!-- 내용 종료 -->
				</div>
			</div>
		</div>	
		<!-- 컨텐츠 끝 -->
	</div>

<script src="${path}/header/header.js"></script>
</body>
</html>