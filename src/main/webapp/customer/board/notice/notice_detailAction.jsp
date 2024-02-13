<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice - 상세페이지</title>
<link rel="stylesheet" href="${path}/common/css/header.css" />
<link rel="stylesheet" href="${path}/common/css/footer.css" />
<link rel="stylesheet" href="${path}/customer/board/notice/css/notice_detailAction.css" />

<script>
	$(function() {	// 상세페이지가 로딩되면
		
		// 게시판 목록
		$('#btnList').click(function() {
			location.href="${path}/ad_noticeList.nt";
		});
	});
	
</script>

</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<div id="header"><%@include file="/common/header.jsp" %></div>
		<!-- header 끝 -->
		<!-- 컨텐츠 시작 -->
		<div class="container">
			<div class="contents">
			
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<p align="center"> Notice </p>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 내용 시작 -->
					<div id="right">
						<div class="table_div">
							<form name="notice_detailForm" method="post"> <!-- 화면에서 입력받은 값을 전송한다. -->
								<table>
									<tr>
										<td class="notice-title"> ${dto.notice_title} </td>
									</tr>
									<tr>
										<td class="notice-info"> ${dto.user_id} | ${dto.notice_date} | 조회수 ${dto.notice_readCnt} </td>
									</tr>
									<tr>
										<td class="top-border" style="width: 100%">
									</tr>
									<tr>
										<td class="notice_content">${dto.notice_content}</td>
									</tr>
									<tr>
										<td> <br><br> </td>
									</tr>
									<tr>
										<td class="top-border" style="width: 100%">
									</tr>
									<tr>
										<td colspan="5">
											<input type="hidden" name="notice_num" value="${dto.notice_num}">
											<input type="button" class="write-btn" value="목록" id="btnList">
										</td>
									</tr>
									<tr>
										<td class="top-border" style="width: 100%">
									</tr>
									<!-- <tr>
										<td class="next-content" style="width: 100%">다음글</td>
										<td class="next-content" style="width: 100%">다음글</td>
									</tr> -->
								</table>
							</form>
						</div>
					</div>
					<!-- 내용 종료 -->
				</div>
			</div>
		</div>	
		<!-- 컨텐츠 끝 -->
	</div>
	<!-- footer 시작 -->
	<div id="footer"><%@ include file="/common/footer.jsp" %></div>
	<!-- footer 끝 -->
</body>
</html>