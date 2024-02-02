<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../setting.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세페이지 - Bottom</title>
    <link rel="stylesheet" href="product_Bottom_detail.css" />
    <link rel="stylesheet" href="${path}/header/header.css" />
    <link rel="stylesheet" href="${path}/footer/footer.css" />
    
    <script>
	    $(function() {
	    	
			$("#debottom_cart").click(function() {
	    		
	    		window.location="${path}/장바구니";
	    	});
	    });
    </script>
</head>
<body>
	<div class="debottom_wrap">	
		<!-- header 시작 -->
		<div class="debottom_header">
			<%@include file="/header/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="debottom_container">
			<div id="debottom_contents">
				<div id="debottom_section">
					<!-- 우측메뉴 시작 -->
					<div id="debottom_right">
						<div class="debottom_table_div">
						<br>
							<form name="debottom" method="post">
								<ul class="debottom_list">
									<li>
										<div class="debottom_img1">
										  <img src="img/bottom.jpg" alt="Avatar" class="debottom_image">
										</div>
									</li>
									<li>
										<div class="debottom_text1">
										    <div class="debottom_text">
										    	Ivory B Logo Jacquard Silk Blouse<br><br>
										    	35,000<br><br>
										    	<hr><br>
										    	<span>
											    	<input type="button" name="minus" value="-" class="debottom_minus" onclick="count('debottom_minus')">
					                                 <span id="debottom_count" >1</span>
					                                 <input type="button" name="plus" value="+" class="debottom_plus" onclick="count('debottom_plus')">
											    	<span id="debottom_sum">TOTAL: 35,000</span>
												</span>	  
												<br><br>  	
										    	<input type="button" value="ADD TO CART" id="debottom_cart">
										    	<br><br>
											
											    <button class="debottom_main">DETAILS</button>
												<div class="debottom_sub">
												  	상품 설명 들어갈 예정
												</div>
												<button class="debottom_main">SIZE GUIDE</button>
												<div class="debottom_sub">
													(고정)FITTING SIZE : FREE
												</div>
												<button class="debottom_main">SHOPPING</button>
												<div class="debottom_sub">
													(고정)
												  	택배사 : CJ대한통운
	
													- 배송 기간 : 평균 2-5일 소요
													  택배사 상황에 따라 배송 일정 변경 될 수 있습니다.
													
													- 프리오더 주문 제품의 경우 7-14일 소요되며, 입고 지연으로 인한 변동 발생할 수 있습니다.
													
													- 100,000원 이상 무료 배송이며, 100,000원 미만의 경우 배송비 2500원입니다.
													   (도서/산간/제주 지역은 5500원입니다.)
												</div>
												<button class="debottom_main">NOTICE</button>
												<div class="debottom_sub">
													(고정)
												  	교환 및 반품주소
													- 03708 서울특별시 서대문구 연희맛로 2-3 2층 위드아웃썸머
												</div>
										  </div>
										  <hr>
										</div>
									</li>
								</ul>
								<ul class="debottom_list">
									<li>
										<div class="debottom_img2">
										  <img src="img/bottom.jpg" alt="Avatar" class="debottom_image">
										</div>
									</li>
								</ul>
								<ul class="debottom_list">
									<li>
										<div class="debottom_img2">
										  <img src="img/bottom.jpg" alt="Avatar" class="debottom_image">
										</div>
									</li>
								</ul>
								<ul class="debottom_list">
									<li>
										<div class="debottom_img2">
										  <img src="img/bottom.jpg" alt="Avatar" class="debottom_image">
										</div>
									</li>
								</ul>
									
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
									</tr> 
									--%>
															
							</form>
						</div>
					</div>
					<!-- 우측메뉴 종료 -->
				</div>				
			</div>		
		</div>
		<!-- 컨텐츠 끝 -->
		
		<!-- footer 시작 -->
		<div class="debottom_footer">
			<%@ include file= "/footer/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>
	
	<script src="../header/header.js"></script>
	<script src="product_Bottom_detail.js"></script>
</body>
</html>