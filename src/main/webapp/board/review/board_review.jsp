<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/header/header.css" />
<link rel="stylesheet" href="${path}/board/review/board_review.css" />
<script>
$(function(){
	// 게시판 목록
	$('#btnInsert').click(function(){
		location.href="${path}/board/review/board_reviewList.jsp";		
	});
});
</script>
</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<div id="header"><%@include file="/header/header.jsp"%></div>
		<!-- header 끝 -->
		<!-- 컨텐츠 시작 -->
		<div class="container">
			<div class="contents">
			
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<p align="center"> Review </p>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 내용 시작 -->
					<div id="right">
						<div class="table_div">
							<form name="ad_productList" method="post"> <!-- 화면에서 입력받은 값을 전송한다. -->
								<table>
									<tr>
										<td class="board-title"> 브라운 코트의 정석 </td>
									</tr>
									<tr>
										<td class="board-date"> 이**** | 24.01.30 </td>
									</tr>
									<tr>
										<td class="top-border" style="width: 100%">
									</tr>
									<tr>
									    <th><img src="이미지.PNG" style="padding-bottom: 40px; padding-top: 10px;"></th>
									</tr>
									<tr>
										<td class="board-date"> 이렇게 찐 브라운코트는 처음이라 어울릴까 반신반의 했는데 넘 예쁜 코디가 자꾸 아른아른거려서 구매했어요. <br>
										색상 진짜 잘 빠졌구요!!! 한겨울에 보온성 포기하고 코트 입어야되는데 이 녀석은 보온성도 좋습니당. <br>
										164기준에 길이감도 적당하고 진짜 자주 손이 가요.. 언제부턴가 믿고 구매하는 위아썸ㅠㅠㅠ🤎 올봄 코디도 기대중입니당~ </td>

									</tr>
									<tr>
										<td> <br><br> </td>
									</tr>
									<tr>
										<td class="board-date"> 첨부파일 </td>
									</tr>
									<tr>
										<td class="top-border" style="width: 100%">
									</tr>
									<tr>
										<td colspan="15" align="center">
											<input type="button" class="write-btn-2" value="수정" id="btnUpdate">
											<input type="button" class="write-btn-2" value="삭제" id="btnDelete">
											<input type="button" class="write-btn" value="목록" id="btnInsert">
										</td>
									</tr>
									<tr>
										<td class="top-border" style="width: 100%">
									</tr>
									<tr>
										<td class="board-title"> 댓글목록 </td>
									</tr>
									<tr>
										<td class="board-date"> (주)위드아웃썸머 | 날짜 </td>
									</tr>
									<tr>
										<td class="board-title"> 안녕하세요 :)<br>

										받아보신 상품 마음에 드셨다니 정말 다행이에요 ! ㅎㅎ <br>
										앞으로도 더 예쁜 상품들 많이 보여드릴 수 있도록 하겠습니다.<br>
										소중한 후기 감사드려요 !<br>
										
										행복한 하루 보내세요 ~!<br>
										 </td>
									</tr>

								</table>
								
								<br><br>
		                        <!-- 댓글 목록 코드 -->
		                        <div id="commentList" align="center"></div>
		                        <br><br>
		                        
		                        <!-- 댓글 입력 코드 -->
		                       <!--  <table align="center" border="1">
		                        	<tr>
										<td class="bottom-top" style="width: 100%">
									</tr>
		                        	<tr>
		                        		<th style="width: 20px"> 댓글내용 </th>
		                        		<td style="width: 250px; text-align: center">
		                        			<textarea rows="2" cols="140" name="content" id="content" placeholder="내용 입력"></textarea> 
										</td>
										<th style="width:40px" rowspan="2" align="right">
											<center><input type="button" class="inputButton" value="작성" id="btnInsert"></center>
										</th>
		                        	</tr>
		                        </table>  -->
							</form>
						</div>
					</div>
					<!-- 내용 종료 -->
				</div>
			</div>
		</div>	
		<!-- 컨텐츠 끝 -->
	</div>

<script src="${path}/header/header.js"></script>
</body>
</html>