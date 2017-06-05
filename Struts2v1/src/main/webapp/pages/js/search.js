$(document).ready(function() {
	$(".del").click(function(){
		var id = $(this).attr('id');
		var result = confirm("Bạn có chắc chắn muốn xóa?");
		if(!result){
			return false;
		}
	});
	
	nextMonthHiiden();
});

function nextMonthHiiden(){
	var date = $("#date").text();
	if (date.trim().length == 7){
		var year = date.substring(0, 4);
		var month = date.substring(5);
		var d = new Date();
	    var m = d.getMonth()+1;
	    var y = d.getFullYear();
	    if (parseInt(year) > y || (parseInt(year) == y && parseInt(month) >= m)){
	    	$("#next").prop( "disabled", true );
	    }
	}
}