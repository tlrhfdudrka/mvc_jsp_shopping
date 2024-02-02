<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${path}/header/header.css" />
<link rel="stylesheet" href="${path}/header/header.js" />
<title>header</title>
</head>
<body>

	 <div class="dropdown_main">
	<div class="wrap-menu">
	    <!-- 드롭다운 메뉴바 -->
	    <div class="dropdown_bar1" onclick="changeFontColor1()">Shop</div>
	
	    <!-- 드롭다운 시 보여질 태그 -->
	    <div class="dropdown_content1">
	        <div><a href="#">New</a></div>
	        <div><a href="#">Outer</a></div>
	        <div><a href="#">Top</a></div>
	        <div><a href="#">Bottom</a></div>
	    </div>
	    
	    <!-- 드롭다운 메뉴바 -->
	    <div class="dropdown_bar2" onclick="changeFontColor2()">Community</div>
	    
	    <!-- 드롭다운 시 보여질 태그 -->
	    <div class="dropdown_content2">
	        <div><a href="${path}/board/notice/noticeList.jsp">Notice</a></div>
	        <div><a href="#">Q&A</a></div>
	        <div><a href="#">Review</a></div>
	    </div>
	    
	    <div class="logo">WITHOUTSUMMER</div>
	    
	    <!-- 드롭다운 메뉴바 -->
	    <div class="dropdown_bar3" onclick="changeFontColor3()">Account</div>
	
	    <!-- 드롭다운 시 보여질 태그 -->
	    <div class="dropdown_content3">
	        <div><a href="#">Login</a></div>
	        <div><a href="#">Register</a></div>
	        <div><a href="#">Order</a></div>
	        <div><a href="#">Mypage</a></div>
	    </div>
	    
	    <div class="dropdown_bar4">Bag</div>
	    </div>
	</div> 
	
	
	<input id="check-btn" type="checkbox" />
    <label for="check-btn">Shop</label>
      <ul class="menubars">
          <li><a href="#">New</a></li>
          <li><a href="#">Outer</a></li>
          <li><a href="#">Top</a></li>
          <li><a href="#">Bottom</a></li>
          <li><a href="#">Acc</a></li>
      </ul>  
	
<script src="${path}/header/header.js"></script>	
</body>
</html>