<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/setting.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세페이지 - Outer</title>
    <link rel="stylesheet" href="${path}/customer/product/us_product_detail/css/product_Outer_detail.css" />
	<link rel="stylesheet" href="${path}/common/css/header.css" />
	<link rel="stylesheet" href="${path}/common/css/footer.css" />
	<script>
	    function count(action) {
	        var countElement = document.getElementById("deouter_count");
	        var count = parseInt(countElement.textContent);
	        var priceElement = document.getElementById("deouter_sum");
	        var price = parseInt(priceElement.textContent);
	
	        if (action === "deouter_minus" && count > 1) {
	            count--;
	        } else if (action === "deouter_plus") {
	            count++;
	        }
	
	        countElement.textContent = count;
	        priceElement.textContent = count * parseInt("${dto.pd_price}");
	    } 
	</script>
</head>
<body>
	<div class="deouter_wrap">	
		<!-- header 시작 -->
		<div class="deouter_header">
			<%@include file="/common/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="deouter_container">
			<div id="deouter_contents">
				<div id="deouter_section">
					<!-- 우측메뉴 시작 -->
					<div id="deouter_right">
						<div class="deouter_table_div">
						<br>
							<form name="deouter" method="post">
								<ul class="deouter_list">
									<li>
										<div class="deouter_img1">
										  <img src="${dto.pd_img1}" alt="Avatar" class="deouter_image">
										</div>
									</li>
									<li>
										<div class="deouter_text1">
										    <div class="deouter_text">
										    	${dto.pd_name}<br><br>
										    	${dto.pd_price}<br><br>
										    	<hr><br>
										    	<span>
												   <input type="button" name="minus" value="-" class="deouter_minus" onclick="count('deouter_minus', ${dto.pd_price})">
												   <span id="deouter_count">1</span>
												   <input type="button" name="plus" value="+" class="deouter_plus" onclick="count('deouter_plus', ${dto.pd_price})">
												   <span id="deouter_sum">${dto.pd_price}</span>
												</span>  
												<br><br>  	
										    	<input type="button" value="ADD TO CART" id="deouter_cart">
										    	<br><br>
											
											    <button class="deouter_main">DETAILS</button>
												<div class="deouter_sub">
												  	${dto.pd_content}
												</div>
												<button class="deouter_main">SIZE GUIDE</button>
												<div class="deouter_sub">
													FITTING SIZE : FREE
												</div>
												<button class="deouter_main">SHOPPING</button>
												<div class="deouter_sub">
												  	택배사 : CJ대한통운
	
													- 배송 기간 : 평균 2-5일 소요
													  택배사 상황에 따라 배송 일정 변경 될 수 있습니다.
													
													- 프리오더 주문 제품의 경우 7-14일 소요되며, 입고 지연으로 인한 변동 발생할 수 있습니다.
													
													- 100,000원 이상 무료 배송이며, 100,000원 미만의 경우 배송비 2500원입니다.
													   (도서/산간/제주 지역은 5500원입니다.)
												</div>
												<button class="deouter_main">NOTICE</button>
												<div class="deouter_sub">
												  	교환 및 반품주소
													- 03708 서울특별시 서대문구 연희맛로 2-3 2층 위드아웃썸머
												</div>
										  </div>
										  <hr>
										</div>
									</li>
								</ul>
								<ul class="deouter_list">
									<li>
										<div class="deouter_img2">
										  <img src="${dto.pd_img1}" alt="Avatar" class="deouter_image">
										</div>
									</li>
								</ul>
								<ul class="deouter_list">
									<li>
										<div class="deouter_img2">
										  <img src="${dto.pd_img2}" alt="Avatar" class="deouter_image">
										</div>
									</li>
								</ul>
								<ul class="deouter_list">
									<li>
										<div class="deouter_img2">
										  <img src="${dto.pd_detail_img}" alt="Avatar" class="deouter_image">
										</div>
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
		<div class="deouter_footer">
			<%@ include file="/common/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>
	
	<script src="js/product_Outer_detail.js"></script>
</body>
</html>