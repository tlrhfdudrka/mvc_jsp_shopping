<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/header/header.css" />
<link rel="stylesheet" href="${path}/board/board.css" />
</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<div id="header"><%@include file="/header/header.jsp"%></div>
		<!-- header 끝 -->
		<!-- 컨텐츠 시작 -->
		<div id="container">
			<div id="contents">
			
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
										<td class="top-border"> 제목 </td>
									</tr>
									<tr>
										<td> 이름 | 날짜 </td>
									</tr>
									<tr>
										<th ><img src="./images/image.jpg"></th>
									</tr>
									<tr>
										<td> 글내용 </td>
									</tr>
									<tr>
										<td> <br><br> </td>
									</tr>
									<tr>
										<td> 첨부파일 </td>
									</tr>
									<tr>
										<td colspan="5" align="center">
											<input type="button" class="inputButton" value="목록" id="btnInsert">
										</td>
									</tr>
									<tr>
										<td> 댓글목록 </td>
									</tr>
									<tr>
										<td> <br><br> </td>
									</tr>
									<tr>
										<td> (주)위드아웃썸머 | 날짜 </td>
									</tr>
									<tr>
										<td class="bottom-border"> 내용 </td>
									</tr>
									
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

<script src="${path}/header/header.js"></script>
</body>
</html>