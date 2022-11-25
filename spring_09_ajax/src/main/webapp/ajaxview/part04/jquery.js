$(document).ready(function () {
  $("#btn").on("click", proceed);
});

/*
function process() {
	$.ajax({
		type:'GET',
		dataType: "json",
		url:'searchOpen.do?query='+$('#search').val(),
		success:viewMessage,
		error:function(xhr, textStatus, error){
			alert(xhr.status);
		}
	});

}
*/

function proceed() {
  alert("test");
  $.ajax({
    type: "GET",
    url: "https://dapi.kakao.com/v3/search/book?target=title",
    headers: { "Authorization": "KakaoAK 118894c41844b11bc6fc7b443dae0687" },
    dataType: "json",
    data: { "query": $("#search").val() },
    success: viewMessage,
  });
}

function viewMessage(res) {
  //console.log(res);
  //alert(res.documents[0].title);
  $("#wrap table").empty();
  $("#wrap table").append(`<tr><th>제목</th><th>사진</th><th>가격</th></tr>`);
  $.each(res.documents, function (index, element) {
    $("#wrap table").append(
      `<tr><td>${element.title}</td><td><a href="${element.url}"><img src="${element.thumbnail}" /></a></td><td>${element.price}</td></tr>`
    );
  });
}
