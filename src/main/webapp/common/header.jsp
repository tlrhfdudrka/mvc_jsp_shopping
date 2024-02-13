<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/header.css" />
<%-- <link rel="stylesheet" href="${path}/customer/product/us_product/css/product_Outer.css" /> --%>

<title>Insert title here</title>
</head>
<body>

<div class="header-wrap">
	<div class="nav_tab">
	
		<div class="shop">
		<input id="check-btn-shop" type="checkbox" />
		    <label class="menu_shop" for="check-btn-shop">Shop</label>
		      <ul class="menubars-shop">
		          <li><a href="${path}/product_Outer.uspd?category_num=1">Outer</a></li>
		          <li><a href="${path}/product_Top.uspd?category_num=2">Top</a></li>
		          <li><a href="${path}/product_Bottom.uspd?category_num=3">Bottom</a></li>
		      </ul>
		</div>
		
		<div class="community">   
	    <input id="check-btn-cm" type="checkbox" />
		    <label class="menu_cm" for="check-btn-cm">Community</label>
		      <ul class="menubars-cm">
		          <li><a href="${path}/noticeList.nt">Notice</a></li>
		          <li><a href="${path}/customer/board/review/board_reviewList.jsp">Review</a></li>
		      </ul>
		</div>      
		
		<div class="logo"><a href="${path}/common/index.jsp">WITHOUTSUMMER</a></div>      
		
		<div class="account">      
	    <input id="check-btn-ac" type="checkbox" />
		    <label class="menu_ac" for="check-btn-ac">Account</label>
		      <ul class="menubars-ac">
		          <li><a href="${path}/customer/login/login.jsp">Login</a></li>
		          <li><a href="${path}/customer/join/join.jsp">Register</a></li>
		          <li><a href="${path}/customer/order/orderList.jsp">Order</a></li>
		          <li><a href="${path}/customer/join/join.jsp">Mypage</a></li>
		      </ul>
		 </div>
		      
		<div class="bag"><a href="${path}/customer/cart/cartList.jsp">bag</a></div>   
	</div> 
</div>	    
</body>
</html>