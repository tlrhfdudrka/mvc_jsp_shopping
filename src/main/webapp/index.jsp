<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="${path}/header/header.css" />
<link rel="stylesheet" href="${path}/main/main.css" />

<title>main</title>
</head>
<body>

	<div class="wrap">
		<div id="header"><%@include file="./header/header.jsp"%></div>
		<div class="main_visula">
			<video autoplay loop muted style="width: 100%;">
				<source src="./image/mainvideo.mp4" type="video/mp4">
			</video>
		</div>
	</div>

<script src="${path}/header/header.js"></script>
</body>
</html>