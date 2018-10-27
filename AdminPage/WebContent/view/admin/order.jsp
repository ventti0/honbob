<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List"%>

<jsp:include page="/view/layout/sidebar.jsp" />

<blockquote>
<h1>주문</h1>
</blockquote>
<hr>


<div class="container-fluid">
	<div class="col-xs-1 col-md-1 col-lg-1"></div>
	<div class="col-xs-9 col-md-9 col-lg-9">

		<!-- 회원수, 검색 -->
		<div class="row">
			<div class="col-lg-7">
				
					<h3>주문 수 : ${totalCount }</h3>
				
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
			<div class="col-lg-5">
			<form action="/admin/order" method="get">
				<div class="input-group input-group-lg">
					<input type="text" class="form-control"
						placeholder="회원 이름을 입력하시오.." name="search"> <span
						class="input-group-btn">
						<button class="btn btn-default" type="submit" >검색</button>
					</span>
				</div>
				</form>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
		<!-- /.row -->
		<!-- 회원수, 검색 끝 -->

		<table class="table table-striped">
			<thead>
				<tr>
					<th>주문 번호</th>
					<th>주문 날짜</th>
					<th>회원 이름</th>
					<th>매장 이름</th>
					<th>메뉴 이름</th>
					<th>수량</th>
					<th>총 가격</th>
					<th style="width: 8%">처리 결과</th>
					<th style="width: 50px">수정</th>
					<th style="width: 50px">삭제</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="order" items="${list }">
					<tr>
						<td>${order.getOrder_no() }</td>
						<td>${order.getPay_time() }</td>
						<td>${order.getMem_name() }</td>
						<td>${order.getRes_name() }</td>
						<td>${order.getMenu_name() }</td>
						<td>${order.getQuantity() } ea</td>
						<td>${order.getOrder_sum() } 원</td>
						<td>${order.getOwner_check() }</td>
						<td><button type="button" class="btn btn-default" aria-label="Modify" onclick="location.href='/admin/orderModify?order_no=${order.getOrder_no() }'">
 						 <span class="glyphicon glyphicon-pencil" aria-hidden="false"></span>
						</button></td>
						<td><button type="button" class="btn btn-default" aria-label="Delete" onclick="location.href='/admin/orderDelete?mem_no=${order.getOrder_no() }'">
 						 <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


<div class="text-center col-lg-10">
	<ul class="pagination">

		<!-- 처음으로 가기 -->
		<c:if test="${paging.curPage ne 1 }">
			<li><a href="/admin/order?search=${search }" aria-label="First"> <span
					aria-hidden="true">처음</span>
			</a></li>
		</c:if>


		<!-- 이전 페이지 -->
		<c:if test="${paging.curPage eq 1 }">
			<li class="disabled"><span aria-hidden="true">&laquo;</span></li>
		</c:if>

		<c:if test="${paging.curPage ne 1 }">
			<li><a href="/admin/order?curPage=${paging.curPage-1 }&search=${search }"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
		</c:if>

		<!-- 페이징 리스트 -->
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
			var="i">
			<!-- 현재 보고있는 페이지만 강조 -->
			<c:if test="${paging.curPage eq i }">
				<li class="active"><a href="/admin/order?curPage=${i }&search=${search }">${i }</a></li>
			</c:if>
			<c:if test="${paging.curPage ne i }">
				<li><a href="/admin/order?curPage=${i }&search=${search }">${i }</a></li>
			</c:if>
		</c:forEach>
		<!-- 다음 페이지 -->
		<c:if test="${paging.curPage eq paging.totalPage }">
			<li class="disabled"><span aria-hidden="true">&raquo;</span></li>
		</c:if>

		<c:if test="${paging.curPage ne paging.totalPage }">
			<li><a href="/admin/order?curPage=${paging.curPage+1 }&search=${search }"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</c:if>
	</ul>
</div>
</div>
<jsp:include page="/view/layout/footer.jsp" />