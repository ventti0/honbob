<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List"%>

<jsp:include page="/view/layout/sidebar.jsp" />

<blockquote>
<h1>일반 회원 목록</h1>
</blockquote>
<hr>


<div class="container-fluid">
	<div class="col-xs-1 col-md-1 col-lg-1"></div>
	<div class="col-xs-9 col-md-9 col-lg-9">

		<!-- 회원수, 검색 -->
		<div class="row">
			<div class="col-lg-7">
				
					<h3>사장님수 : ${totalCount }명</h3>
				
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
			<div class="col-lg-5">
			<form action="/admin/ceo" method="get">
				<div class="input-group input-group-lg">
					<input type="text" class="form-control"
						placeholder="사장님 이름을 입력하시오.." name="search"> <span
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
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>생일</th>
					<th>핸드폰 번호</th>
					<th>주소</th>
					<th style="width: 8%">포인트</th>
					<th style="width: 50px">수정</th>
					<th style="width: 50px">삭제</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="ceo" items="${ceoList }">
					<tr>
						<td>${ceo.getMem_no() }</td>
						<td>${ceo.getMem_name() }</td>
						<td>${ceo.getMem_id() }</td>
						<td>${ceo.getMem_birth() }</td>
						<td>${ceo.getMem_phone() }</td>
						<td>${ceo.getMem_addr1() }</td>
						<td>${ceo.getMem_point() }</td>
						<td><button type="button" class="btn btn-default" aria-label="Modify" onclick="location.href='/admin/ceoModify?mem_no=${ceo.getMem_no() }'">
 						 <span class="glyphicon glyphicon-pencil" aria-hidden="false"></span>
						</button></td>
						<td><button type="button" class="btn btn-default" aria-label="Delete" onclick="location.href='/admin/ceoDelete?mem_no=${ceo.getMem_no() }&curPage=${paging.curPage }'">
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
			<li><a href="/admin/ceo?search=${search }" aria-label="First"> <span
					aria-hidden="true">처음</span>
			</a></li>
		</c:if>


		<!-- 이전 페이지 -->
		<c:if test="${paging.curPage eq 1 }">
			<li class="disabled"><span aria-hidden="true">&laquo;</span></li>
		</c:if>

		<c:if test="${paging.curPage ne 1 }">
			<li><a href="/admin/ceo?curPage=${paging.curPage-1 }&search=${search }"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
		</c:if>

		<!-- 페이징 리스트 -->
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
			var="i">
			<!-- 현재 보고있는 페이지만 강조 -->
			<c:if test="${paging.curPage eq i }">
				<li class="active"><a href="/admin/ceo?curPage=${i }&search=${search }">${i }</a></li>
			</c:if>
			<c:if test="${paging.curPage ne i }">
				<li><a href="/admin/ceo?curPage=${i }&search=${search }">${i }</a></li>
			</c:if>
		</c:forEach>
		<!-- 다음 페이지 -->
		<c:if test="${paging.curPage eq paging.totalPage }">
			<li class="disabled"><span aria-hidden="true">&raquo;</span></li>
		</c:if>

		<c:if test="${paging.curPage ne paging.totalPage }">
			<li><a href="/admin/ceo?curPage=${paging.curPage+1 }&search=${search }"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</c:if>
	</ul>
</div>
</div>
<jsp:include page="/view/layout/footer.jsp" />