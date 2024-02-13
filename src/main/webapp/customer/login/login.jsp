<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!--반응형 웹  -->
<meta name="viewport" content="width=device-width,initial-scale =1">
<link rel="stylesheet" href="${path}/common/css/header.css">
<link rel="stylesheet" href="${path}/common/css/footer.css">
<link rel="stylesheet" href="${path}/customer/login/css/login.css">
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
		  		<a href="join.do" class="create-account_2">CREATE ACCOUNT</a>
				</div>
		        
		        
		        <c:if test = "${sessionScope.sessionID == null}">
		        <form name ="loginform" action="loginAction.do" method="post" onsubmit="return validateForm()">
		            <div class="int-area">
		                <input type="text" name="user_id" id="id">
		                <label for="id">Account ID</label>
		                <label for="id"  class="right">Forgot id?</label>
		            </div>
		           
		            <div class="int-area">
		                <input type="password" name="user_pwd" id="pw">
		                <label for="pw">Account Password</label>
		                <label for="pw" class="right">Forgot Password?</label>
		            </div>
		           
		            <div class="btn-area">
		                <button id="btn" type="submit" >SIGN IN</button>
		                <button id="btn_2" type="submit" onclick="window.location='../join/join.do'">JOIN US</button>
		            </div>
		        </form>
		         </c:if>
		         <c:if test = "${sessionScope.sessionID != null}">
		         <table>
                    <tr>
                        <td colspan ="2" align="center">
                        <h3>
                            <span style = "color:#FF82AA"><b>${sessionScope.sessionID}</b></span>님
                        </h3>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan = "2" style = "border-bottom:none">
                        <br>
                        <div class="btn-area_2">
                            <input class="btn" type="button" value="회원정보수정" onclick="window.location='modifyCustomer.do'">
                            <input class="btn_1" type="button" value="회원탈퇴" onclick="window.location='deleteCustomer.do'">
                            <input class="btn_2" type="button" value="로그아웃" onclick="window.location='logout.do'">
                        </div>
                     </td>
                   </tr>
                </table>
		         </c:if>
		        
		    </div>
		</div>
		<!--footer  -->
		<%@ include file="/common/footer.jsp" %>
</div>
</body>
</html>