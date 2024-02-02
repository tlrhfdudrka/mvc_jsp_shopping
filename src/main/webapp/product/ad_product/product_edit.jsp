<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../setting.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 관리 - 상품 수정</title>
    <link rel="stylesheet" href="product_edit.css" />
    <link rel="stylesheet" href="${path}/header/header.css" />
    <link rel="stylesheet" href="${path}/footer/footer.css" />
    
    <script>
	    $(function() {
	    	
			$("#pd_reEdit_btn").click(function() {
	    		
	    		window.location="product_list.jsp";
	    	});
	    });
    </script>
</head>
<body>

	<div class="pd_edit_wrap">	
		<!-- header 시작 -->
		<div class="pd_edit_header">
			<%@include file="/header/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="pd_edit_container">
			<div id="pd_edit_contents">
				<div id="pd_edit_section">
				
					<!-- 좌측메뉴 시작 -->
					<%@ include file="product_menu.jsp" %>			
					<!-- 좌측메뉴 종료 -->
					
					<!-- 우측메뉴 시작 -->
					<div id="pd_edit_right">
						<div id="pd_edit_right_section">
							<h4>상품수정</h4>
						</div>
						<div class="pd_edit_table_div">
							<form action="#" name="ad_pd_edit" method="post">
			                    <table>  
			                    	<tr>
			                            <th>상품번호</th>
			                            <td>
			                                1
			                            </td>
			                        </tr>                      
			                        <tr>
			                            <th>상품명</th>
			                            <td>
			                                <input type="text" name="pd_edit_name" id="pd_edit_name" autofocus required>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>상품이미지</th>
			                            <td colspan="2">
											<input type="file" name="pd_edit_file" id="pd_edit_file" value="파일첨부">
										</td>
			                        </tr>
			                        <tr>
			                            <th>상품상세이미지</th>
			                            <td colspan="2">
											<input type="file" name="pd_edit_defile" id="pd_edit_defile" value="파일첨부">
										</td>
			                        </tr>
			                        <tr>
			                            <th>판매가격</th>
			                            <td>
			                                <input type="text" name="pd_edit_price" id="pd_edit_price" required>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>수량</th>
			                            <td>
			                                <input type="text" name="pd_edit_cnt" id="pd_edit_cnt" required>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>카테고리</th>
			                            <td>
			                                <select id="pd_edit_category">
												<option value="category" selected>카테고리 선택</option>
												<option value="Top">Top</option>
												<option value="Bottom">Bottom</option>
												<option value="Acc">Acc</option>
											</select>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>설명</th>
			                            <td colspan="2">
											<textarea rows="8" cols="70" name="pd_edit_ex" id="pd_edit_ex"></textarea>
										</td>
			                        </tr>
			                        <tr>
			                            <td colspan="2">
			                                <input type="button" value="수정완료" name="pd_reEdit_btn" id="pd_reEdit_btn">
			                            </td>
			                        </tr>
			                    </table>
			                </form>
						</div>
					</div>
					<!-- 우측메뉴 종료 -->
				</div>				
			</div>		
		</div>
		<!-- 컨텐츠 끝 -->
		
		<!-- footer 시작 -->
		<div class="pd_add_footer">
			<%@ include file= "/footer/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>

</body>
</html>