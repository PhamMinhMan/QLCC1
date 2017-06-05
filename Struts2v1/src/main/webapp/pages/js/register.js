$(document).ready(function(){
    $("#startclass").change(function(){
    	var startclass = $(this).val();
    	if (startclass == "03"){
    		setStartTime("","");
    	}
    });
    
    $("#endclass").change(function(){
    	var endclass = $(this).val();
    	if (endclass == "03"){
    		setEndTime("","");
    	}
    });
});

function setStartTime(hour, minute){
	$("#starttime_hh").val(hour);
	$("#starttime_mm").val(minute);
}

function setEndTime(hour, minute){
	$("#endtime_hh").val(hour);
	$("#endtime_mm").val(minute);
}

function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
    } 
}