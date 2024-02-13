<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴-인증화면</title>
<!--반응형 웹  -->
<meta name="viewport" content="width=device-width,initial-scale =1">
<link rel="stylesheet" href="${path}/common/css/header.css">
<link rel="stylesheet" href="${path}/common/css/footer.css">
<link rel="stylesheet" href="${path}/customer/login/css/login.css">
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
		        <form name="deleteform" method="post">
		           
		           <c:if test = "${updateCnt == 1}">
		            	<script type="text/javascript">
		            		alert("회원수정 성공");
		            		window.location="common/index.do";
		            	</script>
		            </c:if>
		            
		            <c:if test = "${updateCnt != 1}">
		            	<script type="text/javascript">
		            		alert("회원수정 실패");
		            		window.location="modifyDetailAction.do";
		            	</script>
		            </c:if>
		</form>
	</div>
</div>
		<!--footer  -->
		<%@ include file="/common/footer.jsp" %>
</div>
</body>
</html>