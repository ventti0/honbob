<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/view/layout/sidebar.jsp" />

<blockquote>
<h1>회원 정보 수정</h1>
</blockquote>
<hr>
<form class="form-horizontal" action="/admin/ceoModify" method="post">
  <div class="form-group">
    <label for="inputMem_no" class="col-sm-2 control-label">회원 번호</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_no" name="mem_no" value="${ceo.mem_no }" readonly="readonly" placeholder="회원 번호">
    </div>
  </div>
  <div class="form-group">
    <label for="inputGroup_no" class="col-sm-2 control-label">그룹</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputGroup_no" name="mem_group_no" value="${ceo.mem_group_no }" placeholder="그룹">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_id" class="col-sm-2 control-label">아이디</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_id" name="mem_id" value="${ceo.mem_id }" placeholder="아이디">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_pw" class="col-sm-2 control-label">패스워드</label>
    <div class="col-sm-8">
      <input type="password" class="form-control" id="inputMem_pw" name="mem_pw" readonly="readonly" value="${ceo.mem_pw }" placeholder="패스워드">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_name" class="col-sm-2 control-label">이름</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_name" name="mem_name" value="${ceo.mem_name }" placeholder="이름">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_nick" class="col-sm-2 control-label">닉네임</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_nick" name="mem_nick" value="${ceo.mem_nick }" placeholder="닉네임">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_birth" class="col-sm-2 control-label">생년월일</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_birth" name="mem_birth" value="${ceo.mem_birth }" placeholder="생년월일">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_gen" class="col-sm-2 control-label">성별</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_gen" name="mem_gen" value="${ceo.mem_gen }" placeholder="성별">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_phone" class="col-sm-2 control-label">핸드폰 번호</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_phone" name="mem_phone" value="${ceo.mem_phone }" placeholder="핸드폰 번호">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_addr1" class="col-sm-2 control-label">집 주소</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_addr1" name="mem_addr1" value="${ceo.mem_addr1 }" placeholder="집 주소">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_addr2" class="col-sm-2 control-label">상세 주소</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_addr2" name="mem_addr2" value="${ceo.mem_addr2 }" placeholder="상세 주소">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_point" class="col-sm-2 control-label">포인트</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_point" name="mem_point" value="${ceo.mem_point }" placeholder="포인트">
    </div>
  </div>
  <div class="form-group">
    <label for="inputMem_acc_point" class="col-sm-2 control-label">누적 포인트</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputMem_acc_point" name="mem_acc_point" value="${ceo.mem_acc_point }" placeholder="누적 포인트">
    </div>
  </div>
  <div class="form-group">
    <label for="inputGrade" class="col-sm-2 control-label">등급</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputGrade" name="mem_grade" value="${ceo.mem_grade }" placeholder="등급">
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