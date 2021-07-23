<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/include/css/loginPage.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/include/js/loginPage.js"></script>
</head>
<body>
	<div class="simple-login-container">
	    <h2>LOGIN</h2>
	    <div class="row">
	        <div class="col-md-12 form-group">
	            <input type="text" id="memberId" class="form-control" placeholder="아이디 입력">
	        </div>
	    </div>
	    <div class="row">
	        <div class="col-md-12 form-group">
	            <input type="password" id="password" placeholder="비밀번호 입력" class="form-control">
	        </div>
	    </div>
	    <div class="row">
	        <div class="col-md-12 form-group">
	            <input type="button" id="submitBtn" class="btn btn-block btn-login" value="로그인">
	        </div>
	    </div>
	</div>
</body>
</html>