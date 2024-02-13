<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필</title>
<!--반응형 웹  -->
<meta name="viewport" content="width=device-width,initial-scale =1">
<link rel="stylesheet" href="${path}/common/css/header.css" />
<link rel="stylesheet" href="${path}/common/css/footer.css" />
<link rel="stylesheet" href="profile.css">
<script src="profile.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div class="wrap">
			<!--header  -->
			<%@include file="/common/header.jsp" %>
			
			<!--컨텐츠 시작  -->
			 
			<div id="profile-form">
				<div id="contents">
		       <form action="" onsubmit="return validateForm()">
		            <div class="int-area">
		                <input type="text" name="id" id="id" autocomplete="off" required>
		                <label for="id">아이디</label>
		            </div>
		           
		            
		            <div class="int-area">
		                <input type="password" name="pw" id="pw" autocomplete="off" required>
		                <label for="pw">비밀번호</label>
		            </div>
		            <label for="pw" class="pw">-(영문 대소문자/숫자/특수문자 중 2가지 이상 조합,10자~16자)</label>
		           
		            <div class="int-area">
		                <input type="password" name="pw_check" id="pw_check" autocomplete="off" required>
		                <label for="pw_check">비밀번호 확인</label>
		            </div>
		           
		            
		            <div class="int-area">
		                <input type="text" name="name" id="name" autocomplete="off" required>
		                <label for="name">이름</label>
		            </div>
		            
		            <div class="address_area">
		              <label for="zip-code">주소</label>
		              <p>
		                <input type="text" id="zip-code" placeholder="우편번호" />
		                <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"/>
		                <input type="button" onclick="execDaumPostcodeReset()" value="초기화"/>
		              </p>
		
		              <p>
		                <input type="text" id="address-1" placeholder="도로명주소" style="width: 400px" readonly/>
		                <input type="text" id="address-1-1" placeholder="지번주소" style="width: 400px" readonly/>
		              </p>
		
		              <p>
		                <input type="text" id="address-2" placeholder="상세주소" style="width: 400px"/>
		              </p>
		            </div>
		            
		            <div class=int_mobile_area>
					    <input type="text" name="mobile" id="mobile" autocomplete="off" required>
					    <label for="mobile">Mobile</label>
					    <button type="button" class="right" id="verificationButton">인증번호 받기</button>
					</div>
					
		            <div class="int-area">
		                <input type="text" name="email" id="email" autocomplete="off" required>
		                <label for="email">이메일</label>
		            </div>
		            
		            <div class="birth-area">
		                <input type="date" name="birth" id="birth" autocomplete="off" required>
		                <label for="birth">생년월일</label>
		            </div>
		            
		            <div class="btn-area">
		                <input class="btn" type="button" value="회원정보수정" onclick="ok()">
		                <input class="btn_1" type="button" value="회원탈퇴" onclick="no()">
		                <input class="btn_2" type="button" value="취소" onclick="main()">
		            </div>
		 		</form>
		 	</div>
		 </div>
		 	<!--footer  -->
		 	<%@ include file="/common/footer.jsp" %>
	</div>
</body>
</html>