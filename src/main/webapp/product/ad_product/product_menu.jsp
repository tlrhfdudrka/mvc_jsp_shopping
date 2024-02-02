<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../setting.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 관리 - 상품 메뉴</title>
    <link rel="stylesheet" href="product_menu.css" />
    <link rel="stylesheet" href="${path}/header/header.css" />
</head>
<body>

	<!-- 좌측메뉴 시작 -->
	<div id="pd_menu">
		<div class="pd_menu_inside">
			<!-- 좌측메뉴바 시작 -->
			<ul class="pd_menu_top">
				<li><h4>상품관리</h4></li>
				<li>
					<ul class="pd_menu_bottom">
						<li><a href="product_add.jsp">상품등록</a></li>
						<li><a href="product_list.jsp">상품목록</a></li>
						<li><a href="${path}/logout.do">로그아웃</a></li>	
					</ul>
				</li>	
			</ul>
			<!-- 좌측메뉴바 종료 -->
		</div>
	</div>				
	<!-- 좌측메뉴 종료 -->	

</body>
</html>