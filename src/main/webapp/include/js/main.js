

$(document).ready(function() {
	console.log("상품리스트를 가져옵니다.");
	selectProductAll();
	
	$(document).contextmenu(function(e){
		//Get window size:
		var winWidth = $(document).width();
		var winHeight = $(document).height();
		//Get pointer position:
		var posX = e.pageX;
		var posY = e.pageY;
		//Get contextmenu size:
		var menuWidth = $(".contextmenu").width();
		var menuHeight = $(".contextmenu").height();
		//Security margin:
		var secMargin = 10;
		//Prevent page overflow:
		if(posX + menuWidth + secMargin >= winWidth
		&& posY + menuHeight + secMargin >= winHeight){
		  //Case 1: right-bottom overflow:
		  posLeft = posX - menuWidth - secMargin + "px";
		  posTop = posY - menuHeight - secMargin + "px";
		}
		else if(posX + menuWidth + secMargin >= winWidth){
		  //Case 2: right overflow:
		  posLeft = posX - menuWidth - secMargin + "px";
		  posTop = posY + secMargin + "px";
		}
		else if(posY + menuHeight + secMargin >= winHeight){
		  //Case 3: bottom overflow:
		  posLeft = posX + secMargin + "px";
		  posTop = posY - menuHeight - secMargin + "px";
		}
		else {
		  //Case 4: default values:
		  posLeft = posX + secMargin + "px";
		  posTop = posY + secMargin + "px";
		};
		//Display contextmenu:
		$(".contextmenu").css({
		  "left": posLeft,
		  "top": posTop
		}).show();
		//Prevent browser default contextmenu.
		return false;
	});
	  //Hide contextmenu:
	$(document).click(function(){
		$(".contextmenu").hide();
	});
			
});
	
	function selectMembers() {
		console.log("유저정보 가져오기 클릭!");
		$.ajax({
			type: "GET",
			data: "",
			dataType: "json",
			url: "/member",
			success: function(data) {
				if(data) {
					console.log(data);
					let tbody = $("#selectData");
					let html = "";
					tbody.empty();
					for(let i=0; i<data.length; i++) {
						html += "<tr>";
						html += "<td><a href='#' onclick='viewMemberInfo(this);'>" + data[i].memberId + "</a></td>";
						html += "<td>" + data[i].memberName + "</td>";
						html += "<td>" + data[i].address + "</td>";
						html += "<td>" + data[i].signInDate + "</td>";
						html += "</tr>";
					}
					
					tbody.append(html);
				}
			},
			error: function(error) {
				console.log(error);
			}
		});
	}
	
	function insertMember() {
		console.log("신규가입정보를 입력합니다.");
		let newId = $("#newId").val();
		let newPwd = $("#newPwd").val();
		let newName = $("#newName").val();
		let newAdrs = $("#newAdrs").val();
		let newSignDate = new Date();
		newSignDate = newSignDate.toLocaleString();
		console.log("현재시간: "+newSignDate);
		
		$.ajax({
			type:"POST",
			data: {
				'memberId' : newId,
				'memberName' : newName,
				'password' : newPwd,
				'address' : newAdrs,
				'signInDate' : newSignDate,
			},
			dataType: "text",
			url: "/member/insert",
			success: function(data) {
				if(data==="0") {
					alert("회원가입 완료.");
					location.reload();
				} else {
					alert("회원가입 정보를 정확히 입력해주세요.");
				}
			},
			error: function(error) {
				alert("회원가입을 도중 문제가 발생하였습니다.");
			}
		});
	}
	
	function insertPrdt() {
		let newPrdtNm = $("#newPrdtNm").val();
		let newPrdtPr = $("#newPrdtPr").val();
		let newPrdtSz = $("#newPrdtSz").val();
		let newPrdtCr = $("#newPrdtCr").val();
		
		$.ajax({
			type: "POST",
			data: {
				'prdtname' : newPrdtNm,
				'prdtPrice' : newPrdtPr,
				'prdtSize' : newPrdtSz,
				'prdtColor' : newPrdtCr
			},
			dataType: "text",
			url: "/product/insert",
			success: function(data) {
				if(data==="0") {
					alert("상품등록 완료.");
					location.reload();
				} 
			},
			error : function(error) {
				alert("상품등록 중 문제가 발생하였습니다.");
			}
		});
	}
	
	function selectProductAll() {
		$.ajax({
			type: "GET",
			dataType: "json",
			url: "/product/selectAll",
			success: function(data) {
				if(data) {
					console.log(data);
					prdtPaging(data);
				}
			}
		});
	}
	
	function selectPrdtPage(target) {
		let page = target.innerText;
		console.log(page);
		let perPage = 0;
		
		$.ajax({
			type: "GET",
			data: {
				page : page,
				/* perPage : perPage, */
			},
			dataType: "json",
			url: "/product/selectPrdtPage",
			success: function(data) {
				console.log(data);
				prdtPaging(data);
			},
			error: function(error) {
				alert(error);
			}
		});
	}
	
	function searchProduct() {
		let prdtSearch = $("#prdtSearch").val();
		if(prdtSearch==="" || prdtSearch===" ") {
			selectProductAll();
		}
		$.ajax({
			type: "GET",
			data: { prdtname: prdtSearch},
			dataType: 'json',
			url: "/product/searchProduct",
			success: function(data) {
				console.log(data);
				let pageDiv = $("#pageDiv");
				let tbody = $("#selectPrdtData");
				let htmlForPrdtTbl = "";
				
				tbody.empty();
				pageDiv.empty();
				for(let i=0; i<data.length; i++) {
					htmlForPrdtTbl += "<tr>";
					htmlForPrdtTbl += "<td>" + data[i].prdtId + "</td>";
					htmlForPrdtTbl += "<td>" + data[i].prdtname + "</td>";
					htmlForPrdtTbl += "<td>" + data[i].prdtPrice + "</td>";
					htmlForPrdtTbl += "<td>" + data[i].prdtSize + "</td>";
					htmlForPrdtTbl += "<td>" + data[i].prdtColor + "</td>";
					htmlForPrdtTbl += "</tr>";
				}
				
				tbody.append(htmlForPrdtTbl);
				
			}
		});
		
	}
	
	function prdtPaging(plist) {
		let tbody = $("#selectPrdtData");
		let htmlForPrdtTbl = "";
		let pageDiv = $("#pageDiv");
		let htmlForPrdtPage = "";
		
		tbody.empty();
		pageDiv.empty();
		
		console.log(plist.totalPages);
		for(let i=1; i<=plist.totalPages; i++) {
			htmlForPrdtPage += "<button type='button' class='btn btn-default btn-sm' onclick='selectPrdtPage(this);'>"+i+"</button>";
		}
		pageDiv.append(htmlForPrdtPage);
		
		for(let i=0; i<plist.content.length; i++) {
			htmlForPrdtTbl += "<tr>";
			htmlForPrdtTbl += "<td>" + plist.content[i].prdtId + "</td>";
			htmlForPrdtTbl += "<td>" + plist.content[i].prdtname + "</td>";
			htmlForPrdtTbl += "<td>" + plist.content[i].prdtPrice + "</td>";
			htmlForPrdtTbl += "<td>" + (plist.content[i].prdtSize==null ? "단일" : plist.content[i].prdtSize) + "</td>";
			htmlForPrdtTbl += "<td>" + (plist.content[i].prdtColor==null ? "단일" : plist.content[i].prdtColor) + "</td>";
			htmlForPrdtTbl += "</tr>";
		}
		
		tbody.append(htmlForPrdtTbl);
	}
	
	function viewMemberInfo(target) {
		console.log(target.innerText);
		let memberId = target.innerText;
		
		location.href = "/minfo?memberId=" + memberId;
	}
	
	function insertSale() {
		let sMemberId = $("#saleMemberId").val();
		let sPrdtId = $("#salePrdtId").val();
		let sPrdtCtn = $("#salePrdtCtn").val();
		let sDate = new Date();
		sDate = sDate.toLocaleString();
		
		$.ajax({
			type: "POST",
			data: {
				saleMemberId : sMemberId,
				salePrdtId : sPrdtId,
				salePrdtCtn : sPrdtCtn,
				saleDate : sDate
			},
			dataType: "text",
			url: "/insertSale",
			success: function(data) {
				if(data==="0") {
					alert("판매등록 되었습니다.");
				}
			},
			error: function(error) {
				alert("판매등록 중 문제가 발생하였습니다.");
			}
		})
		
	}
	
	function goSaleList() {
		location.href = "/viewSaleList";
	}