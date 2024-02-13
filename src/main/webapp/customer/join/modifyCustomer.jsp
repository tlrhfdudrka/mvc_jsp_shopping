<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정인증-화면</title>
<!--반응형 웹  -->
<meta name="viewport" content="width=device-width,initial-scale =1">
<link rel="stylesheet" href="${path}/common/css/header.css">
<link rel="stylesheet" href="${path}/common/css/footer.css">
<link rel="stylesheet" href="${path}/customer/login/css/loginAction.css">
<script src="${path}/customer/login/js/login.js"></script>

</head>
<body>
	<div class="wrap">
			<!--header  -->
			<%@ include file="/common/header.jsp" %>
			
			<!--컨텐츠 시작  -->
			
			<div id="login-form">
				<div id="contents">
				<div class="caption">
		  		<a href="" class="create-account">SIGN IN</a>
		  		<a href="${path}/join/join.jsp" class="create-account_2">CREATE ACCOUNT</a>
				</div>
		        
		        
		        <form name="loginform" action="modifyDetailAction.do" method="post">
		           
		           
		           <span style="color:black"><b>${sessionID}</b></span>님 비밀번호를 입력하세요
		            <div class="int-area">
		                <input type="password" name="user_pwd" id="pw">
		                <label for="pw">Account Password</label>
		            </div>
		            
		           
		            <div class="btn-area">
		                <button id="button" type="submit" >회원수정</button>
		                <button id="button_2" type="reset" onclick="main()">수정취소</button>
		            </div>
		</form>
	</div>
</div>
		<!--footer  -->
		<%@ include file="/common/footer.jsp" %>
</div>



</body>
</html>