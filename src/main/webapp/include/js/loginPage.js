$(document).ready(function() {
	
/*	$.ajax({
		type: "GET",
		url: "/login/loginCheck",
		success: function(data) {
			if(data==="true") {
				location.href="/main";
				alert("세션이 남아있어 메인화면으로 이동합니다.");
			}
		},
		error: function() {
			alert("세션 확인 중 에러가 발생 했습니다.");
		}
	})*/
	
	
	$("#submitBtn").click(function() {
		let memberId = $("#memberId").val();
		let password = $("#password").val();
		
		$.ajax({
			type: "POST",
			data: {
				'memberId' : memberId,
				'password' : password,
			},
			dataType: 'text',
			url: "/login/newLogin",
			success: function(data) {
				switch(data) {
					case "fail_id" :
						alert("아이디가 일치하지 않습니다.");
						break;
					case "fail_pwd" :
						alert("비밀번호가 일치하지 않습니다.");
						break;
					case "success" :
						location.href = "/main";
				}
			}
		});
	});
});