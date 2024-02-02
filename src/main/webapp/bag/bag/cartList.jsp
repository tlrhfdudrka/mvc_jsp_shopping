<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니목록</title>
<link rel="stylesheet" href="${path}/header/header.css">
<link rel="stylesheet" href="${path}/footer/footer.css">
<link rel="stylesheet" href="${path}/bag/cartList.css">
<script src="${path}/header/header.js" defer></script>
<script src="${path}/bag/cartList.js" defer></script>
</head>
<body>

	<div class="all_wrap">
		<!-- header 시작 -->
		<%@ include file="/header/header.jsp" %>
		<!-- header 끝 --> 
		 
		<!-- 컨텐츠 시작 -->
		<div class="cart_wrap">
			<div id="cart_container">
				<form name="cartList" method="post">
					<table class="cartList_tb">
						<!-- 장바구니 목록 시작 -->
						<tr class="cartList_detail">
							<!-- 체크박스 -->
	                        <td class="cart_checkbox">
	                        	<input type="checkbox" class="cartchkbox" id="cart_chkbox">
	                        </td>
	                        
	                        <!-- 장바구니에 담은 상품 사진 -->
	                        <td class="cart_pd_photo">
	                        	<img class="pd_img" src="${path}/bag/product1.png">
	                        </td>
	                        
	                        <!-- 상품명 및 간단한 배송정보 및 증가/감소 상품 수량 선택 -->
	                        <td class="cart_pd_name">
	                        	<a href="#" class="cart_pd_name_a">Bell short coat_blue</a>
	                            <p class="cart_pd_name_p">배송 : [무료] / 기본배송</p>
	                            
	                            <!-- 증가/감소 상품 수량 선택 -->
	                            <div class="cart_pdcount_choice">
		                            <input type="button" name="minus" value="-" class="minus" onclick="count('minus')">
	                        		<span id="pd_count">1</span>
	                        		<input type="button" name="plus" value="+" class="plus" onclick="count('plus')">
	                        	</div>
	                        </td>
	                        
	                        <!-- 상품 가격 -->
	                        <td class="cart_pd_price">
	                        	<p class="cart_pd_price_p">246,000원</p>
	                        </td>
	                        
	                        <!-- 빈 열 추가 -->
	                        <td class="cart_pd_option"></td>
	                        
	                        <!-- 삭제 버튼 -->
	                        <td class="cart_pd_delete">
	                        	<input type="button" name="delete_btn" value="삭제" class="delete_btn" onclick="del_confirm()">
	                        </td>
	                    </tr>
	                    <!-- 장바구니 목록 끝 -->
	                    
	                    <!-- 총주문금액 및 주문 버튼 -->
	                    <tr id="totalPrice_order">
	                    	<td colspan="4" id="totalPrice_order_td1"></td>
	                    	<td id="totalPrice_order_td2">
	                    		<p class="totalPrice_order_p"><span class="totalPrice_order_span">PRODUCT</span></p>
	                    		<p class="totalPrice_order_p"><span class="totalPrice_order_span">SHIPPING</span></p>
	                    		<p class="totalPrice_order_p"><span class="totalPrice_order_span">TOTAL</span></p>
	                    		<input type="button" name="select_order" id="select_order_btn" value="SELECT ORDER" onclick="select_ord()">
	                    	</td>
	                    	
	                    	<td id="totalPrice_order_td3">
	                    		<p class="totalPrice_order_p">0원</p>
	                    		<p class="totalPrice_order_p">0원</p>
	                    		<p class="totalPrice_order_p">0원</p>
	                    		<input type="button" name="all_order" id="all_order_btn" value="ALL ORDER" onclick="all_ord()">
	                    	</td>
	                    </tr>
					</table>
				</form>
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
		
		<!-- footer 시작 -->
		<%@ include file="/footer/footer.jsp" %>
		<!-- footer 끝 -->
	</div>
</body>
</html>