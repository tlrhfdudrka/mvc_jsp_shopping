<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../setting.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 목록 - Bottom</title>
    <link rel="stylesheet" href="product_Bottom.css" />
    <link rel="stylesheet" href="${path}/header/header.css" />
    <link rel="stylesheet" href="${path}/footer/footer.css" />
    
    <script>
	    $(function() {
	    	
			$(".bottom_img").click(function() {
	    		
	    		window.location="${path}/use_product_detail/product_Bottom_detail.jsp";
	    	});
	    });
    </script>
</head>
<body>

	<div class="bottom_wrap">	
		<!-- header 시작 -->
		<div class="bottom_header">
			<%@include file="/header/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="bottom_container">
			<div id="bottom_contents">
				<div id="bottom_section">
											
					<!-- 우측메뉴 시작 -->
					<div id="bottom_right">
						<div class="bottom_table_div">
						<br>
						<h4>Bottom</h4>
							<form name="bottom" method="post">
								<ul class="bottom_list">
									<li>
										<div class="bottom_img">
										  <img src="img/outer.jpg" alt="Avatar" class="bottom_image">
										  <div class="bottom_overlay">
										    <div class="bottom_ex">
										    	Ivory B Logo Jacquard Silk Blouse<br><br>
										    	35,000
										    </div>
										  </div>
										</div>
									</li>
									<li>
										<div class="bottom_img">
										  <img src="img/top.jpg" alt="Avatar" class="bottom_image">
										  <div class="bottom_overlay">
										    <div class="bottom_ex">
										    	Ivory B Logo Jacquard Silk Blouse<br><br>
										    	35,000
										    </div>
										  </div>
										</div>
									</li>
									<li>
										<div class="bottom_img">
										  <img src="img/bottom.jpg" alt="Avatar" class="bottom_image">
										  <div class="bottom_overlay">
										    <div class="bottom_ex">
										    	Ivory B Logo Jacquard Silk Blouse<br><br>
										    	35,000
										    </div>
										  </div>
										</div>
									</li>
									<li>
										<div class="bottom_img">
										  <img src="img/acc.jpg" alt="Avatar" class="bottom_image">
										  <div class="bottom_overlay">
										    <div class="bottom_ex">
										    	Ivory B Logo Jacquard Silk Blouse<br><br>
										    	35,000
										    </div>
										  </div>
										</div>
									</li>
									<li>
										<div class="bottom_img">
										  <img src="img/outer.jpg" alt="Avatar" class="bottom_image">
										  <div class="bottom_overlay">
										    <div class="bottom_ex">
										    	Ivory B Logo Jacquard Silk Blouse<br><br>
										    	35,000
										    </div>
										  </div>
										</div>
									</li>
									<li>
										<div class="bottom_img">
										  <img src="img/top.jpg" alt="Avatar" class="bottom_image">
										  <div class="bottom_overlay">
										    <div class="bottom_ex">
										    	Ivory B Logo Jacquard Silk Blouse<br><br>
										    	35,000
										    </div>
										  </div>
										</div>
									</li>
									<li>
										<div class="bottom_img">
										  <img src="img/bottom.jpg" alt="Avatar" class="bottom_image">
										  <div class="bottom_overlay">
										    <div class="bottom_ex">
										    	Ivory B Logo Jacquard Silk Blouse<br><br>
										    	35,000
										    </div>
										  </div>
										</div>
									</li>
									<li>
										<div class="bottom_img">
										  <img src="img/acc.jpg" alt="Avatar" class="bottom_image">
										  <div class="bottom_overlay">
										    <div class="bottom_ex">
										    	Ivory B Logo Jacquard Silk Blouse<br><br>
										    	35,000
										    </div>
										  </div>
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
		<div class="bottom_footer">
			<%@ include file= "/footer/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>

</body>
</html>