<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 상품 중복확인 처리 페이지(bottom)</title>
</head>
<body>
	<c:if test="${selectCnt == 1}">
		<script type="text/javascript">
			if(confirm("이미 장바구니에 담은 상품입니다.\n 장바구니로 이동하시겠습니까?")) {
				window.location="${path}/cartList.ct?user_id=${sessionScope.sessionId}";
			}
			else {
				window.location="${path}/product_Bottom_detail.uspd?pd_num=${pd_num}";
			}
		</script>
	</c:if>
	
	<c:if test="${selectCnt != 1}">
		<script type="text/javascript">
			window.location="${path}/cartAddAction.ct?pd_num=${pd_num}&user_id=${sessionScope.sessionId}";
		</script>
	</c:if>
</body>
</html>