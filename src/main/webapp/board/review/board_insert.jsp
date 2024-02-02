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
<link rel="stylesheet" href="${path}/board/review/board_insert.css" />
<script>
	$(function(){ // 작성 페이지가 로딩되면
		
		
		$('#btnInsert').click(function(){
			
			const writer = $("#writer").val();
			const password = $("#password").val();
			const title = $("#title").val();
			const content = $("#content").val();
			
			
			if(writer == ""){
				alert("작성자를 입력하세요!!");
				$("#writer").focus();
				return false;
			}
			if(password == ""){
				alert("비밀번호를 입력하세요!!");
				$("#password").focus();
				return false;
			}
			if(title == ""){
				alert("제목을 입력하세요!!");
				$("#title").focus();
				return false;
			}
			if(content == ""){
				alert("내용을 입력하세요!!");
				$("#content").focus();
				return false;
			}
			
			document.insertForm.action="${path}/board_insertAction.bc";
			document.insertForm.submit();
			
		});
	});
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
				<div id="section1">
					<p align="center">Notice</p>
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
		                              <th style="width: 100px"> 작성자 </th>
		                              <td >
		                                 <input style="width: 200px" type="text" class="input" name="writer"
		                                    id="writer" size="30" placeholder="작성자 입력" required autofocus>
		                              </td>
		                              
		                           </tr>
		                           
		                           <tr>
		                               <th style="width: 100px">글제목</th>
		                               <td colspan="3" style="width: 750px">
		                                  <input style="width: 670px" type="text" class="input" name="title"
		                                    id="title" size="50" placeholder="글제목 입력" required>
		                               </td>
		                           </tr>
		                           
		                           <tr>   
		                               <th style="width: 100px">글내용</th>
		                               <td colspan="3">
		                                  <textarea rows="5" cols="93" name="content" id="content"></textarea>
		                               </td>
		                           </tr>
		                           <tr>
			                            <th>첨부파일</th>
			                            <td colspan="2">
											<input type="file" name="pd_file" id="pd_file" style="width: 100%;" value="파일첨부">
										</td>
			                        </tr>
		                           <tr>
		                           <th style="width: 100px" > 비밀번호 </th>
		                              <td style="width: 200px">
		                                 <input style="width: 200px" type="password" class="input" name="password"
		                                    id="password" size="30" placeholder="비밀번호 입력" required>
		                              </td>
		                           </tr>
									<tr>
										<td colspan="5" align="center">
											<input type="hidden" name="hidden_num" value="${dto.num}">
											<input type="reset" class="write-btn-w" value="초기화">
											<input type="button" class="write-btn" value="글작성" id="btnInsert">
										</td>
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
	<div id="footer"><%@include file="/footer/footer.jsp"%></div>
	<!-- footer 끝 -->
	<script src="${path}/header/header.js"></script>
</body>
</html>