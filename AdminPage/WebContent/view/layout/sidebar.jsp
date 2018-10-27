<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!-- 사이드바 css -->
<link href="/css/admin.css" rel="stylesheet">

<!-- <script type="text/javascript"> -->
<!-- // 	$(document).ready(function() { -->
<!-- // 		$("#memberList").click(function() { -->

<!-- // 			$.ajax({ -->
<!-- // 				type : "get", -->
<!-- // 				url : "/admin/member", -->
<!-- // 				dataType : "html", -->
<!-- // 				success : function(d) { -->
<!-- // 					alert("성공"); -->
<!-- // 					$("#resultLayout").html(d); -->
<!-- // 				}, -->
<!-- // 				error : function(e) { -->
<!-- // 					alert("실패"); -->
<!-- // 				} -->
<!-- // 			}) -->
<!-- // 		}); -->
<!-- // 	}); -->
<!-- </script> -->

<style>
.table {
width: 1100px;
}
</style>

</head>
<body>
	
	<div class="container-fluid">
		<div class="row profile">
			<div class="col-md-2">
				<div class="profile-sidebar">
					<!-- SIDEBAR USERPIC -->
					<div class="profile-userpic">
						<img src="/img/saitama.jpg" class="img-responsive" alt="">
					</div>
					<!-- END SIDEBAR USERPIC -->
					<!-- SIDEBAR USER TITLE -->
					<div class="profile-usertitle">
						<div class="profile-usertitle-name">김동현</div>
						<div class="profile-usertitle-job">Administrator</div>
					</div>
					<!-- END SIDEBAR USER TITLE -->
					<!-- SIDEBAR BUTTONS -->
					<div class="profile-userbuttons">
						<button type="button" class="btn btn-success btn-sm">Follow</button>
						<button type="button" class="btn btn-danger btn-sm">Message</button>
					</div>
					<!-- END SIDEBAR BUTTONS -->
					<!-- SIDEBAR MENU -->
					<div class="profile-usermenu">
						<ul class="nav">
							<li class="active"><a href="#"> <i
									class="glyphicon glyphicon-home"></i> Overview
							</a></li>
							<li><a href="/admin/member" id="memberList""> <i
									class="glyphicon glyphicon-user"></i> 일반 회원 목록
							</a></li>
							<li><a href="/admin/ceo"> <i
									class="glyphicon glyphicon-user"></i> 사장님 목록
							</a></li>
							<li><a href="/admin/resWait"> <i
									class="glyphicon glyphicon glyphicon glyphicon-cutlery"></i> 맛집
									승인 대기
							</a></li>
							<li><a href="/admin/order"> <i
									class="glyphicon glyphicon glyphicon glyphicon-cutlery"></i> 주문
							</a></li>
							<li><a href="#"> <i
									class="glyphicon glyphicon glyphicon glyphicon-cutlery"></i> 신고
									리스트
							</a></li>
							<li><a href="#"> <i
									class="glyphicon glyphicon glyphicon glyphicon-cutlery"></i>
									사이트 통계
							</a></li>
							<li><a href="/admin/orderStats"> <i
									class="glyphicon glyphicon glyphicon glyphicon-cutlery"></i> 주문
									통계
							</a></li>

						</ul>
					</div>
					<!-- END MENU -->
				</div>
			</div>

			<div class="col-md-10">
				<!-- content 영역 -->
				<div class="profile-content">