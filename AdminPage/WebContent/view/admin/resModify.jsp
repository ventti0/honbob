<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/view/layout/sidebar.jsp" />

<blockquote>
<h1>매장 정보 수정</h1>
</blockquote>
<hr>
<form class="form-horizontal" action="/admin/resModify" method="post">
  <div class="form-group">
    <label for="inputres_no" class="col-sm-2 control-label">매장 번호</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputRes_no" name="res_no" value="${res.res_no }" readonly="readonly" placeholder="매장 번호">
    </div>
  </div>
  <div class="form-group">
    <label for="inputOwner_no" class="col-sm-2 control-label">사업자(회원 번호)</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputOwner_no" name="owner_no" value="${res.owner_no }" readonly="readonly" placeholder="사업자(회원 번호)">
    </div>
  </div>
  <div class="form-group">
    <label for="inputRes_roup_no" class="col-sm-2 control-label">매장 분류 번호</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputRes_group_no" name="res_group_no" value="${res.res_group_no }" placeholder="매장 분류 번호">
    </div>
  </div>
  <div class="form-group">
    <label for="inputRes_name" class="col-sm-2 control-label">매장 이름</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputRes_name" name="res_name" value="${res.res_name }" placeholder="매장 이름">
    </div>
  </div>
  <div class="form-group">
    <label for="inputRes_phone" class="col-sm-2 control-label">연락번호</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputRes_phone" name="res_phone" value="${res.res_phone }" placeholder="연락 번호">
    </div>
  </div>
  <div class="form-group">
    <label for="inputRes_addr1" class="col-sm-2 control-label">매장 기본 주소</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputRes_addr1" name="res_addr1" value="${res.res_addr1 }" placeholder="매장 기본 주소">
    </div>
  </div>
  <div class="form-group">
    <label for="inputRes_addr2" class="col-sm-2 control-label">매장 상세 주소</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputRes_addr2" name="res_addr2" value="${res.res_addr2 }" placeholder="매장 상세 주소">
    </div>
  </div>
  <div class="form-group">
    <label for="inputRes_busi_hour" class="col-sm-2 control-label">영업 시간</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputRes_busi_hour" name="res_busi_hour" value="${res.res_busi_hour }" placeholder="영업 시간">
    </div>
  </div>
  <div class="form-group">
    <label for="inputRes_total_score" class="col-sm-2 control-label">평점</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputRes_total_score" name="res_total_score" value="${res.res_total_score }" placeholder="평점">
    </div>
  </div>
  <div class="form-group">
    <label for="inputRes_total_score_cnt" class="col-sm-2 control-label">평점 평가자수</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputRes_total_score_cnt" name="res_total_score_cnt" value="${res.res_total_score_cnt }" placeholder="평점 평가 지수">
    </div>
  </div>
  <div class="form-group">
    <label for="inputRes_alone_score" class="col-sm-2 control-label">혼밥 지수</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputㄲes_alone_score" name="res_alone_score" value="${res.res_alone_score }" placeholder="혼밥 지수">
    </div>
  </div>
  <div class="form-group">
    <label for="inputRes_alone_score_cnt" class="col-sm-2 control-label">혼밥 지수 평가자수</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputRes_alone_score_cnt" name="res_alone_score_cnt" value="${res.res_alone_score_cnt }" placeholder="혼밥 지수 평가자수">
    </div>
  </div>
  <div class="form-group">
    <label for="inputCan_deliver" class="col-sm-2 control-label">배달 가능</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputCan_deliver" name="can_deliver" value="${res.can_deliver }" placeholder="배달 가능">
    </div>
  </div>
  <div class="form-group">
    <label for="inputCan_park" class="col-sm-2 control-label">주차가능</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputCan_park" name="can_park" value="${res.can_park }" placeholder="주차 가능">
    </div>
  </div>
  <div class="form-group">
    <label for="inputCan_advance_pay" class="col-sm-2 control-label">미리 결제 가능</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputCan_advance_pay" name="can_advance_pay" value="${res.can_advance_pay }" placeholder="미리 결제 가능">
    </div>
  </div>
  <div class="form-group">
    <label for="inputCan_alone_drink" class="col-sm-2 control-label">혼술 가능</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputCan_alone_drink" name="can_alone_drink" value="${res.can_alone_drink }" placeholder="혼술 가능">
    </div>
  </div>
  <div class="form-group">
    <label for="inputCapacity" class="col-sm-2 control-label">매장 수용량</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputCapacity" name="capacity" value="${res.capacity }" placeholder="매장 수용량">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAdd_info" class="col-sm-2 control-label">부가 정보</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputAdd_info" name="add_info" value="${res.add_info }" placeholder="부가 정보">
    </div>
  </div>
  <div class="form-group">
    <label for="inputComment_cnt" class="col-sm-2 control-label">댓글 수</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputComment_cnt" name="comment_cnt" value="${res.comment_cnt }" placeholder="댓글 수">
    </div>
  </div>
  <div class="form-group">
    <label for="inputActivation" class="col-sm-2 control-label">활성화 여부</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputActivation" name="activation" value="${res.activation }" placeholder="활성화 여부">
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