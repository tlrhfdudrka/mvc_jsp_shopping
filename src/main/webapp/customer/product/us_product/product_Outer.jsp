<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/setting.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 목록 - Outer</title>
    <link rel="stylesheet" href="${path}/customer/product/us_product/css/product_Outer.css" />
	<link rel="stylesheet" href="${path}/common/css/header.css" />
	<link rel="stylesheet" href="${path}/common/css/footer.css" />
    <script>
	    function goToProductDetail(pdNum, pageNum) {
	    	
	        window.location = "${path}/product_Outer_detail.uspd?pd_num=" + pdNum + "&pageNum=" + pageNum;
	    }
	</script>
</head>
<body>

	<div class="outer_wrap">	
		<!-- header 시작 -->
		<div class="outer_header">
			<%@include file="/common/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="outer_container">
			<div id="outer_contents">
				<div id="_oter_section">
											
					<!-- 우측메뉴 시작 -->
					<div id="outer_right">
						<div class="outer_table_div">
						<br>
						<h4>Outer</h4>
							<form name="outer" method="post">
								<ul class="outer_list">
									<c:forEach var="dto" items="${list}">
										<c:if test="${dto.category_num == 1}">
										<li>
											<div class="outer_img" onclick="goToProductDetail(${dto.pd_num}, ${paging2.pageNum})">
											  <img src="${dto.pd_img1}" alt="Avatar" class="outer_image">
											  <div class="outer_overlay">
											    <div class="outer_ex">
												    <img src="${dto.pd_img2}" alt="Avatar" class="outer_image"><br>
												    	${dto.pd_name}<br>
												    	${dto.pd_price}
											    </div>
											  </div>
											</div>
										</li>
										</c:if>
									</c:forEach>
								</ul>
								<ul>
									<li id="uspd_outer_page">
										<!-- 페이징 처리 -->
										<!-- 이전 버튼 활성화 -->
										<c:if test="${paging2.startPage > 10}">
											<a href="${path}/product_Outer.uspd?pageNum=${paging2.prev}">◀</a>
										</c:if>
										
										<!-- 페이지 번호 처리 -->
										<c:forEach var="num" begin="${paging2.startPage}" end="${paging2.endPage}">
											<a href="${path}/product_Outer.uspd?pageNum=${num}">${num}</a>
										</c:forEach>
										
										<!-- 다음 버튼 활성화 -->
										<c:if test="${paging2.endPage < paging2.pageCount}">
											<a href="${path}/product_Outer.uspd?pageNum=${paging2.next}">▶</a>
										</c:if>
									</li>
								</ul>
							</form>
						</div>
					</div>
					<!-- 우측메뉴 종료 -->
				</div>				
			</div>		
		</div>
		<!-- 컨텐츠 끝 -->
		
		<!-- footer 시작 -->
		<div class="outer_footer">
			<%@ include file="/common/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>

</body>
</html>