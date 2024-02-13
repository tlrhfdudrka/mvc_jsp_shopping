<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <!-- 반응형 웹 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="${path}/common/css/header.css">
    <link rel="stylesheet" href="${path}/common/css/footer.css">
    <link rel="stylesheet" href="${path}/customer/mypage/css/mypage.css">
    <script src="${path}/customer/mypage/js/mypage.js"></script>
</head>
<body>
<div class="wrap">
    <!-- header -->
    <%@ include file="/common/header.jsp" %>

    <!-- 컨텐츠 시작 -->
    <div id="mypage-form">
        <div id="contents" class="clearfix">
            <div class="caption">
                <a href="" class="create-account">MY ETC INFO</a>
                <a href="" class="create-account_2">My ORDER INFO</a>
            </div>

            <form action="" class="top">
                <ul class="clearfix">
                    <li>
                        <div class="area">
                            <a href="" class="title">Order</a>
                            <a href="" class="title_con"><br>고객님께서 주문하신 상품의 주문내역을 확인하실 수 있습니다.</a>
                        </div>
                    </li>

					<li>
                        <div class="area">
                            <a href="../profile/profile.jsp" class="title">Profile</a>
                            <a href="" class="title_con">회원이신 고객님의 개인정보를 관리하는 공간입니다.</a>
                        </div>
                    </li>
                </ul>

                <ul class="clearfix">
                	<li>
                        <div class="area">
                            <a href="" class="title">Wishlist</a>
                            <a href="" class="title_con">관심상품으로 등록하신 상품의 목록을 보여드립니다.</a>
                        </div>
                    </li>
                    
                    <li>
                        <div class="area">
                            <a href="" class="title">Mileage</a>
                            <a href="" class="title_con">적립금은 상품 구매시 사용하실 수 있습니다.</a>
                        </div>
                    </li>
                </ul>

                <ul class="clearfix">
                    <li>
                        <div class="area">
                            <a href="" class="title">Coupon</a>
                            <a href="" class="title_con">고객님이 보유하고 계신 쿠폰내역을 보여드립니다.</a>
                        </div>
                    </li>
                    
                    <li>
                        <div class="area">
                            <a href="" class="title">Board</a>
                            <a href="" class="title_con">고객님께서 작성하신 게시물을 관리하는 공간입니다.</a>
                        </div>
                    </li>
                </ul>

                <ul class="clearfix">
                	<li>
                        <div class="area">
                            <a href="" class="title">Address</a>
                            <a href="" class="title_con">자주 사용하는 배송지를 등록하고 관리하실 수 있습니다.</a>
                        </div>
                    </li>    

                    <li>
                        <div class="area">
                            <a href="" class="title">Subscription</a>
                            <a href="" class="title_con">고객님께서 신청하신 정기배송의 신청 정보 및 내역을 확인하실 수 있습니다.</a>
                        </div>
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <!-- footer -->
    <%@ include file="/common/footer.jsp" %>
  </div>
 </body>
 </html>
