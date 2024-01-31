<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/header/header.css" />
<link rel="stylesheet" href="${path}/footer/footer.css" />
<link rel="stylesheet" href="${path}/order/orderList/orderList.css" />

<script type="text/javascript">
/* 	$(function () {
		
		$("#order-btn").click(function() {
			$.ajax({
				url: '${path}/basic1_next.jq', // 3.
				type: 'GET',
				dataType: 'text', // 요청데이터 형식(thml, xml, json, text)
				success: function(result){	// 6. 콜백함수 - ${path}/basic_next.jq' 가 result에 전달되는것
					$('#display').html(result);
				},
				error: function () {
					alert('오류');
				}
			});
		});
	}); */
</script>

</head>
<body>

	<!-- header 시작 -->
	<div id="header"><%@include file="/header/header.jsp"%></div>
	<!-- header 끝 -->
	<div class="wrap">
		<!-- 컨텐츠 시작 -->
		<div class="container">
			<div class="contents">

				<!-- 상단 중앙1 시작 -->
				<div class="topbtn-section">
					<button id="order-btn">주문내역 조회(1건)</button>
					<button id="cancel-btn">취소/교환/반품 내역(1건)</button>
				</div>

				<div class="select-box">
					<p>상태</p>
					<select value="주문상태" class="time-select">
						<option selected disabled>전체 주문처리상태</option>
						<option value="board">입금전</option>
						<option value="board">배송준비중</option>
						<option value="board">배송중</option>
						<option value="board">배송완료</option>
						<option value="board">취소</option>
						<option value="board">교환</option>
						<option value="board">반품</option>
					</select>
				</div>
				
				<div class="time-box">
					<p>기간</p>
					<input type="button" class="today" value="오늘" id="btnSave">
					<input type="button" class="one-month" value="1개월" id="btnSave">
					<input type="button" class="three-month" value="3개월" id="btnSave">
					<input type="button" class="six-month" value="6개월" id="btnSave">
				</div>
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 내용 시작 -->
					<div id="right">
						<div class="table_div">
							<form name="ad_productList" method="post">
								<!-- 화면에서 입력받은 값을 전송한다. -->
								<table>
									<tr>
										<td colspan="3" id="order-num">2024-01-09 (20240109-0000143)</td>
									</tr>
									<tr>
										<td rowspan="2" id="pdImg"><img src="../../image/orderImg.png"></td>
										<td colspan="2" id="pdName" style="width: 100%">Dear Knit_purple</td>
									</tr>
									<tr>
										<td id="pdPrice" style="width: 10%">108,000원</td>
										<td id="pdQty">1개</td>
									</tr>
									<!-- 게시글이 있으면 -->
									<!-- forEach 태그는 배열, ArrayList, Map에 저장되어 있는 값들을 순차적으로 처리할 때 사용한다. -->
									<c:forEach var="dto" items="${list}">
										<tr>
											<td>${dto.num}</td>
											<td>${dto.writer}</td>
											<td><a
												href="${path}/board_detailAction.bc?num=${dto.num}">${dto.title}</a>
											</td>
											<td>${dto.regDate}</td>
											<td>${dto.readCnt}</td>
										</tr>
									</c:forEach>
									<tr>
										<td id="delivery-status">배송완료</td>
										<td colspan="5" align="center"><input type="button"
											class="write-btn" value="구매후기" id="btnInsert"></td>
									</tr>
								</table>
							</form>


						</div>
						<!-- 내용 종료 -->
					</div>
				</div>
			</div>
			<!-- 컨텐츠 끝 -->
		</div>
	</div>
	<!-- footer 시작 -->
	<div id="footer"><%@include file="/footer/footer.jsp"%></div>
	<!-- footer 끝 -->
	<script src="${path}/header/header.js"></script>
</body>
</html>