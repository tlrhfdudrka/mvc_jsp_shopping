<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입후</title>C
<!--반응형 웹  -->
<meta name="viewport" content="width=device-width,initial-scale =1">
<link rel="stylesheet" href="${path}/common/css/header.css" />
<link rel="stylesheet" href="${path}/common/css/footer.css" />
<link rel="stylesheet" href="css/creat.css">
<script src="${path}/creat/creat.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>

   <div class="wrap">
   <!--header 시작  -->
   <%@include file="/common/header.jsp" %>
   <!--header 끝  -->
   
   <!--컨텐츠 시작  -->
   <div id="container">
        <!--상단 중앙1 시작  -->
        <div id="title">
           <label for="create-account">CREAT ACCOUNT!</label>
        </div>
         <label for="create-account" class="sub_title">[일반회원]</label>
	         
	         <div class="join_ok">
	            <form name="join_ok_form" action="joinAction.do" method="post" onsubmit="return signInCheck()">
	                  <tr>
	                     <th>아이디</th>
	                     <td>
	                        <input type="text" class="input" name="userid" size="20">
	                     </td>
	                  </tr>
	                  
	                  <tr>
	                     <th>이름</th>
	                     <td>
	                        <input type="text" class="input" name="username" size="20" >
	                     </td>
	                  </tr>
	                  
	                  <tr>
	                     <th>이메일</th>
	                     <td>
	                        <input type="text" class="input" name="username" size="20" >
	                     </td>
	                  </tr>
	                  
	                  <tr>
	                  <div class="btn-area">
				           <input class="btn" type="button" value="LOGIN" onclick="login()">
				           <input class="btn_2" type="button" value="HOME" onclick="main()">
				      </div>
                     </tr>
            </form>
         </div>
   <!--컨텐츠 끝  -->
   <!--footer 시작  -->
   <%@ include file="/common/footer.jsp" %>
   <!--footer 끝  -->
   </div>
 </div>

</body>
</html>>