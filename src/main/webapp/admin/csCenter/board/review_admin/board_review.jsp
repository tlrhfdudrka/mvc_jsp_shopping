<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/common/css/header.css" />
<link rel="stylesheet" href="${path}/common/css/footer.css" />
<link rel="stylesheet" href="css/board_review.css" />
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
										<td class="board-title"> 제목 </td>
									</tr>
									<tr>
										<td class="board-date"> 이름 | 날짜 </td>
									</tr>
									<tr>
										<td class="top-border" style="width: 100%">
									</tr>
									<tr>
									    <th><img src="img/이미지.PNG" style="padding-bottom: 40px; padding-top: 10px;"></th>
									</tr>
									<tr>
										<td class="board-date"> 글내용 </td>
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
										<td colspan="5" align="center">
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
									<tr>
		                              <td colspan="4" align="right">
		                              	<%--  <input type="hidden" name="hidden_num" value="${dto.num}"> --%>
		                                 <input type="button" class="inputButton" value="수정" id="btnEdit">
		                                 <input type="button" class="inputButton" value="삭제" id="btnDelete">
		                              </td>
                           </tr>
								</table>
								
								
		                        <!-- 댓글 목록 코드 -->
		                        <div id="commentList" align="center"></div>
		                        <br><br>
		                        
		                        <!-- 댓글 입력 코드 -->
		                        <table align="center">
		                        	<tr>
										<td class="bottom-top" style="width: 100%">
									</tr>
		                        	<tr>
		                        		<td class="board-title" style="width: 20px"> 댓글내용 </th>
		                        		<td style="width: 250px; text-align: center">
		                        			<textarea rows="2" cols="140" name="content" id="content" placeholder="내용 입력"></textarea> 
										</td>
										<th style="width:40px" rowspan="2" align="right">
											<center><input type="button" class="inputButton" value="작성" id="btnInsert"></center>
										</th>
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

	<!-- footer 시작 -->
	<div id="footer"><%@ include file="/common/footer.jsp" %></div>
	<!-- footer 끝 -->
</body>
</html>