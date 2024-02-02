<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../setting.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 관리 - 상품 목록</title>
    <link rel="stylesheet" href="product_list.css" />
    <link rel="stylesheet" href="${path}/header/header.css" />
    <link rel="stylesheet" href="${path}/footer/footer.css" />
   
    <script>
	    $(function() {
	    	
			$("#pd_edit_btn").click(function() {
	    		
	    		window.location="product_edit.jsp";
	    	});
			
			$("#pd_delete_btn").click(function() {
	    		
	    		window.location="product_list.jsp";
	    	});
	    });
    </script>
</head>
<body>

	<div class="pd_list_wrap">	
		<!-- header 시작 -->
		<div class="pd_list_header">
			<%@include file="/header/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="pd_list_container">
			<div id="pd_list_contents">
				<div id="pd_list_section">
				
					<!-- 좌측메뉴 시작 -->
					<%@ include file="product_menu.jsp" %>			
					<!-- 좌측메뉴 종료 -->
											
					<!-- 우측메뉴 시작 -->
					<div id="pd_list_right">
						<div id="pd_list_right_section">
							<h4>상품목록</h4>
						</div>
						<form action="#" name="pd_search" id="pd_search" method="post">
							상품 검색 : <input type="text" id="keyword" name="keyword">
		
							<!-- 
								<div id="display">
									결과 출력 위치
								</div> 
							추후 추가 예정
							-->
							
						</form>
						<div class="ad_pd_list_table">
							<form name="ad_pd_list" method="post">
								<table>
									<tr>
										<th>
											<input type="checkbox" name="pd_list_chk" class="pd_list_chk">
										</th>
										<th>번호</th>
										<th>상품명</th>
										<th>상품이미지</th>
										<th>판매가격</th>
										<th>수량</th>
										<th>카테고리</th>
										<th>등록일</th>
										<th>수정 / 삭제</th>
									</tr>
									
									<!-- 상품 클릭 -->
									<tr>
										<td>
											<input type="checkbox" name="pd_list_chk" class="pd_list_chk">
										</td>
										<td>1</td>
										<td>Ivory B Logo Jacquard Silk Blouse</td>
										<td><img src="img/outer.jpg" class="pd_list_img"></td>
										<td>35,000</td>
										<td>50</td>
										<td>Top</td>
										<td>2023-01-01</td>
										<td>
											<input type="button" value="수정" name="pd_list_btn" id="pd_edit_btn">
											<input type="button" value="삭제" name="pd_list_btn" id="pd_delete_btn">
										</td>
									</tr>
									
									<!-- 상품목록 및 페이지 처리 -->
									<%-- <c:forEach var="dto" items="${list}">
									<tr>
										<td> ${dto.num} </td>
										<td> ${dto.writer} </td>
										<td> 
											<a href="${path}/board_detailAction.bc?num=${dto.num}"> ${dto.title} </a> <!-- 조회수관련 -->
											
											<!-- 댓글 개수 -->
											<c:if test="${dto.comment_count > 0}">
												<span style="color:blue">[ ${dto.comment_count} ]</span>
											</c:if> 
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
									</tr> --%>
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
		<div class="pd_list_footer">
			<%@ include file= "/footer/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>

</body>
</html>