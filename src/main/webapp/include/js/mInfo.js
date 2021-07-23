
$(document).ready(function() {
	let queryStr = new URLSearchParams(location.search);
	let memberId = queryStr.get("memberId");
	console.log(memberId);
	selectMemberInfo(memberId);
	
});

function selectMemberInfo(memberId) {

	$.ajax({
		type: "GET",
		data: {
			memberId : memberId	
		},
		dataType: "json",
		url: "/member/info",
		success: function(data) {
			console.log(data);
			$("#inputMemberId").val(data.memberId);
			$("#inputMemberName").val(data.memberName);
			$("#inputAddress").val(data.address);
		},
		error: function(error) {
			console.log(error);
		}
	});
}