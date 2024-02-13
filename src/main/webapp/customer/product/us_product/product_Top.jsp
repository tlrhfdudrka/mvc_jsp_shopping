<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/setting.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 목록 - Top</title>
    <link rel="stylesheet" href="${path}/customer/product/us_product/css/product_Top.css" />
	<link rel="stylesheet" href="${path}/common/css/header.css" />
	<link rel="stylesheet" href="${path}/common/css/footer.css" />
    <script>
	    function goToProductDetail(pdNum, pageNum) {
	    	
	        window.location = "${path}/product_Outer_detail.uspd?pd_num=" + pdNum + "&pageNum=" + pageNum;
	    }
	</script>
</head>
<body>

	<div class="top_wrap">	
		<!-- header 시작 -->
		<div class="top_header">
			<%@include file="/common/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="top_container">
			<div id="top_contents">
				<div id="top_section">
											
					<!-- 우측메뉴 시작 -->
					<div id="top_right">
						<div class="top_table_div">
						<br>
						<h4>Top</h4>
							<form name="top" method="post">
								<ul class="top_list">
									<c:forEach var="dto" items="${list}">
										<c:if test="${dto.category_num == 2}">
										<li>
											<div class="top_img" onclick="goToProductDetail(${dto.pd_num}, ${paging.pageNum})">
											  <img src="${dto.pd_img1}" alt="Avatar" class="top_image">
											  <div class="top_overlay">
											    <div class="top_ex">
											    	${dto.pd_name}<br><br>
											    	${dto.pd_price}
											    </div>
											  </div>
											</div>
										</li>
										</c:if>
									</c:forEach>
								</ul>
							</form>
						</div>
					</div>
					<!-- 우측메뉴 종료 -->
				</div>				
			</div>		
		</div>
		<!-- 컨텐츠 끝 -->
		<div>
			<table>
				<tr>
					<td colspan="8" align="center">
						<!-- 페이징 처리 -->
						<!-- 이전 버튼 활성화 -->
						<c:if test="${paging.startPage > 10}">
							<a href="${path}/product_Top.uspd?pageNum=${paging.prev}">◀</a>
						</c:if>
						
						<!-- 페이지 번호 처리 -->
						<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
							<a href="${path}/product_Top.uspd?pageNum=${num}">${num}</a>
						</c:forEach>
						
						<!-- 다음 버튼 활성화 -->
						<c:if test="${paging.endPage < paging.pageCount}">
							<a href="${path}/product_Top.uspd?pageNum=${paging.next}">▶</a>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
		<!-- footer 시작 -->
		<div class="top_footer">
			<%@ include file="/common/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>

</body>
</html>