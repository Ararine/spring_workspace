//https://www.w3schools.com/jquery/jquery_ajax_get_post.asp
//https://www.w3schools.com/jquery/jquery_ref_ajax.asp

$(document).ready(function() {
	$("#btn").on("click", process);
});

//data : 'name=' + $('#name').val(),
/*
function process() {
	$.ajax({
		type : 'POST',
		dataType : 'text',
		data : {name:$('#name').val()},
		url : 'name.do',
		success: viewMessage
	});
}
*/

/* post 방식일 때는 아래와 같은 방식으로 실행 가능
	$.post(url, data, success)*/
function process() {
	alert('test');
	$.post('name.do', {name:$('#name').val()}, viewMessage);
}

function viewMessage(res) {
	$("#wrap").html(res);
}