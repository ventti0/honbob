<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/view/layout/sidebar.jsp" />

<blockquote>
<h1>주문 수정</h1>
</blockquote>
<hr>
<form class="form-horizontal" action="/admin/orderModify" method="post">
  <div class="form-group">
    <label for="inputMem_no" class="col-sm-2 control-label">주문 번호</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_no" name="order_no" value="${order.order_no }" readonly="readonly" placeholder="회원 번호">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_no" class="col-sm-2 control-label">주문 날짜</label>
    <div class="col-sm-8">
      <input type="date" class="form-control" id="inputMem_no" name="order_no" value="${order.pay_time }" readonly="readonly" placeholder="회원 번호">
    </div>
  </div>
  <div class="form-group">
    <label for="inputGroup_no" class="col-sm-2 control-label">회원 이름</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputGroup_no" name="mem_name" value="${order.mem_name }" placeholder="회원 이름">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_id" class="col-sm-2 control-label">매장 이름</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_id" name="res_name" value="${order.res_name }" placeholder="매장 이름">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_pw" class="col-sm-2 control-label">메뉴 이름</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_pw" name="menu_name" value="${order.menu_name }" placeholder="메뉴 이름">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_name" class="col-sm-2 control-label">수량</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_name" name="quantity" value="${order.quantity }" placeholder="수량">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_nick" class="col-sm-2 control-label">총가격</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_nick" name="order_sum" value="${order.order_sum } 원" placeholder="총가격">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_birth" class="col-sm-2 control-label">처리 결과</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_birth" name="owner_check" value="${order.owner_check }" placeholder="처리 결과">
    </div>
  </div>
  
  <div class="form-group">
    <div class="text-center">
      <button type="submit" class="btn btn-default">수정</button>
      <button type="button" class="btn btn-default" onclick="history.go(-1);">취소</button>
    </div>
  </div>

</form>

<jsp:include page="/view/layout/footer.jsp" />