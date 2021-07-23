<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/include/css/main.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="/include/js/main.js"></script>
</head>
<body>
	<div>
		<h3>메인화면 입니다.</h3>
	</div>
	<div>
		<button id="getMembersBtn" class="btn btn-default btn-sm" onclick="selectMembers();">고객정보</button>
		<button id="saleListBtn" class="btn btn-default btn-sm" onclick="goSaleList();">주문내역</button>
	</div>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th>아이디</th>
					<th>회원명</th>
					<th>회원주소</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody id="selectData"></tbody>
		</table>
	</div>
	<div class="col-xs-2">
		<br/>
		<br/>
		<br/>
		<h3>신규가입</h3>
		<input type="text" id="newId" class="form-control" name="memberId" placeholder="아이디"/><br/>
		<input type="password" id="newPwd" class="form-control" name="password" placeholder="패드워드"/><br/>
		<input type="text" id="newName" class="form-control" name="memberName" placeholder="이름"/><br/>
		<input type="text" id="newAdrs" class="form-control" name="address" placeholder="주소"/><br/>
		<button type="button" id="newMemberBtn" class="btn btn-default btn-sm" onclick="insertMember();">회원가입</button>
	</div>
	<div class="col-xs-2" style="clear: both;">
		<br/>
		<br/>
		<br/>
		<h3>상품등록</h3>
		<input type="text" id="newPrdtNm" class="form-control" placeholder="상품명" /><br/>
		<input type="text" id="newPrdtPr" class="form-control" placeholder="상품가격"  /><br/>
		<input type="text" id="newPrdtSz" class="form-control" placeholder="상품사이즈" /><br/>
		<input type="text" id="newPrdtCr" class="form-control" placeholder="상품색상" /><br/>
		<button type="button" id="newPrdtBtn" class="btn btn-default btn-sm" onclick="insertPrdt();">상품등록</button>
	</div>
	<hr/>
	
	<div class="container">
		<h3 style="text-align:center;">상품판매등록</h3>
		<input type="text" id="saleMemberId" class="form-control" placeholder="판매고객아이디" />
		<input type="text" id="salePrdtId" class="form-control" placeholder="판매상품아이디" />
		<input type="text" id="salePrdtCtn" class="for-control" placeholder="판매상품수량" />
		<input type="button" id="insertSaleBtn" class="btn btn-primary btn-sm" onclick="insertSale();"value="등록" />
	</div>
	<div style="clear: both;">
		<br/>
		<br/>
		<br/>
		<br/>
		<h3 style="text-align:center;">상품리스트</h3>
		<div class="col-xs-2">
			<input type="search" id="prdtSearch" class="form-control col-xs-3" placeholder="상품명 검색" />
		</div>
		<button type="button" id="prdtSearchBtn" class="btn btn-default btn-sm" onclick="searchProduct()" >확인</button>
		<div id="prdtDiv">
			<div id="tblDiv">
				<table class="table">
					<thead>
						<tr>
							<th style="width: 5%; important">ID</th>
							<th style="width: 40%; important">상품명</th>
							<th style="width: 20%; important">상품가격</th>
							<th style="width: 25%; important">상품사이즈</th>
							<th style="width: 10%; important">상품색상</th>
						</tr>
					</thead>
					<tbody id="selectPrdtData"></tbody>
				</table>
			</div>
			<div id="pageDiv"></div>
		</div>
	</div>
	<ul class="contextmenu">
		<li><a href="#">Simple link</a></li>
		<li><a href="#">Link to somewhere</a></li>
		<li><a href="#">Another link</a></li>
		<li><a href="#">Link to nowhere</a></li>
		<li><a href="#">Random link</a></li>
	</ul>
</body>
</html>