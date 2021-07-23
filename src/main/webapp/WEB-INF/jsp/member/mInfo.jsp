<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객정보화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/include/js/mInfo.js" type="text/javascript"></script>
</head>
<body>
	<button type="button" class="btn btn-primary btn-sm" onclick="history.back();" style="margin: 10px;">뒤로가기</button>
	<h3 style="margin-left: 200px;">고객정보</h3><br/>
	<div class="form-group has-success col-xs-4" style="clear: both;">
	  <label class="control-label" for="inputSuccess1">아이디</label>
	  <input type="text" class="form-control" id="inputUserId">
	</div>
	<div class="form-group has-warning col-xs-4" style="clear: both;">
	  <label class="control-label" for="inputWarning1">이름</label>
	  <input type="text" class="form-control" id="inputUsername">
	</div>
	<div class="form-group has-error col-xs-4" style="clear: both;">
	  <label class="control-label" for="inputError1">주소</label>
	  <input type="text" class="form-control" id="inputAddress">
	</div>
	<div class="has-success col-xs-4" style="clear: both;">
	  <div class="checkbox">
	    <label>
	      <input type="checkbox" id="checkboxSuccess" value="option1">
	      Checkbox with success
	    </label>
	  </div>
	</div>
	<div class="has-warning col-xs-4" style="clear: both;">
	  <div class="checkbox">
	    <label>
	      <input type="checkbox" id="checkboxWarning" value="option1">
	      Checkbox with warning
	    </label>
	  </div>
	</div>
	<div class="has-error col-xs-4" style="clear: both;">
	  <div class="checkbox">
	    <label>
	      <input type="checkbox" id="checkboxError" value="option1">
	      Checkbox with error
	    </label>
	  </div>
	</div>
</body>
</html>